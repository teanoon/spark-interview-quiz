package com.example.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SimpleSparkApplication {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("Simple")
    val context: SparkContext = new SparkContext(conf)
    val file: RDD[String] = context.textFile("hdfs://hadoop:9000/simple/sample.json.log")
    val result: collection.Map[Int, Long] = file.map(line => line.length).countByValue()
    result.foreach(entry => println(s"${entry._1} has ${entry._2}"))
  }

}
