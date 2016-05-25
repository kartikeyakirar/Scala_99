// P22 (*) Create a list containing all integers within a given range.
//     Example:
//     scala> range(4, 9)
//      res0: List[Int] = List(4, 5, 6, 7, 8, 9)

class p22 {
  def range(x:Int,y:Int):List[Int]={
    if(x>y) Nil
    else x::range(x+1,y)
  }
  
  def range1(x:Int,y:Int):List[Int]=List.range(x,y+1)
  
}