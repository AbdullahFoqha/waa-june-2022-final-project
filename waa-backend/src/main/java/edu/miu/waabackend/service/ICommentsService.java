package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface ICommentsService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity commentsDto);
    public int Update(DTOEntity commentsDto);
    public int Delete(Long id);
}
