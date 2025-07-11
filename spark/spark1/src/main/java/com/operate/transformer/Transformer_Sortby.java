package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Transformer_Sortby {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 3,5,11,22,66,7);
//        sortby三个参数：排序规则【函数】、升序降序、分区数量
        jsc.parallelize(integers).sortBy(x -> ""+x ,true,2).collect().forEach(System.out::println);
    }
}
