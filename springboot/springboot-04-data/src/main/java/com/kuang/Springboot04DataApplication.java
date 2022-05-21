package com.kuang;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Springboot04DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04DataApplication.class, args);
    }


}
