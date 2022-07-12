package edu.miu.waabackend.repository;

import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
//    Students and Faculty can filter job advertisements:
//    by tags.
//    by state.
//    by city
//    by companyName.
    public List<JobAdvertisement> findJobAdvertisementsByTag(Tag tag);
    public List<JobAdvertisement> findJobAdvertisementsByStateName(String stateName);
    public List<JobAdvertisement> findJobAdvertisementsByCityName(String cityName);
    public List<JobAdvertisement> findJobAdvertisementsByCompanyName(String companyName);

}
