package org.spark.training2

object Scala_loop {
  
     def sample_fun()
   {
     print("this is simple function calling!!")
     
   }
  object inner
  {
    def inner_fun()
    {
      print("this is simple fucntion in inner object")
    }
    
    def para_fun(x:Int,y:Int):Int=
    {
      return x+y
      
    }
    
  }
     
     
     
  def main(args: Array[String]): Unit = {
    sample_fun()
    inner.inner_fun() //calling the function which is in another object
    print("\nthe sum of the values x +y is :" + inner.para_fun(10,20))
    val lst = List(1, 2, 3, 4, 5)
    for (i <- lst) {
   //   print(i + "\n")
    }
    
    val result = for(i <- lst;if i<4)yield {  i* i} 
    print(result)
    
    //print("Adding case statment")
    
val age = 50
age match {
case 20 =>print(age)
case 30 =>print(age)
case 40 =>print(age)
case 50 =>print(age)
case _  =>print("default")

}
    
  }

}