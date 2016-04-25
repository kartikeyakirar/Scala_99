// P02 (*) Find the last but one element of a list.
//     Example:
//     scala> penultimate(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 5


object p02 {
  
  
  //method1
 def penultimate[T](list:List[T]):T = {
    if (list.isEmpty) throw new Error("list is empty")
    else if(list.tail== Nil) throw new Error("single element")
    else if(list.tail.tail== Nil) list.head
    else penultimate(list.tail)

   } 
 
 //method2
 def penultimate1[T](list:List[T]):T={ list match{
    case _ :: tail => penultimate1(tail)
    case head :: _ ::Nil => head
 		case _ => throw new Error("emepty list")
  }
  }
 
}