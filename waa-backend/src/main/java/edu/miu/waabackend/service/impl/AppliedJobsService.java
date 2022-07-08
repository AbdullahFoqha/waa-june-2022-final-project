package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.AppliedJobsRepository;
import edu.miu.waabackend.service.IAppliedJobsService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliedJobsService implements IAppliedJobsService {

    private AppliedJobsRepository appliedJobsRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public AppliedJobsService(AppliedJobsRepository appliedJobsRepository, DtoUtils dtoUtils) {
        this.appliedJobsRepository = appliedJobsRepository;
        this.dtoUtils = dtoUtils;
    }
}
