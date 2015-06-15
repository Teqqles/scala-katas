package workshop.codekata

object PrimeFactors {
    def generate( a: Int, factor: Int = 2 )( implicit list: List[ Int ] = List( ) ): List[ Int ] = {
        a match {
            case b if b % factor == 0 => generate( b / factor )( list :+ factor )
            case b if b > 1 => generate( b, factor + 1 )( list )
            case b if b <= 1 => list
        }
    }
}



