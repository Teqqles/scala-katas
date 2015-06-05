package workshop.codekata

case class RomanNumeralsCalculator( roman: String ) {

    val romanCharacterList = roman.toList

    def getInt = {
        romanCharacterList.foldLeft( 0 ) { ( b, a ) => b + romanCharacterToInteger( a )}
    }

    private def romanCharacterToInteger( romanCharacter: Char ): Int = {
        romanCharacter match {
            case 'i' => 1
            case 'v' => 5
            case 'x' => 10
            case 'l' => 50
            case 'c' => 100
            case 'd' => 500
            case 'm' => 1000
        }
    }

}



