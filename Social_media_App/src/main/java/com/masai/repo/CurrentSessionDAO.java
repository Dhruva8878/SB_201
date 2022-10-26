package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentUserSession;

public interface CurrentSessionDAO extends JpaRepository<CurrentUserSession, Integer>{

	public Optional<CurrentUserSession> findByuuid(String uuid);
	
	public Optional<CurrentUserSession> findByuserId(Integer id);
}
