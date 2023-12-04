package com.example.jopseekingsystem.Controller;

import com.example.jopseekingsystem.Model.ApiResponse;
import com.example.jopseekingsystem.Model.JobPost;
import com.example.jopseekingsystem.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jss/post")
@RequiredArgsConstructor
public class JobPostController {

    final private JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getPosts());
    }
    @PostMapping("/add/{id}")
    public ResponseEntity addPost(@RequestBody @Valid JobPost jobPost,@PathVariable Integer id, Errors errors){
        int j = jobPostService.addPost(jobPost,id);
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400,errors.getFieldError().getDefaultMessage()));
        else if(j==1) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,"User not found"));
        else if(j==2)return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400,"User is not employer"));
        else return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"Post Added"));


    }
    @PutMapping("/update/{id}")
    public  ResponseEntity updatePost(@PathVariable Integer id , @RequestBody @Valid JobPost jobPost , Errors errors){
        if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400,errors.getFieldError().getDefaultMessage()));
        else if(jobPostService.updatePost(id,jobPost)) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"Post updated"));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,HttpStatus.NOT_FOUND.toString()));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        if(jobPostService.delete(id)) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"Post deleted"));
        else return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,HttpStatus.NOT_FOUND.toString()));
    }
}
