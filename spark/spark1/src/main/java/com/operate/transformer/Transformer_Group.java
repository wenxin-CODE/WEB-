package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Transformer_Group {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("spark");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        JavaRDD<Integer> rdd = javaSparkContext.parallelize(integers, 2);
        JavaPairRDD<Boolean, Iterable<Integer>> oRDD = rdd.groupBy(new Function<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) throws Exception {
//                if(integer%2==0){
//                    return "偶数";
//                }else{
//                    return "奇数";
//                }
                return integer % 2 == 0;
            }
        });

//        对分组结果求和
        oRDD.mapValues(
                iter -> {
                    int sum = 0;
                    Iterator<Integer> iterator = iter.iterator();
                    while(iterator.hasNext()){
                        sum+=iterator.next();
                    }
                    return sum;
                }
        ).collect().forEach(System.out::println);
    }
}
