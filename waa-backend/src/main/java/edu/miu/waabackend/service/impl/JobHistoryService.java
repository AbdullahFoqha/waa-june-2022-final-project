package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.JobHistoryRepository;
import edu.miu.waabackend.service.IJobHistoryService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobHistoryService implements IJobHistoryService {

    private JobHistoryRepository jobHistoryRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public JobHistoryService(JobHistoryRepository jobHistoryRepository, DtoUtils dtoUtils) {
        this.jobHistoryRepository = jobHistoryRepository;
        this.dtoUtils = dtoUtils;
    }
}
