#!/bin/sh

if [ $# -eq 0 ]; then
  echo "Please provide the ful-qualified class name to run the task."
  exit 1
fi
CLASS_NAME=$1

# assemble fat jar
sbt assembly

# publish to hdfs
curl -i -XPUT -T target/scala-2.11/spark-interview-quiz-assembly-1.0.jar \
  -H "content-type: application/octet-stream" \
  "http://hadoop:14000/webhdfs/v1/simple/spark-interview-quiz-assembly-1.0.jar?op=CREATE&data=true&user.name=root&overwrite=true"

# submit spark app
/spark-bin/bin/spark-submit \
  --class ${CLASS_NAME} \
  --master spark://spark:6066 \
  --deploy-mode cluster \
  hdfs://hadoop:9000/simple/spark-interview-quiz-assembly-1.0.jar
