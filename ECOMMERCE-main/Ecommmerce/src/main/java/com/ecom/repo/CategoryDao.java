package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Categorys;

public interface CategoryDao extends JpaRepository<Categorys, Integer> {

}
