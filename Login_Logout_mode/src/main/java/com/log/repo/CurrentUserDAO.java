package com.log.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.log.model.CurrentUserSession;

@Repository
public interface CurrentUserDAO extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByuuid(String key);
	
	public CurrentUserSession findByuserId(Integer id);
	
}
