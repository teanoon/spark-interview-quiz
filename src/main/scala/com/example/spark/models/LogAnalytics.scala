package com.example.spark.models

case class LogAnalytics(
                         loggerName: String,
                         eventCount: Long,
                         errorCount: Long,
                         warnCount: Long,
                         infoCount: Long,
                         debugCount: Long,
                         payloadSize: Long,
                         threadCount: Long)
