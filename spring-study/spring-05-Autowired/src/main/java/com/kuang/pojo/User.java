package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String str;

    public Cat getCat() {
        return cat;
    }

//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    public Dog getDog() {
        return dog;
    }

//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }

    public String getStr() {
        return str;
    }

//    public void setStr(String str) {
//        this.str = str;
//    }
}