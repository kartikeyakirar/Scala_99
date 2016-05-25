
// P18 (**) Extract a slice from a list.
//     Given two indices, I and K, the slice is the list containing the elements
//     from and including the Ith element up to but not including the Kth
//     element of the original list.  Start counting the elements with 0.
//
//     Example:
//     scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('d, 'e, 'f, 'g)

class p18 {
  def slice[T](x:Int,y:Int,list:List[T]):List[T]={
    
    val(a,b)=list.zipWithIndex span(e=>(e._2+1)%(x+1)!=0)
    val(c,d)=b span(e=>(e._2+1)%(y+1)!=0)
    c.map(_._1)
  }
  
   // Functional.
  def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =
    ls drop s take (e - (s max 0))
}