package com.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Collect2Rdd {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setMaster("local")
    val sc = new SparkContext(conf)
    val arr1=Array(("bj",88),("sh",67),("gz",92))
    val arr2=Array(("bj",94),("sh",85),("gz",95))
    val arr3=Array(("bj",72),("sh",69),("gz",98))
    /********** begin **********/
    //第一步：先将数组进行合并
    val arr = arr1++arr2++arr3

    //第二步：创建RDD
    val stu = sc.makeRDD(arr)

    //第三步：把相同key的进行聚合
    val re = stu.reduceByKey(_+_,3)
    val rdd = re.saveAsTextFile("output1")

    //第四步：输出
    re.foreach(println)
    /********** end **********/
    sc.stop()
  }
}

