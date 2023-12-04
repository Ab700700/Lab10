package com.example.jopseekingsystem.Respository;

import com.example.jopseekingsystem.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Integer> {
}
