object check {
  def last[A](list:List[A]):A={
    
    if (list.isEmpty) throw new Error("empty list")
    else if (list.tail==Nil) list.head
    else last(list.tail)
    }                                             //> last: [A](list: List[A])A
  
  def last2[A](list:List[A]):A={ list match{
    case head :: Nil => head
    case head :: tail => last2(tail)
    case _      => throw new Error("no element found")
  }
    
    }                                             //> last2: [A](list: List[A])A
    
    def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  }                                               //> lastRecursive: [A](ls: List[A])A
 
  def penultimate[T](list:List[T]):T = {
    if (list.isEmpty) throw new Error("list is empty")
    else if(list.tail== Nil) throw new Error("single element")
    else if(list.tail.tail== Nil) list.head
    else penultimate(list.tail)

   }                                              //> penultimate: [T](list: List[T])T
 
 
  def penultimate1[T](list:List[T]):T={ list match{
    case _ :: tail => penultimate(tail)
    case head :: _ ::Nil => head
 		case _ => throw new Error("emepty list")
  }
  }                                               //> penultimate1: [T](list: List[T])T
 def nth[T](n:Int ,list:List[T]):T=
    if(n < 0) throw new Error("no such element")
    else if (n==0) list.head
    else if (n > list.length) throw new Error("no such element")
    else nth(n-1,list.tail)                       //> nth: [T](n: Int, list: List[T])T

  def length[T](list:List[T]):Int= {
    def accLength[T](acc:Int ,list:List[T]):Int={
    if(list.isEmpty) acc
    else accLength(acc+1,list.tail)
  }
  accLength(0,list)
}                                                 //> length: [T](list: List[T])Int


  def reverse[T](list:List[T]):List[T]=
  { def fillingReverse[T](list:List[T],rlist:List[T]):List[T]=
    if(list.isEmpty) rlist
    else fillingReverse(list.tail,list.head::rlist)
    
    
    fillingReverse(list,List())
    
    
  }                                               //> reverse: [T](list: List[T])List[T]
  
   def isPalindrome[T](list:List[T]):Boolean={
    def compare[T](list:List[T],rlist:List[T],acc:Int):Boolean=
      if(acc > list.length) true
      else if(list.head!=rlist.head) false
      else compare(list.tail,rlist.tail,acc+1)
    
    if(list.isEmpty) true
    else compare(list,list.reverse,0)
  }                                               //> isPalindrome: [T](list: List[T])Boolean
  
   isPalindrome(List(1,2,3,2,1))                  //> res0: Boolean = true
   
   
   }