package com.example.jopseekingsystem.Service;

import com.example.jopseekingsystem.Model.User;
import com.example.jopseekingsystem.Respository.UserReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserReposiotry users;

    public List<User> getUsers(){
      return  users.findAll();
    }

    public void addUser(User user){
        users.save(user);
    }

    public Boolean update(Integer id , User user){
        User nuser = users.getById(id);
        if(nuser == null) return false;
        user.setId(id);
        users.save(user);
        return true;
    }

    public Boolean delete(Integer id){
        User u = users.getById(id);
        if(u == null) return false;
        users.delete(u);
        return true;
    }

}
