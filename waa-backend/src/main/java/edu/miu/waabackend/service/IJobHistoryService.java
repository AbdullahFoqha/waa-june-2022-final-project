package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IJobHistoryService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity jobHistoryDto);
    public int Update(DTOEntity jobHistoryDto);
    public int Delete(Long id);
}
