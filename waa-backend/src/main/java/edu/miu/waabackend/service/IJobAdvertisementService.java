package edu.miu.waabackend.service;

import edu.miu.waabackend.domain.City;
import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.State;
import edu.miu.waabackend.domain.Tag;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;

import java.util.List;

public interface IJobAdvertisementService {
    public List<DTOEntity> lstGetAll(JobAdvertisementDto jobAdvertisementDto);
    public DTOEntity GetByPK(long id);
    public long Insert(DTOEntity jobAdvertisementDto);
    public long Update(DTOEntity jobAdvertisementDto);
    public long Delete(long id);

    public List<JobAdvertisement> findJobAdvertisementsByTag(Tag tag);
    public List<JobAdvertisement> findJobAdvertisementsByStateName(String stateName);
    public List<JobAdvertisement> findJobAdvertisementsByCityName(String cityName);
    public List<JobAdvertisement> findJobAdvertisementsByCompanyName(String companyName);

    List<Tag> getAllTags();
    List<State> getAllStates();
    List<City> getAllCities();
}
