package com.kuang.utils;

import java.util.UUID;

@SuppressWarnings("all")
public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}