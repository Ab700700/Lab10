package com.example.jopseekingsystem.Respository;

import com.example.jopseekingsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiotry extends JpaRepository<User,Integer> {
}
