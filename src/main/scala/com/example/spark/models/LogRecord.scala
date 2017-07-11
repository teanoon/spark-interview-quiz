package com.example.spark.models

case class LogRecord(
                      loggerName: String,
                      message: String,
                      thread: String,
                      threadId: BigInt,
                      level: String)
