package org.spark.training2

import org.apache.spark.sql.SparkSession
import scala.collection.Map

object scala_collection {
  def main(args: Array[String]): Unit = {
    
    val ss = SparkSession.builder().master("local[*]").appName("myscalacollection").getOrCreate()
    val rdd1=Map(1->"sankar",2->"hema",3->"jittu")
    
    val rdd2=rdd1+(4->"x")
    val per_rdd = ss.sparkContext.parallelize(List(1,2,3,4))
    per_rdd.persist()
    import ss.implicits._
    val df1 = per_rdd.toDF()
    val rdd3= ss.sparkContext.parallelize(List(1,2,3,4))
    val rdd4 = rdd3.reduce(_+_)
    print(rdd4)
    rdd1.keys.foreach(println)   
    rdd2.values.foreach(println)
  
    val b_p_s = df1.rdd.getNumPartitions
    print("number of partitions before repartitions:", b_p_s)
    val a_p_s = df1.repartition(2).rdd.getNumPartitions
    print("\nnnumber of partitions after repartitions:", a_p_s)
    val a_c_p_s = df1.coalesce(1).rdd.getNumPartitions
    print("\nnumber of partitions after coalesce:", a_c_p_s)
    
    //val a_p = df1.rdd.partitions.size
    

  }
}

