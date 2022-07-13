package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IAppliedJobsService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public long Insert(DTOEntity appliedJobsDto);
    public long Update(DTOEntity appliedJobsDto);
    public long Delete(Long id);
}
