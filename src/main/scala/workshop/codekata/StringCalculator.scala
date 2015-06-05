package workshop.codekata

object StringCalculator {

    implicit class StringCalculatorFeatures( delimiters: String ) {
        def escapeDanglingMeta: String = {
            delimiters.replaceAll( "\\*", """\\*""" )
        }
    }

    val singleCharacterDelimiter           = """^//(.)\n(.+)""".r
    val multipleCharacterDelimiter         = """^//\[([^\]]+)\]\n(.+)""".r
    val multipleCharacterMultipleDelimiter = """^(//)(\[.+?\])\n(.+)""".r

    def add( numbers: String ): Int = {
        extractDelimiterFromString( numbers ) match {
            case (_, "") => 0
            case (delimiter, separatedValues) =>
                addNumbers( separatedValues
                        .split( delimiter.escapeDanglingMeta + "|\\n" ) )
        }
    }

    private def extractDelimiterFromString( stringContainingDelimiter: String ): (String, String) = {
        stringContainingDelimiter match {
            case singleCharacterDelimiter( delimiter, separatedValues ) => delimiter -> separatedValues
            case multipleCharacterDelimiter( delimiter, separatedValues ) => delimiter -> separatedValues
            case multipleCharacterMultipleDelimiter( _, delimiters, separatedValues ) =>
                delimiters
                        .replaceAll( """\[""", "" )
                        .split( """\]""" )
                        .mkString( "|" ) -> separatedValues
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
