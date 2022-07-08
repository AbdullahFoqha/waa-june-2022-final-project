package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.JobHistory;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobHistoryDto;
import edu.miu.waabackend.repository.JobHistoryRepository;
import edu.miu.waabackend.service.IJobHistoryService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryService implements IJobHistoryService {

    private JobHistoryRepository jobHistoryRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public JobHistoryService(JobHistoryRepository jobHistoryRepository, DtoUtils dtoUtils) {
        this.jobHistoryRepository = jobHistoryRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(jobHistoryRepository.findAll(), new JobHistoryDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(Long id) {
        JobHistory jobHistoryObj = jobHistoryRepository.findById(id).orElse(null);
        if(jobHistoryObj != null)
            return dtoUtils.convertToDto(jobHistoryObj, new JobHistoryDto());

        return null;
    }

    @Override
    public int Insert(DTOEntity jobHistoryDto) {
        try {
            JobHistory jobHistoryObj = (JobHistory) dtoUtils.convertToEntity(jobHistoryDto, new JobHistory());
            jobHistoryRepository.save(jobHistoryObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Update(DTOEntity jobHistoryDto) {
        try {
            JobHistory jobHistoryObj = (JobHistory) dtoUtils.convertToEntity(jobHistoryDto, new JobHistory());
            jobHistoryRepository.save(jobHistoryObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public int Delete(Long id) {
        try {
            jobHistoryRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
