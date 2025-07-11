package com.operate.transformer;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class Transformer_groupbykey {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf().setMaster("local").setAppName("APP");
        JavaSparkContext jsc = new JavaSparkContext(sc);

        jsc.parallelizePairs(
                Arrays.asList(
                        new Tuple2<String, Integer>("a", 1),
                        new Tuple2<String, Integer>("a", 2),
                        new Tuple2<String, Integer>("b", 3),
                        new Tuple2<String, Integer>("b", 4)
                )
        )
//                .groupByKey()//自动按照key对value进行分组
////                词频统计
//                .mapValues(
//                        iter -> {
//                            int sum = 0;
//                            Iterator<Integer> iterator = iter.iterator();
//                            while(iterator.hasNext()){
//                                int num = iterator.next();
//                                sum+=num;
//                            }
//                            return sum;
//                        }
//                )
                .reduceByKey(Integer::sum)//对groupbykey + mapvalues的融合
//                .groupBy( t -> t._1)
                .collect()
                .forEach(System.out::println);

        jsc.close();

    }
}
