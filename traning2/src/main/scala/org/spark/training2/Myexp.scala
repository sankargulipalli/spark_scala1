package org.spark.training2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql


object Myexp {
  
 def main(args: Array[String]): Unit = {
 val conf = new SparkConf()
 conf.set("spark.master","local")
 conf.set("spark.app.name","Demoexp")
 val sc = new SparkContext(conf) 
 
 val rdd1 = sc.textFile("F:\\MY_LEARNING\\SCALA\\ParentTeacherConf.csv", 2)
 val rdd2 = rdd1.flatMap(line=>line.split(" "))
 val rdd3 = rdd2.map(word=>(word,1))
 val count = rdd3.reduceByKey(_+_)
 count.foreach(println)
 
 }
}