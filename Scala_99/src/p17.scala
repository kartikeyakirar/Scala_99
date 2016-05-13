
// P17 (*) Split a list into two parts.
//     The length of the first part is given.  Use a Tuple for your result.
//
//     Example:
//     scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

class p17 {
 def split[T](n:Int,l:List[T]):(List[T],List[T])={
 val (a,b)=l.zipWithIndex span(e=>(e._2 +1)%n!=0)      
 (a map(_._1) , b map(_._1))
 } 
 
 def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (ls.take(n), ls.drop(n))
}