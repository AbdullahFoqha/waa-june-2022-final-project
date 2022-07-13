package edu.miu.waabackend.controller;

import edu.miu.waabackend.config.RoutingValues;
import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.service.IStudentService;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentService studentService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StudentController(IStudentService studentService, RabbitTemplate rabbitTemplate) {
        this.studentService = studentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PreAuthorize("hasRole('student')")
    @GetMapping(value = "")
    public ResponseEntity<List<DTOEntity>> getAllStudents() {
        return ResponseEntity.ok(studentService.lstGetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEntity> getStudentById(@PathVariable long id) {
        return ResponseEntity.ok(studentService.GetByPK(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto student) {
        rabbitTemplate.convertAndSend(RoutingValues.EXCHANGE_ONE.toString(), RoutingValues.ROUTING_KEY_ONE.toString(), student);

        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(student.getPassword());

        List<String> roles = new ArrayList<>();
        roles.add("faculty");

        UserRepresentation user = new UserRepresentation();
        user.setUsername(student.getEmail());
        user.setFirstName(student.getFirstName());
        user.setLastName(student.getLastname());
        user.setEmail(student.getEmail());
        user.setRealmRoles(roles);
        user.setCredentials(Collections.singletonList(passwordCredentials));
        user.setEnabled(true);
        getInstance().create(user);

        List<RoleRepresentation> roleToAdd = new LinkedList<>();
        roleToAdd.add(getKeycloak()
                .realm("waa-server")
                .roles()
                .get("faculty")
                .toRepresentation()
        );

        List<UserRepresentation> users = getInstance().search(student.getEmail());

        UserResource userResource = getInstance().get(users.get(0).getId());
        userResource.roles().realmLevel().add(roleToAdd);

        System.out.println("id ==> " + users.get(0).getId());

        student.setUserId(users.get(0).getId());
        studentService.Insert(student);

        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student) {
        studentService.Update(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.Delete(id);
    }

    @GetMapping("/state")
    public List<Student> filterStudentByState(@RequestParam String name) {
        return studentService.getStudentByState(name);
    }

    @GetMapping("/city")
    public List<Student> filterStudentByCity(@RequestParam String name) {
        return studentService.getStudentByCity(name);
    }

    @GetMapping("/major")
    public List<Student> filterStudentByMajor(@RequestParam String name) {
        return studentService.getStudentByMajor(name);
    }

    @GetMapping("/lastName")
    public List<Student> filterStudentByLastName(@RequestParam String name) {
        return studentService.getStudentByLastName(name);
    }

    private Keycloak getKeycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("waa-server")
                .clientId("admin-cli")
                .clientSecret("c7giVqTqfrElCDdnhmIi4q1VCd7XKF8w")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .resteasyClient(new ResteasyClientBuilder()
                        .connectionPoolSize(10)
                        .build()
                )
                .build();
    }

    private UsersResource getInstance() {
        return getKeycloak().realm("waa-server").users();
    }
}
