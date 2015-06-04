package workshop.codekata

object StringCalculator {
    def add( numbers: String ): Int = {
        extractDelimiterFromString( numbers ) match {
            case (_, "") => 0
            case (delimiter, separatedValues) =>
                addNumbers( separatedValues
                        .split( delimiter + "|\\n" ) )
        }
    }

    private def extractDelimiterFromString( stringContainingDelimiter: String ): (String, String) = {
        val singleCharacterDelimiter = """^//(.)\n(.+)""".r
        val multipleCharacterDelimiter = """^//\[([^\]]+)\]\n(.+)""".r
        val multipleCharacterMultipleDelimiter = """^(//)(\[.+?\])\n(.+)""".r
        stringContainingDelimiter match {
            case singleCharacterDelimiter( delimiter, separatedValues ) => delimiter
                    .replaceAll( "\\*", """\\*""" ) -> separatedValues
            case multipleCharacterDelimiter( delimiter, separatedValues ) => delimiter
                    .replaceAll( "\\*", """\\*""" ) -> separatedValues
            case multipleCharacterMultipleDelimiter( _, delimiters, separatedValues ) =>
                delimiters
                        .replaceAll( """\[""", "" )
                        .split( """\]""" )
                        .mkString( "|" )
                        .replaceAll( "\\*", """\\*""" ) -> separatedValues
            case _ => "," -> stringContainingDelimiter
        }
    }

    private def addNumbers( stringContainingNumbers: Seq[ String ] ): Int = {
        if ( stringContainingNumbers.exists( _.toInt <= 0 ) ) {
            throw new NumberFormatException( "negatives not allowed (" + stringContainingNumbers
                    .filter( _.toInt <= 0 )
                    .mkString( "," ) + ")" )
        } else {
            stringContainingNumbers.filter( _.toInt < 1000 ).foldLeft( 0 )( ( b, a: String ) => b + a.toInt )
        }
    }
}
