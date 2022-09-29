package com.log.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.log.model.LoginData;

@Repository
public interface LoginDataDAO extends JpaRepository<LoginData, Integer>{

}
