package org.spark.training2
import org.apache.spark.sql.SparkSession


object sparksession {
  def main(args: Array[String]): Unit = {
    val ss = SparkSession.builder()
              .master("local[*]") 
             .appName("Demosparksession").getOrCreate()
   val rdd1 = ss.sparkContext.textFile("dParentTeacherConf.csv") //RDD
   val df1 = ss.read.format("csv").load("F:\\MY_LEARNING\\SCALA\\ParentTeacherConf.csv") //DF

    df1.write.parquet("parentteacher3.parquet")
   val parquetFileDF = ss.read.parquet("parentteacher3.parquet") //parquet
   parquetFileDF.createOrReplaceTempView("parquetFilesql3")
   //ss.sql("SELECT * FROM parquetFilesql2 ").show  //SQL
   import ss.implicits._
   val df2 = rdd1.toDF() //RDD To DF using Implicits
 //  rdd1.foreach(println)
   df2.show()
    
  }
}