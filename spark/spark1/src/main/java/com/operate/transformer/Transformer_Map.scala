package com.operate.transformer

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object Transformer_Map {
  def main(args: Array[String])={
    val spark = SparkSession
      .builder()
      .master("local")//几个local代表几个分区，实际分区数由指定分区数量，默认值，核心数共同决定
      .appName("word count")
      .getOrCreate()
    val sc = spark.sparkContext
     val value: RDD[Int] = sc.parallelize(List(1, 2, 3, 4),2)
     val value1: RDD[Int] = value.map(_ * 2)
    value1.collect()
    value1.foreach(println)
  }


}
