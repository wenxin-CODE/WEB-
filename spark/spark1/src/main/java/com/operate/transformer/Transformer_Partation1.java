package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Transformer_Partation1 {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local[2]");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        JavaRDD<Integer> parallelize = javaSparkContext.parallelize(integers, 2);
//        数据在相同的分区中转换
//        JavaRDD<Object> map = parallelize.map(x -> x * 2);
//        parallelize.saveAsTextFile("rdd");
//        map.saveAsTextFile("operate");

//        不同的分区并行执行
//        JavaRDD<Integer> map = parallelize.map(
//                num -> {
//                    System.out.println("@" + num);
//                    return num * 2;
//                }
//        );
//        map.collect();

//        多个rdd的多个分区互不关联，不需要等待
        JavaRDD<Integer> map1 = parallelize.map(
                num -> {
                    System.out.println("@@@" + num);
                    return num;
                }
        );
        JavaRDD<Integer> map2 = map1.map(
                num -> {
                    System.out.println("###" + num);
                    return num;
                }
        );
        map2.collect();

    }
}
