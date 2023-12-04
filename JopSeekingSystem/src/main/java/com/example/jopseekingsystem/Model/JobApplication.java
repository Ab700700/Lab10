package com.example.jopseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "userId should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "jobPostId should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;
}
