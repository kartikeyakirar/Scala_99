// P09 (**) Pack consecutive duplicates of list elements into sublists.
//     If a list contains repeated elements they should be placed in separate
//     sublists.
//
//     Example:
//     scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))


object p09 {
  def pack[T](l:List[T]):List[List[T]]={
 def sub(x:List[List[T]],y:List[T]):List[List[T]]=y match{
 case Nil => x
 case h:: tail if(x.isEmpty || x.last.last !=h) => sub(x:::List(List(h)),tail)
 case h::tail => sub(x.init:::List(x.last:::List(h)),tail)
 }
 sub(List(),l)
 
 } 
}