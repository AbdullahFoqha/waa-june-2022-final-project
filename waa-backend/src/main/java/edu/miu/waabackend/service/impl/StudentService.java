package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.repository.StudentRepository;
import edu.miu.waabackend.service.IStudentService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private StudentRepository studentRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public StudentService(StudentRepository studentRepository, DtoUtils dtoUtils) {
        this.studentRepository = studentRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(studentRepository.findAll(), new StudentDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(Long id) {
        Student studentObj = studentRepository.findById(id).orElse(null);
        if(studentObj != null)
            return dtoUtils.convertToDto(studentObj, new StudentDto());

        return null;
    }

    @Override
    public int Insert(DTOEntity studentDto) {
        try {
            Student studentObj = (Student) dtoUtils.convertToEntity(studentDto, new Student());
            studentRepository.save(studentObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity studentDto) {
        try {
            Student studentObj = (Student) dtoUtils.convertToEntity(studentDto, new Student());
            studentRepository.save(studentObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
