object check {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(173); 
  def last[A](list:List[A]):A={
    
    if (list.isEmpty) throw new Error("empty list")
    else if (list.tail==Nil) list.head
    else last(list.tail)
    };System.out.println("""last: [A](list: List[A])A""");$skip(184); 
  
  def last2[A](list:List[A]):A={ list match{
    case head :: Nil => head
    case head :: tail => last2(tail)
    case _      => throw new Error("no element found")
  }
    
    };System.out.println("""last2: [A](list: List[A])A""");$skip(184); 
    
    def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  };System.out.println("""lastRecursive: [A](ls: List[A])A""");$skip(243); 
 
  def penultimate[T](list:List[T]):T = {
    if (list.isEmpty) throw new Error("list is empty")
    else if(list.tail== Nil) throw new Error("single element")
    else if(list.tail.tail== Nil) list.head
    else penultimate(list.tail)

   };System.out.println("""penultimate: [T](list: List[T])T""");$skip(181); 
 
 
  def penultimate1[T](list:List[T]):T={ list match{
    case _ :: tail => penultimate(tail)
    case head :: _ ::Nil => head
 		case _ => throw new Error("emepty list")
  }
  };System.out.println("""penultimate1: [T](list: List[T])T""");$skip(207); 
 def nth[T](n:Int ,list:List[T]):T=
    if(n < 0) throw new Error("no such element")
    else if (n==0) list.head
    else if (n > list.length) throw new Error("no such element")
    else nth(n-1,list.tail);System.out.println("""nth: [T](n: Int, list: List[T])T""");$skip(175); 

  def length[T](list:List[T]):Int= {
    def accLength[T](acc:Int ,list:List[T]):Int={
    if(list.isEmpty) acc
    else accLength(acc+1,list.tail)
  }
  accLength(0,list)
};System.out.println("""length: [T](list: List[T])Int""");$skip(240); 


  def reverse[T](list:List[T]):List[T]=
  { def fillingReverse[T](list:List[T],rlist:List[T]):List[T]=
    if(list.isEmpty) rlist
    else fillingReverse(list.tail,list.head::rlist)
    
    
    fillingReverse(list,List())
    
    
  };System.out.println("""reverse: [T](list: List[T])List[T]""");$skip(310); 
  
   def isPalindrome[T](list:List[T]):Boolean={
    def compare[T](list:List[T],rlist:List[T],acc:Int):Boolean=
      if(acc > list.length) true
      else if(list.head!=rlist.head) false
      else compare(list.tail,rlist.tail,acc+1)
    
    if(list.isEmpty) true
    else compare(list,list.reverse,0)
  };System.out.println("""isPalindrome: [T](list: List[T])Boolean""");$skip(120); 
  
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  };System.out.println("""flatten: (ls: List[Any])List[Any]""");$skip(80); 
  
 

def myFlatten[T](list : List[List[T]]) = for(xs <- list; x <- xs) yield x;System.out.println("""myFlatten: [T](list: List[List[T]])List[T]""");$skip(50); val res$0 = 

  
 myFlatten(List(List(2,3),2,List(1,2,3,2,1)));System.out.println("""res0: <error> = """ + $show(res$0))}
   
   
   }
