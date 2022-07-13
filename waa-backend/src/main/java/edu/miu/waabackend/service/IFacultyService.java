package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;

import java.util.List;

public interface IFacultyService {
    List<DTOEntity> lstGetAll();

    DTOEntity GetByPK(String id);

    int Insert(DTOEntity facultyDto);

    int Update(DTOEntity facultyDto);

    int Delete(Long id);
}
