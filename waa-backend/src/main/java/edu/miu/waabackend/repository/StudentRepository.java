package edu.miu.waabackend.repository;

import edu.miu.waabackend.domain.Department;
import edu.miu.waabackend.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //Faculty can filter students:
    //by state.
    //by city.
    //by major.
    //by name.
    //by student id.
    public List<Student> getStudentsByState(String state);
    public List<Student> getStudentsByCityName(String city);
    public List<Student> getStudentsByMajor(Department department);
    public List<Student> getStudentsByLastname(String name);

    public Student getStudentByMajor(String name);

}
