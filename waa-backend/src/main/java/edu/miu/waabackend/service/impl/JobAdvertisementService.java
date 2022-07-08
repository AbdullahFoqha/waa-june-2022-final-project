package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;
import edu.miu.waabackend.repository.JobAdvertisementRepository;
import edu.miu.waabackend.service.IJobAdvertisementService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementService implements IJobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public JobAdvertisementService(JobAdvertisementRepository jobAdvertisementRepository, DtoUtils dtoUtils) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
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
    public DTOEntity GetByPK(Long id) {
        JobAdvertisement jobAdvertisementObj = jobAdvertisementRepository.findById(id).orElse(null);
        if(jobAdvertisementObj != null)
            return dtoUtils.convertToDto(jobAdvertisementObj, new JobAdvertisementDto());

        return null;
    }

    @Override
    public int Insert(DTOEntity jobDto) {
        try {
            JobAdvertisement jobAdvertisementObj = (JobAdvertisement) dtoUtils.convertToEntity(jobDto, new JobAdvertisement());
            jobAdvertisementRepository.save(jobAdvertisementObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity jobDto) {
        try {
            JobAdvertisement jobAdvertisementObj = (JobAdvertisement) dtoUtils.convertToEntity(jobDto, new JobAdvertisement());
            jobAdvertisementRepository.save(jobAdvertisementObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            jobAdvertisementRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
