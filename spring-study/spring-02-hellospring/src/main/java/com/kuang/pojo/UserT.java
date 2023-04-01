package com.kuang.pojo;

public class UserT {

    private String name;

    public UserT(String name) {
        this.name = name;
        System.out.println("UserT有参构造成功");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+ name );
    }

}