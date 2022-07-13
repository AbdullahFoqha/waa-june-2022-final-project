package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface ICommentsService {
    List<DTOEntity> lstGetAll();
    DTOEntity GetByPK(Long id);
    int Insert(DTOEntity commentsDto);
    int Update(DTOEntity commentsDto);
    int Delete(Long id);
}
