package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

public class Transformer_Map1 {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
//        JavaRDD<Integer> rdd = javaSparkContext.parallelize(integers, 2);
//        JavaRDD<Integer> map = rdd.map(new Function<Integer, Integer>() {
//                                           @Override
//                                           public Integer call(Integer integer) throws Exception {
//                                               return integer * 2;
//                                           }
//                                       }
//        );
//        collect()表示汇总不同分区数据，和foreach同为action操作
//        map.collect().forEach(System.out::println);
        javaSparkContext.parallelize(integers,2).map(x -> x * 2).collect().forEach(System.out::println);

    }
}
