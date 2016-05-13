
// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object p07 {
  
  def flatten(l: List[Any]): List[Any] =l flatMap{
    case ms:List[_]=> flatten(ms)
    case e=>List(e)
    
}}