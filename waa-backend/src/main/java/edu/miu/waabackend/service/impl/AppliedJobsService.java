package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.domain.AppliedJobs;
import edu.miu.waabackend.dto.AppliedJobDto;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.repository.AppliedJobsRepository;
import edu.miu.waabackend.service.IAppliedJobsService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppliedJobsService implements IAppliedJobsService {

    private AppliedJobsRepository appliedJobsRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public AppliedJobsService(AppliedJobsRepository appliedJobsRepository, DtoUtils dtoUtils) {
        this.appliedJobsRepository = appliedJobsRepository;
        this.dtoUtils = dtoUtils;
    }

    @Override
    public List<DTOEntity> lstGetAll() {
        try {
            return dtoUtils.convertToListDto(appliedJobsRepository.findAll(), new AppliedJobDto());
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DTOEntity GetByPK(Long id) {
        AppliedJobs appliedJob = appliedJobsRepository.findById(id).orElse(null);
        if(appliedJob != null)
            return dtoUtils.convertToDto(appliedJob, new AppliedJobDto());

        return null;
    }

    @Override
    public long Insert(DTOEntity appliedJobDto) {
        try {
            AppliedJobs appliedJobObj = (AppliedJobs) dtoUtils.convertToEntity(appliedJobDto, new AppliedJobs());
            return appliedJobsRepository.save(appliedJobObj).getId();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public long Update(DTOEntity appliedJobDto) {
        try {
            AppliedJobs appliedJobObj = (AppliedJobs) dtoUtils.convertToEntity(appliedJobDto, new AppliedJobs());
            appliedJobsRepository.save(appliedJobObj);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }

    @Override
    public long Delete(Long id) {
        try {
            appliedJobsRepository.deleteById(id);
            return 1;
        }
        catch (Exception ex) {
            return 0;
        }
    }
}
