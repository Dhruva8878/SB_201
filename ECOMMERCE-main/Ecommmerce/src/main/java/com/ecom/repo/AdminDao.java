package com.ecom.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	public Optional<Admin> findByUserId(String userId);
	
}
