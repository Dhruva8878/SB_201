package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

}
