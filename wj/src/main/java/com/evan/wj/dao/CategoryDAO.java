package com.evan.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.wj.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
