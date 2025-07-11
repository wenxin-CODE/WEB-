package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple1;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Transformer_KV {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf();
        sc.setMaster("local");
        sc.setAppName("APP");
        JavaSparkContext jsc = new JavaSparkContext(sc);

//        Tuple2<String, Integer> a = new Tuple2<String, Integer>("a", 1);
//        Tuple2<String, Integer> b = new Tuple2<String, Integer>("b", 2);
//        Tuple2<String, Integer> c = new Tuple2<String, Integer>("c", 3);
//
//        List<Tuple2<String, Integer>> objects = Arrays.asList(a, b, c);
//        JavaPairRDD<String, Integer> kvJavaPairRDD = jsc.parallelizePairs(objects);
//
////        这里只对k-v中的v进行操作
//        kvJavaPairRDD.mapValues(num -> num*2).collect().forEach(System.out::println);

//        单值变双值
        List<Integer> k = Arrays.asList(1, 2, 3, 4);
        JavaRDD<Integer> rdd = jsc.parallelize(k);
        rdd.mapToPair(num -> new Tuple2<String, Integer>(num.toString(),num))
                .mapValues(num -> num*2).collect().forEach(System.out::println);

        jsc.close();
    }
}
