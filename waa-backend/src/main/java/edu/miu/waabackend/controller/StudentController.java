package edu.miu.waabackend.controller;

import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.service.IStudentService;
import edu.miu.waabackend.service.impl.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/students")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

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
}
