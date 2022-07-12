package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.City;
import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.State;
import edu.miu.waabackend.domain.Tag;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;
import edu.miu.waabackend.repository.CityRepository;
import edu.miu.waabackend.repository.JobAdvertisementRepository;
import edu.miu.waabackend.repository.StateRepository;
import edu.miu.waabackend.repository.TagRepository;
import edu.miu.waabackend.service.IJobAdvertisementService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementService implements IJobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;
    private TagRepository tagRepository;
    private StateRepository stateRepository;
    private CityRepository cityRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public JobAdvertisementService(JobAdvertisementRepository jobAdvertisementRepository, TagRepository tagRepository, StateRepository stateRepository, CityRepository cityRepository, DtoUtils dtoUtils) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.tagRepository = tagRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(jobAdvertisementRepository.findAll(), new JobAdvertisementDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(long id) {
        try {
            JobAdvertisement jobAdvertisementObj = jobAdvertisementRepository.findById(id).orElse(null);
            return dtoUtils.convertToDto(jobAdvertisementObj, new JobAdvertisementDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public long Insert(DTOEntity jobDto) {
        try {
            JobAdvertisement jobAdvertisementObj = (JobAdvertisement) dtoUtils.convertToEntity(jobDto, new JobAdvertisement());
            return jobAdvertisementRepository.save(jobAdvertisementObj).getId();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public long Update(DTOEntity jobDto) {
        try {
            JobAdvertisement jobAdvertisementObj = (JobAdvertisement) dtoUtils.convertToEntity(jobDto, new JobAdvertisement());
            jobAdvertisementRepository.save(jobAdvertisementObj);
            return 1;
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public long Delete(long id) {
        try {
            jobAdvertisementRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<JobAdvertisement> findJobAdvertisementsByTag(Tag tag) {
        return jobAdvertisementRepository.findJobAdvertisementsByTag(tag);
    }

    @Override
    public List<JobAdvertisement> findJobAdvertisementsByStateName(String stateName) {
        return jobAdvertisementRepository.findJobAdvertisementsByStateName(stateName);
    }

    @Override
    public List<JobAdvertisement> findJobAdvertisementsByCityName(String cityName) {
        return jobAdvertisementRepository.findJobAdvertisementsByCityName(cityName);
    }

    @Override
    public List<JobAdvertisement> findJobAdvertisementsByCompanyName(String companyName) {
        return jobAdvertisementRepository.findJobAdvertisementsByCompanyName(companyName);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
