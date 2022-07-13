package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.Faculty;
import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.FacultyDto;
import edu.miu.waabackend.dto.StudentDto;
import edu.miu.waabackend.repository.FacultyRepository;
import edu.miu.waabackend.service.IFacultyService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService implements IFacultyService {

    private final FacultyRepository facultyRepository;

    private DtoUtils dtoUtils;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, DtoUtils dtoUtils) {
        this.facultyRepository = facultyRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(facultyRepository.findAll(), new FacultyDto());
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(String id) {
        List<Faculty> lstStudent = facultyRepository.findAll();
        Faculty facultyObj = lstStudent.stream().filter(x -> x.getUserId().equals(id)).findFirst().get();
        return dtoUtils.convertToDto(facultyObj, new FacultyDto());

    }

    @Override
    public int Insert(DTOEntity facultyDto) {
        try {
            Faculty facultyObj = (Faculty) dtoUtils.convertToEntity(facultyDto, new Faculty());
            facultyRepository.save(facultyObj);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity facultyDto) {
        try {
            Faculty facultyObj = (Faculty) dtoUtils.convertToEntity(facultyDto, new Faculty());
            facultyRepository.save(facultyObj);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            facultyRepository.deleteById(id);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
}
