package edu.miu.waabackend.controller;

import edu.miu.waabackend.service.IJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "Jobs/")
public class JobAdvertisementController {

    private IJobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(IJobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }
}
