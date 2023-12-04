package com.example.jopseekingsystem.Respository;

import com.example.jopseekingsystem.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicatioinRepository extends JpaRepository<JobApplication,Integer> {
}
