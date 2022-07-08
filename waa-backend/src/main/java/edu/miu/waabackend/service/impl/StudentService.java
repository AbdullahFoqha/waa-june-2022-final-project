package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.StudentRepository;
import edu.miu.waabackend.service.IStudentService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public StudentService(StudentRepository studentRepository, DtoUtils dtoUtils) {
        this.studentRepository = studentRepository;
        this.dtoUtils = dtoUtils;
    }
}
