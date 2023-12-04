package com.example.jopseekingsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int status;
    private String message;

}
