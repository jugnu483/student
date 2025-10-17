package com.project.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student Entity Class
 * Yeh class database mein 'student' table ko represent karti hai
 */
@Entity  // JPA ko batata hai ki yeh ek database table hai
@Table(name = "students")  // Table ka naam 'students' hoga
@Data  // Lombok: Automatic getters, setters, toString, equals, hashCode generate karega
@NoArgsConstructor  // Lombok: Default constructor (without parameters) generate karega
@AllArgsConstructor  // Lombok: Constructor with all fields generate karega
public class Student {

    /**
     * Primary Key - Har student ki unique ID
     * AUTO se automatically generate hoga
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Student ka naam
     * nullable = false matlab yeh field mandatory hai
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Student ki email
     * unique = true matlab duplicate email nahi ho sakti
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * Student ki age
     */
    @Column(nullable = false)
    private Integer age;

    /**
     * Student ka contact number
     * length = 15 max 15 digits ka number
     */
    @Column(nullable = false, length = 15)
    private String contactNumber;

}
