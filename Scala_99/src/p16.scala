
// P16 (**) Drop every Nth element from a list.
//     Example:
//     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

class p16 {
def drop[T](n:Int,l:List[T]):List[T]={
  def _drop(q:Int,s:List[T],r:List[T]):List[T]=(q,s) match{
  case (_,Nil)=>r.reverse
  case (1,head::tail) => _drop(n,tail,r)
  case (_,head::tail) =>_drop(q-1,tail,head::r)
}
  _drop(n,l,List())
  }  

def dropf[T](n:Int,l:List[T]):List[T]={
l.zipWithIndex filter(a=>(a._2 +1)%n !=0) map (_._1)
}
}