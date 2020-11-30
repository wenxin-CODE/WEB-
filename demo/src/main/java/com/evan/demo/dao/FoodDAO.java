package com.evan.demo.dao;

import com.evan.demo.pojo.Food;
import com.evan.demo.pojo.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodDAO extends JpaRepository<Food,Integer> {
    List<Food> findAllByKind(Kind kind);
    List<Food> findAllByName(String keyword);
}
