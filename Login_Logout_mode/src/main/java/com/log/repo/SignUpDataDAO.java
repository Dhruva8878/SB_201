package com.log.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.log.model.SingUp;

@Repository
public interface SignUpDataDAO extends JpaRepository<SingUp, Integer> {

}
