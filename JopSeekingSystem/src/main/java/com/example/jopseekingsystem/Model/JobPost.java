package com.example.jopseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 5,message = "Title should be at least 5 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty(message = "Description should not be empty")
    @Column(columnDefinition = "varchar(200) not null")
    private String description;
    @NotEmpty(message = "Location should not be empty")
    @Column(columnDefinition = "varchar(45) not null")
    private String location;
    @NotNull(message = "Salary should not be empty")
    @Positive(message = "Salary should be positive")
    @Column(columnDefinition = "double not null")
    private double salary;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime postingDate;
}
