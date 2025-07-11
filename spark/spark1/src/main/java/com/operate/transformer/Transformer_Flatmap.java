package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Transformer_Flatmap {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

//        flatmap展开二维数组
//        List<List<Integer>> lists = Arrays.asList(
//                Arrays.asList(1, 2),
//                Arrays.asList(3, 4)
//        );
//        JavaRDD<List<Integer>> rdd = javaSparkContext.parallelize(lists, 2);
//        JavaRDD<Integer> integerJavaRDD = rdd.flatMap(new FlatMapFunction<List<Integer>, Integer>() {
//            @Override
//            public Iterator<Integer> call(List<Integer> integers) throws Exception {
//                ArrayList<Integer> list = new ArrayList<>();
////               实现map功能
//                integers.forEach(num -> list.add(num*2));
////                实现flat功能
//                return list.iterator();
//            }
//        });

//        flatmap拆分单词
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile("./data/text.txt");
//        JavaRDD<String[]> map = stringJavaRDD.map(line -> line.split(" "));  返回的是String[]
        JavaRDD<String> stringJavaRDD1 = stringJavaRDD.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        stringJavaRDD1.collect().forEach(System.out::println);
    }
}
