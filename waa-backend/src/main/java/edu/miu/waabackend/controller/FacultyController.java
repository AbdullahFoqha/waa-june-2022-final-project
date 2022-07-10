package edu.miu.waabackend.controller;

import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.FacultyDto;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.service.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
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
    public ResponseEntity<DTOEntity> getFacultyById(@PathVariable long id) {
        return ResponseEntity.ok(facultyService.GetByPK(id));
    }

    @PostMapping
    public ResponseEntity<DTOEntity> saveFaculty(@RequestBody FacultyDto facultyDto) {
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
}
