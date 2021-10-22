package ng.com.createsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.com.createsoftware.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
