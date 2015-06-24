package workshop.codekata

case class HangmanGame( private val secretWord: String ) {

    if ( secretWord.contains( " " ) ) {
        throw new IllegalArgumentException( "only one word can be supplied in this game" )
    }

    private def revealCharacter( wordCharacter: Char ): Char = {
        if ( guesses.contains( wordCharacter.toUpper ) ) {
            wordCharacter
        } else {
            '_'
        }
    }

    val secret = secretWord.map( x => x )

    def guess( c: Char ): Seq[ Char ] = {
        if ( guessesRemaining == 0 ) {
            throw new UnsupportedOperationException( "you've used up all your guesses" )
        }
        guesses = guesses :+ c.toUpper
        word
    }

    var guesses: List[ Char ] = List( )

    def guessesRemaining = 9 - guesses.length

    def word: Seq[ Char ] = secret.map( x => revealCharacter( x ) )

}




