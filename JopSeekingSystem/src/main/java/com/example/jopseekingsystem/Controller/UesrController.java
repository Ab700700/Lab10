package com.example.jopseekingsystem.Controller;

import com.example.jopseekingsystem.Model.ApiResponse;
import com.example.jopseekingsystem.Model.User;
import com.example.jopseekingsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jss/user")
@RequiredArgsConstructor
public class UesrController {

        final private UserService userService;

        @GetMapping("/get")
        public ResponseEntity get(){
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
        }
        @PostMapping("/add")
        public ResponseEntity add(@RequestBody @Valid  User user, Errors errors){
            if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400,errors.getFieldError().getDefaultMessage()));
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Added");
        }

        @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @RequestBody @Valid User user , Errors errors){
            if(errors.hasErrors()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(400,errors.getFieldError().getDefaultMessage()));
            else if(userService.update(id,user)) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"User updated"));
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,HttpStatus.NOT_FOUND.toString()));
        }

      @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
            if(userService.delete(id)) return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(200,"User deleted"));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(400,HttpStatus.NOT_FOUND.toString()));
      }
}
