
// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8


object p01 {
  
  // method 1
  def last1[A](list:List[A]):A={
    
    if (list.isEmpty) throw new Error("empty list") 
    else if (list.tail==Nil) list.head
    else last1(list.tail)
    }
  
  // method 2
  
  def last2[A](list:List[A]):A={ list match{
    case head :: Nil => head
    case head :: tail => last2(tail)
    case _ => throw new Error 
  }
  }
  
   //method 3
  def last3[A](list:List[A]):A=list.last
  
   //method 4
  def last4[A](list:List[A]):A=list.reverse.head
    
}