package com.example.jopseekingsystem.Service;

import com.example.jopseekingsystem.Model.JobApplication;
import com.example.jopseekingsystem.Model.JobPost;
import com.example.jopseekingsystem.Model.User;
import com.example.jopseekingsystem.Respository.JobApplicatioinRepository;
import com.example.jopseekingsystem.Respository.JobPostRepository;
import com.example.jopseekingsystem.Respository.UserReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    final private JobApplicatioinRepository applications;
    final private JobPostRepository posts;
    final private UserReposiotry users;


    public List<JobApplication> getApplications(){
        return applications.findAll();
    }

    public int apply(Integer postid , Integer userid){
        JobApplication j = new JobApplication();
        JobPost post = posts.getById(postid);
        User user = users.getById(userid);
        if(user == null) return 1;
        else if(post == null) return 2;
        else{
            j.setJobPostId(postid);
            j.setUserId(userid);
            applications.save(j);
            return 3;
        }
    }

    public int withdraw(Integer id,Integer userid){
        JobApplication j = applications.getById(id);
        if(j == null) return 1;
        else if(j.getUserId().equals(userid)){
            applications.delete(j);
            return 2;
        }else {
          return 3;
        }

    }
}
