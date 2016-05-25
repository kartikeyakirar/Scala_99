
// P25 (*) Generate a random permutation of the elements of a list.
//     Hint: Use the solution of problem P23.
//
//     Example:
//     scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//     res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
import p23
class p25 {
  def randomPermute[T](list:List[T]):List[T]=randomSelect(list.length,list)
}