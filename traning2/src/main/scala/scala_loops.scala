import scala.collection.Map
object scala_loops {
  def main(args: Array[String]): Unit = {
    
    val k=10
   // print(k)
    
    val a = Array(1,2,3,4)
    val b = Array(5,6,7,8)
    val a_len = a.length
    val b_len = b.length
      print("Values of arrary is printed in reguler order\n")
     for(i <- 0 until a_len)
      {
        print(a(i))
        print('\n')
      }
      print("Values of arrary is printed in reverse order\n")
      for(j<-b_len-1 to 0 by -1)
      {
       print(b(j)) 
       print('\n')
      }
      val fam = Map(1->"sankar",2->"Latha",3->"Jithin")
      fam.values.foreach(println)    
      fam.keys.foreach(println)
      fam.map(x=>x+"3").foreach(println)
      
//  print(a)
    
  }
}