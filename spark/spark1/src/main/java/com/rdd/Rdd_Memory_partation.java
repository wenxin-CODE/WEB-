package com.rdd;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.scheduler.cluster.CoarseGrainedClusterMessages;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Rdd_Memory_partation {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<String> strings    = Arrays.asList("zhangsan", "lisi", "wangwu");
        JavaRDD<String> rdd = javaSparkContext.parallelize(strings, 3);
//        分区保存，可以获悉分区情况
        rdd.saveAsTextFile("./data/java_output1");

    }
}
