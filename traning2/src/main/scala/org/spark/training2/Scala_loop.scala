package org.spark.training2

object Scala_loop {
  def main(args: Array[String]): Unit = {
    val lst = List(1, 2, 3, 4, 5)
    for (i <- lst) {
      print(i + "\n")
    }
    
    val result = for(i <- lst;if i<4)yield {  i* i} 
    print(result)
  }

}