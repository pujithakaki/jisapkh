package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long>{

}
