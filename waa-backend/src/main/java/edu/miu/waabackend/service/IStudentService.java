package edu.miu.waabackend.service;

import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;

import java.util.List;

public interface IStudentService {
    List<DTOEntity> lstGetAll();

    DTOEntity GetByPK(String id);

    int Insert(DTOEntity studentDto);

    int Update(DTOEntity studentDto);

    int Delete(Long id);

    List<Student> getStudentByState(String stateName);

    List<Student> getStudentByLastName(String lastName);

    List<Student> getStudentByCity(String cityName);

    List<Student> getStudentByMajor(String major);

}
