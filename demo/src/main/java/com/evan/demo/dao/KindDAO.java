package com.evan.demo.dao;

import com.evan.demo.pojo.Kind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindDAO extends JpaRepository<Kind,Integer> {

}
