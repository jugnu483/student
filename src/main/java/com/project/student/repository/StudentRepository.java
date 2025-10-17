package com.project.student.repository;

import com.project.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Email se student find karne ke liye custom method
    Optional<Student> findByEmail(String email);

    // Check karne ke liye ki email already exists ya nahi
    boolean existsByEmail(String email);


}
