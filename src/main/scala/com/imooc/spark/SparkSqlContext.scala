package com.imooc.spark

import org.apache.spark.sql.SparkSession


object SparkSqlContext {

  def main(args: Array[String]): Unit = {
    
    val path = args(0)
   
    val spark = SparkSession.builder
      .master("local")
      .appName("Word_Count")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    
    import spark.implicits._

    val df = spark.read.json(path)
    df.show()
    
    spark.stop()
   
  }
}