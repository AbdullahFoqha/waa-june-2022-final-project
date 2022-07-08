package edu.miu.waabackend.controller;

import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;
import edu.miu.waabackend.service.IJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
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

    @GetMapping("/{id}")
    public ResponseEntity<DTOEntity> GetByPK(@PathVariable long id){
        DTOEntity jobAdvertisement = jobAdvertisementService.GetByPK(id);
        return ResponseEntity.ok(jobAdvertisement);
    }

    @PostMapping
    public JobAdvertisementDto Insert(@RequestBody JobAdvertisementDto jobAdvertisement) {
        jobAdvertisement.setId(jobAdvertisementService.Insert(jobAdvertisement));
        return jobAdvertisement;
    }

    @PutMapping
    public JobAdvertisementDto Update(@RequestBody JobAdvertisementDto jobAdvertisement) {
       jobAdvertisementService.Update(jobAdvertisement);
       return jobAdvertisement;
    }

    @DeleteMapping("/{id}")
    public long Delete(@PathVariable long id) {
        jobAdvertisementService.Delete(id);
        return id;
    }
}
