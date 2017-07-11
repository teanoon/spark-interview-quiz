package com.example.spark

import org.apache.hadoop.mapred.JobConf
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SimpleSparkApplication {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("Simple").setMaster("local[2]")
    val context: SparkContext = new SparkContext(conf)
    val jobConf: JobConf = new JobConf()
    context.hadoopRDD(jobConf, null, null, null)
    val file: RDD[String] = context.textFile("hdfs://hadoop:9000/simple/sample.json.log")
    val result: collection.Map[Int, Long] = file.map(line => line.length).countByValue()
    result.foreach(entry => println(s"${entry._1} has ${entry._2}"))
  }

}
