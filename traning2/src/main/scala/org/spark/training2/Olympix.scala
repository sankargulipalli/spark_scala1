package org.spark.training2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.RelationalGroupedDataset

object Olympix {

  def main(args: Array[String]): Unit = {

    val ss = SparkSession.builder()
      .master("local[*]")
      .appName("Olympix").getOrCreate()

    val schema = new StructType()
      .add("athelete", StringType, true)
      .add("age", IntegerType, true)
      .add("country", StringType, true)
      .add("year", IntegerType, true)
      .add("date", StringType, true)
      .add("sport", IntegerType, true)
      .add("gold", IntegerType, true)
      .add("silver", IntegerType, true)
      .add("bronze", IntegerType, true)
      .add("total", IntegerType, true)

    //val raw_source1 = ss.read.format("json").schema(schema).option("header", "true").load("F:\\MY_LEARNING\\SCALA\\olympic.json")
    
  val raw_source1 = ss.read.format("json").option("header", "true").load("F:\\MY_LEARNING\\SCALA\\olympic.json")//working
  //  val raw_source1 = ss.read.format("csv").option("header", "true").option("delimiter", ",").load("F:\\MY_LEARNING\\SCALA\\olympix_data_sample.csv")
    
  //  raw_source1.write.parquet("wf_parq.parquet") //working good
     raw_source1.write.mode("overwrite").parquet("wf_parq.parquet")
    val rf_parq = ss.read.parquet("wf_parq.parquet")
    //val p_s_df =  rf_parq.filter(rf_parq("country")==="Russia") //working
   // p_s_df.show()
    //val cty_rank = rf_parq.groupBy(rf_parq("country")).sum("total").orderBy(desc("sum(total)"))//working
    //val cty_rank = rf_parq.groupBy(rf_parq("country")).sum("total").agg(max("sum(total)")).alias("Rank")
    val ctry_swim = rf_parq.filter(rf_parq("sport")==="Swimming").groupBy(rf_parq("country")).sum("total").orderBy(("sum(total)"))
     ctry_swim.show()
    
    //cty_rank.show()
       
        
    //rf_parq.createOrReplaceTempView("opx_par_tab")
    //ss.sql("SELECT distinct country FROM opx_par_tab").show //working good
    
    //raw_source1.limit(10).show()
    
    
  }

}