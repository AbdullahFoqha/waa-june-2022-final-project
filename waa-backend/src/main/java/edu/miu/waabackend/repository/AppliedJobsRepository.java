package edu.miu.waabackend.repository;

import edu.miu.waabackend.domain.AppliedJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliedJobsRepository extends JpaRepository<AppliedJobs, Long> {
}
