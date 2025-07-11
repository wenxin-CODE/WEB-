package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class wordCount {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf();
        sc.setMaster("local").setAppName("APP");
        JavaSparkContext jsc = new JavaSparkContext(sc);
        JavaRDD<String> lineRDD = jsc.textFile("./data/word.txt");
        JavaRDD<String> wordRDD = lineRDD.flatMap(line -> (Arrays.asList(line.split(" ")).iterator()));
        JavaPairRDD<String, Iterable<String>> groupRDD = wordRDD.groupBy(word -> word);
        JavaPairRDD<String, Integer> resRDD = groupRDD.mapValues(iter -> {
            int sum = 0;
            for (String s : iter) {
                sum++;
            }
            return sum;
        });
        resRDD.collect().forEach(System.out::println);
    }
}
