package edu.miu.waabackend.controller;

import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;
import edu.miu.waabackend.service.IJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Jobs/")
public class JobAdvertisementController {

    private IJobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(IJobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping
    public List<DTOEntity> GetAll() {
        return jobAdvertisementService.lstGetAll();
    }

    @GetMapping("{id}")
    public DTOEntity GetByPK(@PathVariable long id){
        return jobAdvertisementService.GetByPK(id);
    }
    @PostMapping
    public JobAdvertisementDto Insert(@RequestBody JobAdvertisementDto jobAdvertisement) {
        jobAdvertisement.setId(jobAdvertisementService.Insert(jobAdvertisement));

        return jobAdvertisement;
    }

    @PutMapping
    public long Update(@RequestBody JobAdvertisementDto jobAdvertisement) {
        return jobAdvertisementService.Update(jobAdvertisement);
    }

    @PutMapping("{id}")
    public long Delete(@PathVariable long id) {
        return jobAdvertisementService.Delete(id);
    }
}
