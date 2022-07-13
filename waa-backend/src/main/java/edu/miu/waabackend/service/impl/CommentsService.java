package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.Comments;
import edu.miu.waabackend.dto.CommentsDto;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.repository.CommnetsRepository;
import edu.miu.waabackend.repository.FacultyRepository;
import edu.miu.waabackend.repository.StudentRepository;
import edu.miu.waabackend.service.ICommentsService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService implements ICommentsService {

    private CommnetsRepository commnetsRepository;
    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public CommentsService(CommnetsRepository commnetsRepository, StudentRepository studentRepository, FacultyRepository facultyRepository, DtoUtils dtoUtils) {
        this.commnetsRepository = commnetsRepository;
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(commnetsRepository.findAll(), new CommentsDto());
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(Long id) {
        Comments commentObj = commnetsRepository.findById(id).orElse(null);
        if (commentObj != null)
            return dtoUtils.convertToDto(commentObj, new CommentsDto());

        return null;
    }

    @Override
    public int Insert(DTOEntity commentDto) {
        try {


            Comments commentObj = (Comments) dtoUtils.convertToEntity(commentDto, new Comments());
            commnetsRepository.save(commentObj);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity commentDto) {
        try {
            Comments commentObj = (Comments) dtoUtils.convertToEntity(commentDto, new Comments());
            commnetsRepository.save(commentObj);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            commnetsRepository.deleteById(id);
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
}
