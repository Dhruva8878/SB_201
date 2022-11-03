package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Tag;

public interface TagDao extends JpaRepository<Tag, Integer>{

}
