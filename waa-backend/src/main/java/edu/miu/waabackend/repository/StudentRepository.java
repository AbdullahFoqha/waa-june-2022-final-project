package edu.miu.waabackend.repository;

import edu.miu.waabackend.domain.Department;
import edu.miu.waabackend.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> getStudentsByState(String state);

    List<Student> getStudentsByCityName(String city);

    List<Student> getStudentsByMajor(Department department);

    List<Student> getStudentsByLastName(String name);

    Student getStudentByMajor(String name);

    //@Query("Select s from student s where s.user_id=?1")
    Student findByUserId(String userId);
}
