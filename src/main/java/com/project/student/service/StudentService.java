package com.project.student.service;

import com.project.student.entity.Student;
import com.project.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // Naya student create karna
    public Student createStudent(Student student) {
        // Check karo ki email already exist to nahi karti
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists: " + student.getEmail());
        }
        return studentRepository.save(student);
    }

    // Sabhi students ko get karna
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ID se student dhundna
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Email se student dhundna
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // Student update karna
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Email update karte waqt check karo ki naya email already exist to nahi karta
        if (!existingStudent.getEmail().equals(updatedStudent.getEmail())
                && studentRepository.existsByEmail(updatedStudent.getEmail())) {
            throw new RuntimeException("Email already exists: " + updatedStudent.getEmail());
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setContactNumber(updatedStudent.getContactNumber());

        return studentRepository.save(existingStudent);
    }

    // Student delete karna
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Total students count
    public long getTotalStudents() {
        return studentRepository.count();
    }

}
