package edu.miu.waabackend.repository;

import edu.miu.waabackend.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommnetsRepository extends JpaRepository<Comments, Long> {
}
