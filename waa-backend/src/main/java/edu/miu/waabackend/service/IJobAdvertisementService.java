package edu.miu.waabackend.service;

import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.Tag;
import edu.miu.waabackend.dto.DTOEntity;
import java.util.List;

public interface IJobAdvertisementService {
    public List<DTOEntity> lstGetAll();
    public DTOEntity GetByPK(long id);
    public long Insert(DTOEntity jobAdvertisementDto);
    public long Update(DTOEntity jobAdvertisementDto);
    public long Delete(long id);

    public List<JobAdvertisement> findJobAdvertisementsByTag(Tag tag);
    public List<JobAdvertisement> findJobAdvertisementsByStateName(String stateName);
    public List<JobAdvertisement> findJobAdvertisementsByCityName(String cityName);
    public List<JobAdvertisement> findJobAdvertisementsByCompanyName(String companyName);
}
