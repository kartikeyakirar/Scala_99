// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)


class p21 {
  def insertAt[T](sub:T,x:Int,list:List[T]):List[T]=list.splitAt(x) match{
    case (a,b) => a :::List(sub) ::: b
  }
  
}