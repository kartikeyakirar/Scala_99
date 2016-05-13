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
  
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }                                               //> flatten: (ls: List[Any])List[Any]
  
 

def myFlatten[T](list : List[List[T]]) = for(xs <- list; x <- xs) yield x
                                                  //> myFlatten: [T](list: List[List[T]])List[T]

  
 //myFlatten(List(List(2,3),2,List(1,2,3,2,1)))
   
   def comparess[T](list:List[T]):List[T]= list.distinct
                                                  //> comparess: [T](list: List[T])List[T]
      
      comparess(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  //> res0: List[Symbol] = List('a, 'b, 'c, 'd, 'e)

 //def pack[T](l:List[T]):List[List[T]]=l.groupBy(x=>x)
 List(1,3,4,5).init                               //> res1: List[Int] = List(1, 3, 4)
 
 def pack[T](l:List[T]):List[List[T]]={
 def sub(x:List[List[T]],y:List[T]):List[List[T]]=y match{
 case Nil => x
 case xl=>{
 val (q,w)= y span (_== y.head)
   sub(x:::List(q) ,w)
 }
 }
 sub(List(),l)
 
 }                                                //> pack: [T](l: List[T])List[List[T]]
pack( List(1,1,1,1,3,3,4,4))                      //> res2: List[List[Int]] = List(List(1, 1, 1, 1), List(3, 3), List(4, 4))


 def encode[T](l:List[T]):List[(Int,T)]={
   def _ncode(x:List[(Int,T)],y:List[T]):List[(Int,T)]=y match{
      case Nil=> x
      case ls =>
        {
          val (q,w)= y span(_==y.head)
          _ncode(x:::List((q.length,q.head)),w)
        }
    }
    _ncode(List(),l)
  
  }                                               //> encode: [T](l: List[T])List[(Int, T)]
  encode( List(1,1,1,1,3,3,4,4))                  //> res3: List[(Int, Int)] = List((4,1), (2,3), (2,4))
   encode( List(1,1,1,1,3,3,4,4))                 //> res4: List[(Int, Int)] = List((4,1), (2,3), (2,4))
   
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
  
  }                                               //> encodeModified: [T](l: List[T])List[Any]
  
  encodeModified( List(1,1,1,4,6,3,3,4,4))        //> res5: List[Any] = List((3,1), 4, 6, (2,3), (2,4))
  
  def decode[T](l:List[(Int,T)]):List[T] =
  {
    l flatMap(a=>List.fill(a._1)(a._2))
    
  }                                               //> decode: [T](l: List[(Int, T)])List[T]
  decode(List((4,1), (2,3), (2,4)))               //> res6: List[Int] = List(1, 1, 1, 1, 3, 3, 4, 4)
  
  def duplicateN[T](n:Int,l:List[T]):List[T]={
    l flatMap(e=>List.fill(n)(e))
  }                                               //> duplicateN: [T](n: Int, l: List[T])List[T]
  duplicateN(3,List(1,2,3,4,5))                   //> res7: List[Int] = List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
 
 
 def drop[T](n:Int,l:List[T]):List[T]={
  def _drop(q:Int,s:List[T],r:List[T]):List[T]=(q,s) match{
  case (_,Nil)=>r.reverse
  case (1,head::tail) => _drop(n,tail,r)
  case (_,head::tail) =>_drop(q-1,tail,head::r)
}
  _drop(n,l,List())
  }                                               //> drop: [T](n: Int, l: List[T])List[T]
   def split[T](n:Int,l:List[T]):(List[T],List[T])={
 val (a,b)=l.zipWithIndex span(e=>(e._2+1)%(n+1)!=0)
 (a map(_._1) , b map(_._1))
 }                                                //> split: [T](n: Int, l: List[T])(List[T], List[T])
 
 split(3,List(1,2,3,4,5,6,7))                     //> res8: (List[Int], List[Int]) = (List(1, 2, 3),List(4, 5, 6, 7))
  }