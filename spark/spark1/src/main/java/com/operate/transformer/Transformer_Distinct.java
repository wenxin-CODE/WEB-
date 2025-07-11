package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Transformer_Distinct {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext jsc = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 1,2,2);
        jsc.parallelize(integers).distinct(2).collect().forEach(System.out::println);
    }
}
