
// P15 (**) Duplicate the elements of a list a given number of times.
//     Example:
//     scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

class p15 {
  def duplicateN[T](n:Int,l:List[T]):List[T]={
    l flatMap(e=>List.fill(n)(e))
  }
  
}