
// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
package p
class p20 {
def removeAt[T](x:Int,list:List[T]):(List[T],T)= list.splitAt(x) match{
  case (Nil,_) => throw new NoSuchElementException
  case (pre,h::post)=> (pre ::: post,h)
  case (pre, Nil)   => throw new NoSuchElementException
  }
  

}