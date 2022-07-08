package edu.miu.waabackend.service;

import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IJobAdvertisementService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(Long id);
    public int Insert(DTOEntity jobAdvertisementDto);
    public int Update(DTOEntity jobAdvertisementDto);
    public int Delete(Long id);
}
