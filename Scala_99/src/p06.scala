
// P06 (*) Find out whether a list is a palindrome.
//     Example:
//     scala> isPalindrome(List(1, 2, 3, 2, 1))
//     res0: Boolean = true
object p06 {
  
  
  def isPalindrome[T](list:List[T]):Boolean={
    def compare[T](list:List[T],rlist:List[T],acc:Int):Boolean=
      if(acc > list.length) true
      else if(list.head!=rlist.head) false
      else compare(list.tail,rlist.tail,acc+1)
    
    if(list.isEmpty) true
    else compare(list,list.reverse,0)
  }
}