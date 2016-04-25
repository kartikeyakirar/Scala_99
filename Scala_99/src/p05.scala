
// P05 (*) Reverse a list.
//     Example:
//     scala> reverse(List(1, 1, 2, 3, 5, 8))
//     res0: List[Int] = List(8, 5, 3, 2, 1, 1)

object p05 {
  
  def reverse[T](list:List[T]):List[T]=
  { def fillingReverse[T](list:List[T],rlist:List[T]):List[T]=
    if(list.isEmpty) rlist
    else fillingReverse(list.tail,list.head::rlist)
       
    fillingReverse(list,List())
      
  }
  
}