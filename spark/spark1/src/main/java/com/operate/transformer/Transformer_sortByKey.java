package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;

public class Transformer_sortByKey {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf().setMaster("local").setAppName("APP");
        JavaSparkContext jsc = new JavaSparkContext(sc);

        User user1 = new User(10, 300);
        User user2 = new User(70, 300);
        User user3 = new User(50, 300);
        User user4 = new User(30, 300);

        ArrayList<Tuple2<User,Integer>> users = new ArrayList<>();
        users.add(new Tuple2<User,Integer>(user1,1));
        users.add(new Tuple2<User,Integer>(user2,2));
        users.add(new Tuple2<User,Integer>(user3,1));
        users.add(new Tuple2<User,Integer>(user4,2));
        jsc.parallelizePairs(users)
                .sortByKey()
                .collect()
                .forEach(System.out::println);

    }
}

class User implements Serializable,Comparable<User>{
    int age = 0;
    int money = 0;

    User (int age,int money){
        this.age = age;
        this.money = money;
    }
    @Override
    public int compareTo(User o) {
        if (this.age > o.age)
            return 1;
        else if (this.age < o.age)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", money=" + money + "]";
    }
}
