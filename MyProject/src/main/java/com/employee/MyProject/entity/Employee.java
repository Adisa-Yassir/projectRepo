package com.employee.MyProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name ="employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min= 3, message = "First Name must be at least 3 characters long")
    private String firstName;

    @Column(nullable = false)
    @Size(min= 3, message = "First Name must be at least 3 characters long")
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email(message = "Please provide a valid email address")
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    @Min(value = 10000, message = "Salary must be greater than 100000")
    private Integer salary;

//    @CreatedDate
//    @Column(nullable = false, updatable = false)
//    private Long date;

    @CreationTimestamp
    private LocalDateTime date;
}
