package com.example.spark

import java.util.Properties

import com.example.spark.models.LogRecord
import org.apache.spark.sql.{DataFrame, SparkSession}

object SimpleSparkSession {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("SimpleSession").getOrCreate()
    val connectionProperties: Properties = new Properties()
    connectionProperties.setProperty("username", "spark")
    connectionProperties.setProperty("password", "spark")

    val dataFrame: DataFrame = spark.read.json("/code/sample.json.log")

    import spark.implicits._
    dataFrame.as[LogRecord].map(record => (
      record.loggerName,
      record.level,
      record.message.length,
      s"${record.thread} - ${record.threadId}"
    )).groupByKey(_._1)
      .mapGroups((key, entries) => {
        var eventCount: Int = 0
        var payloadSize: Long = 0
        val threads: collection.mutable.HashSet[String] = collection.mutable.HashSet[String]()
        var errorCount: Int = 0
        var warnCount: Int = 0
        var infoCount: Int = 0
        var debugCount: Int = 0

        entries.foreach(entry => {
          eventCount += 1
          payloadSize += entry._3
          threads.add(entry._4)
          entry._2 match {
            case "ERROR" => errorCount += 1
            case "WARN" => warnCount += 1
            case "INFO" => infoCount += 1
            case "DEBUG" => debugCount += 1
          }
        })
        (
          key,
          eventCount,
          payloadSize,
          threads.size,
          errorCount,
          warnCount,
          infoCount,
          debugCount
        )
      }).show()
  }

}
