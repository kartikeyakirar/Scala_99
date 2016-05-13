// P14 (*) Duplicate the elements of a list.
//     Example:
//     scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//     res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)


class p14 {
 def  duplicat[T](l:List[T]):List[T]= l flatMap(e=> List(e,e))
  
}