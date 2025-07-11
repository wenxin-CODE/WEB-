package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

public class Transformer_Filter1 {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local[2]");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        JavaRDD<Integer> rdd = javaSparkContext.parallelize(integers, 2);
        JavaRDD<Integer> filter = rdd.filter(new Function<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) throws Exception {
                return integer >= 2;
            }
        });
        filter.collect().forEach(System.out::println);
    }
}
