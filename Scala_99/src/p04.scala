
// P04 (*) Find the number of elements of a list.
//     Example:
//     scala> length(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 6

object p04 {
  def length[T](list:List[T]):Int= {
    def accLength[T](acc:Int ,list:List[T]):Int={
    if(list.isEmpty) acc
    else accLength(acc+1,list.tail)
  }
  accLength(0,list)
}}