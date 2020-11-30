package com.evan.demo.service;

import com.evan.demo.dao.FoodDAO;
import com.evan.demo.pojo.Food;
import com.evan.demo.pojo.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodDAO foodDAO;
    @Autowired
    KindService kindService;

    public List<Food> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return foodDAO.findAll(sort);
    }

    public void addOrUpdate(Food food) {
        foodDAO.save(food);
    }

    public void deleteById(int id) {
        foodDAO.deleteById(id);
    }

    public List<Food> listByKind(int cid) {
        Kind kind = kindService.get(cid);
        return foodDAO.findAllByKind(kind);
    }

    public List<Food> Search(String keywords) {
        return foodDAO.findAllByName('%' + keywords + '%');
    }

}
