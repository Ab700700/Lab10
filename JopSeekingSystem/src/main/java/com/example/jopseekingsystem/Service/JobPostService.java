package com.example.jopseekingsystem.Service;

import com.example.jopseekingsystem.Model.JobPost;
import com.example.jopseekingsystem.Model.User;
import com.example.jopseekingsystem.Respository.JobPostRepository;
import com.example.jopseekingsystem.Respository.UserReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    final private JobPostRepository jobposts;
    final private UserReposiotry users;

    public List<JobPost> getPosts(){
        return jobposts.findAll();
    }

    public int addPost(JobPost jobPost, Integer userid){
        User u = users.getById(userid);
        if(u == null) return 1;
        else if(u.getRole().equals("JOB_SEEKER")) return 2;
        else{
        jobposts.save(jobPost);
            return 3;
        }
    }

    public Boolean updatePost(Integer id , JobPost jobPost){
        JobPost j = jobposts.getById(id);
        if(j == null )return false;
        jobPost.setId(id);
        jobposts.save(jobPost);
        return true;
    }

    public Boolean delete (Integer id){
        JobPost j = jobposts.getById(id);
        if(j == null) return false;
        jobposts.delete(j);
        return true;
    }
}
