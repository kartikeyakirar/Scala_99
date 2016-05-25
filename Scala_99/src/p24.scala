// P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//     Example:
//     scala> lotto(6, 49)
//     res0: List[Int] = List(23, 1, 17, 33, 21, 37)


class p24 {
  def lotto(x:Int,tex:Int):List[Int]=randomSelect(x,range(0,tex+1))
}