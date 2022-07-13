package edu.miu.waabackend.controller;

import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.FacultyDto;
import edu.miu.waabackend.service.IFacultyService;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/faculties")
public class FacultyController {

    private final IFacultyService facultyService;

    @Autowired
    public FacultyController(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<List<DTOEntity>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.lstGetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEntity> getFacultyById(@PathVariable String id) {
        return ResponseEntity.ok(facultyService.GetByPK(id));
    }

    @PostMapping
    public ResponseEntity<DTOEntity> saveFaculty(@RequestBody FacultyDto facultyDto) {

        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(facultyDto.getPassword());

        UserRepresentation user = new UserRepresentation();
        user.setUsername(facultyDto.getEmail());
        user.setFirstName(facultyDto.getFirstName());
        user.setLastName(facultyDto.getLastName());
        user.setEmail(facultyDto.getEmail());
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

        List<UserRepresentation> users = getInstance().search(facultyDto.getEmail());

        UserResource userResource = getInstance().get(users.get(0).getId());
        userResource.roles().realmLevel().add(roleToAdd);

        facultyDto.setUserId(users.get(0).getId());

        facultyService.Insert(facultyDto);
        return ResponseEntity.ok(facultyDto);
    }

    @PutMapping
    public ResponseEntity<DTOEntity> updateFaculty(@RequestBody FacultyDto facultyDto) {
        facultyService.Update(facultyDto);
        return ResponseEntity.ok(facultyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable long id) {
        facultyService.Delete(id);
    }

    private Keycloak getKeycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("waa-server")
                .clientId("admin-cli")
                .clientSecret("YG9valQNIwJBqkoUOUwO6f7qRHvHddgo")
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
