package edu.miu.waabackend.service;

import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IStudentService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity studentDto);
    public int Update(DTOEntity studentDto);
    public int Delete(Long id);

    public List<Student> getStudentByState(String stateName);
    public List<Student> getStudentByTag(String tagName);
    public List<Student> getStudentByCity(String cityName );
    public List<Student> getStudentByCompanyName(String companyName);
 }
