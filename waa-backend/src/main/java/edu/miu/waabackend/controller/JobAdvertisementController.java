package edu.miu.waabackend.controller;

import edu.miu.waabackend.domain.City;
import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.State;
import edu.miu.waabackend.domain.Tag;
import edu.miu.waabackend.dto.DTOEntity;
import edu.miu.waabackend.dto.JobAdvertisementDto;
import edu.miu.waabackend.service.IJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/jobs")
public class JobAdvertisementController {

    private final IJobAdvertisementService jobAdvertisementService;
    @Autowired
    public JobAdvertisementController(IJobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping
    public ResponseEntity<List<DTOEntity>> GetAll() {
        return ResponseEntity.ok(jobAdvertisementService.lstGetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEntity> GetByPK(@PathVariable long id){
        DTOEntity jobAdvertisement = jobAdvertisementService.GetByPK(id);
        return ResponseEntity.ok(jobAdvertisement);
    }

    @PostMapping
    public ResponseEntity<JobAdvertisementDto> Insert(@RequestBody JobAdvertisementDto jobAdvertisement) {
        jobAdvertisement.setId(jobAdvertisementService.Insert(jobAdvertisement));
        return ResponseEntity.ok(jobAdvertisement);
    }

    @PutMapping
    public ResponseEntity<JobAdvertisementDto> Update(@RequestBody JobAdvertisementDto jobAdvertisement) {
       jobAdvertisementService.Update(jobAdvertisement);
       return ResponseEntity.ok(jobAdvertisement);
    }

    @DeleteMapping("/{id}")
    public long Delete(@PathVariable long id) {
        jobAdvertisementService.Delete(id);
        return id;
    }

    @GetMapping("/tag")
    public List<JobAdvertisement> findJobAdvertisementsByTag(Tag name) {
        return jobAdvertisementService.findJobAdvertisementsByTag(name);
    }

    @GetMapping("/state")
    public List<JobAdvertisement> findJobAdvertisementsByStateName(String stateName) {
        return jobAdvertisementService.findJobAdvertisementsByStateName(stateName);
    }

    @GetMapping("/city")
    public List<JobAdvertisement> findJobAdvertisementsByCityName(String cityName) {
        return jobAdvertisementService.findJobAdvertisementsByCityName(cityName);
    }

    @GetMapping("/company")
    public List<JobAdvertisement> findJobAdvertisementsByCompanyName(String companyName) {
        return jobAdvertisementService.findJobAdvertisementsByCompanyName(companyName);
    }

    @GetMapping("/states")
    public List<State> getAllStates() {
        return jobAdvertisementService.getAllStates();
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return jobAdvertisementService.getAllCities();
    }

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return jobAdvertisementService.getAllTags();
    }
}
