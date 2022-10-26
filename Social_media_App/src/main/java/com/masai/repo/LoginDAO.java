package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Login;

public interface LoginDAO extends JpaRepository<Login, Integer> {

}
