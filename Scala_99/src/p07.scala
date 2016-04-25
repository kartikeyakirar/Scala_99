
// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object p07 {
  
  def flatten(l: List[Any]): List[Any] ={ 
    def _flatten(list:List[Any],rlist:List[Any]):List[Any]=rlist match {
    case Nil => Nil
    case (h:List[_])::tail => _flatten(list:::h,tail)
    case h::tail => _flatten(list:::List(h),tail)
    }
    _flatten(List(),l)
}}