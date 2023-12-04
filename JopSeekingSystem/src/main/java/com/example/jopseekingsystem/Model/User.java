package com.example.jopseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 5,message = "Name must be more than 4 characters")
    @Pattern(regexp = "[a-zA-Z]+",message = "Name should be written in letters only")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Email(message = "Write a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "Password should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @NotNull(message = "Age should not be empty")
    @Min(value = 22,message = "Age should be at least 22")
    @Column(columnDefinition = "int not null")
    private int age;
    @NotEmpty(message = "Role should not be empty")
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER",message = "Role must be JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "varchar(11) not null check(role = 'JOB_SEEKER' or role = 'EMPLOYER')")
    private String role;
}
