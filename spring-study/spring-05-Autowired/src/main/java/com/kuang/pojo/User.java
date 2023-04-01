package com.kuang.pojo;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
//    @Setter("jj")
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