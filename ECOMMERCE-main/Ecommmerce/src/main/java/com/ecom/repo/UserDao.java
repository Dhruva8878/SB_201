package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.User;


public interface UserDao extends JpaRepository<User, Integer> {

}
