package com.examples

import org.apache.spark.sql.SparkSession
object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[*]")//几个local代表几个分区，实际分区数由指定分区数量，默认值，核心数共同决定
      .appName("word count")
      .getOrCreate()
    val sc = spark.sparkContext
//    IDEA相对路径以项目根路径为准
    val rdd = sc.textFile("./data/word.txt")
    val counts = rdd.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    counts.collect().foreach(println)
    println("全部的单词数："+counts.count())
    counts.saveAsTextFile("data/output/word-count")
  }
}