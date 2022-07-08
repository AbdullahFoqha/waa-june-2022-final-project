package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IAppliedJobsService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity appliedJobsDto);
    public int Update(DTOEntity appliedJobsDto);
    public int Delete(Long id);
}
