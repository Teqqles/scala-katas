package workshop.codekata

object FizzBuzz {
  def getResult( value:Int ) : String = {
    value % 3 -> value % 5 match {
      case ( 0, 0 ) => "fizzbuzz"
      case ( 0, _ ) => "fizz"
      case ( _, 0 ) => "buzz"
      case _ => value.toString
    }
  }
}
