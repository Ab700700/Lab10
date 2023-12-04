package com.example.jopseekingsystem.Controller;

import com.example.jopseekingsystem.Model.ApiResponse;
import com.example.jopseekingsystem.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jss/jobapp")
@RequiredArgsConstructor
public class JobApplicationController {

    final private JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getApplications(){
        return ResponseEntity.status(HttpStatus.OK).body(jobApplicationService.getApplications());
    }
    @PostMapping("/apply/{postid}/{userid}")
    public ResponseEntity applyApplication(@PathVariable Integer postid, @PathVariable Integer userid){
        int j = jobApplicationService.apply(postid,userid);
        if(j==1) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,"User not found"));
        else if(j==2) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,"Post not found"));
        else return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"Applied"));
    }

    @DeleteMapping("/withdraw/{id}/{userid}")
    public ResponseEntity withdrawApplication( @PathVariable Integer id,@PathVariable Integer userid){
        int j = jobApplicationService.withdraw(id,userid);
        if(j==2) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"Apply withdraw"));
        else if(j==1) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,"Post not found"));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,"User not found"));

    }
}
