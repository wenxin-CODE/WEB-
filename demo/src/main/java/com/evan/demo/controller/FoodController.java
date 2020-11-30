package com.evan.demo.controller;

import com.evan.demo.pojo.Food;
import com.evan.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @CrossOrigin
    @GetMapping("/api/foods")
    public List<Food> list() throws Exception{
        return foodService.list();
    }

    @CrossOrigin
    @PostMapping("/api/foods")
    public Food addOrUpdate(@RequestBody Food food)throws Exception{
        foodService.addOrUpdate(food);
        return food;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Food food) throws Exception {
        foodService.deleteById(food.getId());
    }


    @CrossOrigin
    @GetMapping("/api/kinds/{cid}/foods")
    public List<Food> listByKind(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return foodService.listByKind(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Food> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return foodService.list();
        } else {
            return foodService.Search(keywords);
        }
    }

}
    