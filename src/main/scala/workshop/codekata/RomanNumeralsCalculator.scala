package workshop.codekata

case class RomanNumeralsCalculator( roman: String ) {

    val romanCharacterList     = ( roman + "0" ).toLowerCase.toList
    val invalidRomanCharacters = """[^ivxlcdm]""".r
    val invalidOneMultiples    = """([ixcm])\1\1\1""".r
    val invalidFiveMultiples   = """[vld]{2,}""".r

    roman.toLowerCase match {
        case x if invalidRomanCharacters.findFirstIn( x ) != None =>
            throw new IllegalArgumentException( "only i,v,x,l,c,d and m are allowed" )
        case invalidOneMultiples( _ ) => throw new IllegalArgumentException(
            "symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row" )
        case invalidFiveMultiples( ) => throw new IllegalArgumentException(
            "symbols 'V', 'L', and 'D' can never be repeated" )
        case _ =>
    }

    detectIllegalSubtractions( romanCharacterList.map( x => romanCharacterSequence( x ) ) )

    private def detectIllegalSubtractions( list: List[ Int ] ): Unit = {
        list match {
            case x :: y :: _ if x <= y && ( y - x ) > 2 => throw new IllegalArgumentException(
                "'1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')" )
            case x :: y :: z :: _ if x <= y && z > y => throw new IllegalArgumentException(
                "only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not)" )
            case _ :: tail => detectIllegalSubtractions( tail )
            case Nil =>
        }
    }

    def getInt = {
        romanCharacterList
                .zip( romanCharacterList.tail )
                .foldLeft( 0 ) { ( b, a ) => b + pairCheck( a._1, a._2 )}
    }

    private def romanCharacterToInteger( romanCharacter: Char ): Int = {
        romanCharacter match {
            case '0' => 0
            case 'i' => 1
            case 'v' => 5
            case 'x' => 10
            case 'l' => 50
            case 'c' => 100
            case 'd' => 500
            case 'm' => 1000
        }
    }

    private def romanCharacterSequence( romanCharacter: Char ): Int = {
        romanCharacter match {
            case '0' => 0
            case 'i' => 1
            case 'v' => 2
            case 'x' => 3
            case 'l' => 4
            case 'c' => 5
            case 'd' => 6
            case 'm' => 7
        }
    }


    private def pairCheck( a: Char, b: Char ): Int = {
        val convertedNumeral = romanCharacterToInteger( a )
        if ( convertedNumeral >= romanCharacterToInteger( b ) ) {
            convertedNumeral
        } else {
            -convertedNumeral
        }
    }

}



