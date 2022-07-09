package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IJobAdvertisementService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(long id);
    public long Insert(DTOEntity jobAdvertisementDto);
    public long Update(DTOEntity jobAdvertisementDto);
    public long Delete(long id);
}
