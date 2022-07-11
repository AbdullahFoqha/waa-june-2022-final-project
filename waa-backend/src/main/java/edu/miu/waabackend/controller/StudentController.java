package edu.miu.waabackend.controller;

import edu.miu.waabackend.config.RoutingValues;
import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.service.IStudentService;
import org.apache.coyote.Response;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping( "/students")
public class StudentController {

    private final IStudentService studentService;

    //student publisher
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StudentController(IStudentService studentService, RabbitTemplate rabbitTemplate) {
        this.studentService = studentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RolesAllowed("faculty")
    @GetMapping
    public ResponseEntity<List<DTOEntity>> getAllStudents() {
        return ResponseEntity.ok(studentService.lstGetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEntity> getStudentById(@PathVariable long id) {
        return ResponseEntity.ok(studentService.GetByPK(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto student) {
        studentService.Insert(student);
        //sending obj
        rabbitTemplate.convertAndSend(RoutingValues.EXCHANGE_ONE.toString(),RoutingValues.ROUTING_KEY_ONE.toString(),student);
        //
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

    //For the faculty functions
    //Faculty can filter students:
    //by state.
    //by city.
    //by major.
    //by name.
    //by student id.

    public List<Student> filterStudentByState(@RequestParam String stateName){
        List<Student> students = studentService.getStudentByState(stateName);
        return students;
    }

    public List<Student> filterStudentByCity(@RequestParam String city){
        List<Student> students = studentService.getStudentByCity(city);
        return students;
    }

    public List<Student> filterStudentByMajor(@RequestParam String major){
        List<Student> students = studentService.getStudentByMajor(major);
        return students;
    }

    public List<Student> filterStudentByLastName(@RequestParam String lastName){
        List<Student> students = studentService.getStudentByLastName(lastName);
        return students;
    }

    public Student filterStudentById(@RequestParam Long id){
        Student student = studentService.getStudentById(id);
        return student;
    }
}
