package edu.miu.waabackend.service.impl;

import edu.miu.waabackend.repository.JobAdvertisementRepository;
import edu.miu.waabackend.service.IJobAdvertisementService;
import edu.miu.waabackend.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertisementService implements IJobAdvertisementService {

    private JobAdvertisementRepository jobAdvertisementRepository;
    private DtoUtils dtoUtils;

    @Autowired
    public JobAdvertisementService(JobAdvertisementRepository jobAdvertisementRepository, DtoUtils dtoUtils) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
        this.dtoUtils = dtoUtils;
    }
}
