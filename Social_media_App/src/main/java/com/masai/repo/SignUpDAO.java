package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SignUp;

public interface SignUpDAO extends JpaRepository<SignUp, Integer> {

}
