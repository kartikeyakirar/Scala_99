
// P11 (*) Modified run-length encoding.
//     Modify the result of problem P10 in such a way that if an element has no
//     duplicates it is simply copied into the result list.  Only elements with
//     duplicates are transferred as (N, E) terms.
//
//     Example:
//     scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

class p11 {
  def encodeModified[T](l:List[T]):List[Any]={
   def _ncode(x:List[Any],y:List[T]):List[Any]=y match{
      case Nil=> x
      case ls =>
        {
          val (q,w)= y span(_==y.head)
          if(q.length == 1)
          _ncode(x:::List(q.head),w)
          else
            _ncode(x:::List((q.length,q.head)),w)
        }
    }
    _ncode(List(),l)
  
  }  
  
  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }
}
  
}