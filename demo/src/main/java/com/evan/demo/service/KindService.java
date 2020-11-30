package com.evan.demo.service;

import com.evan.demo.dao.KindDAO;
import com.evan.demo.pojo.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService {
    @Autowired
    KindDAO kindDAO;

    public List<Kind> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return kindDAO.findAll(sort);
    }

    public Kind get(int id){
        Kind k = kindDAO.findById(id).orElse(null);
        return k;
    }
}
