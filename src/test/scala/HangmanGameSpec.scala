import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import workshop.codekata.HangmanGame

class HangmanGameSpec extends FlatSpec with Matchers {

    val game: HangmanGame = HangmanGame( "Hangman" )

    def makeGuesses( game: HangmanGame, guessCount: Int ): Unit = {
        val guessCharacter = 'a'
        for ( guess <- 0 until guessCount ) {
            game.guess( ( guessCharacter.toInt + guess ).toChar )
        }
    }

    "HangmanGame" should "show placeholders for the word(s) we need to discover" in {
        game.word should be( List( '_', '_', '_', '_', '_', '_', '_' ) )
    }

    it should "not allow multiple words" in {
        the[ IllegalArgumentException ] thrownBy {
            HangmanGame( "Hello World" )
        } should have message "only one word can be supplied in this game"
    }

    it should "show how many guesses you have left, guesses you have used and let you guess" in {
        game.guessesRemaining should be( 9 )
        game.guesses should be( List( ) )
        game.guess( 'f' ) should be( List( '_', '_', '_', '_', '_', '_', '_' ) )
    }

    it should "take away guesses remaining once you have had a guess and show you previous guesses" in {
        game.guessesRemaining should be( 8 )
        game.guesses should be( List( 'F' ) )
    }

    it should "reveal characters in the word when you guess correctly" in {
        game.guess( 'h' ) should be( List( 'H', '_', '_', '_', '_', '_', '_' ) )
        game.word should be( List( 'H', '_', '_', '_', '_', '_', '_' ) )
    }

    it should "reveal multiple characters with a good guess" in {
        game.guess( 'n' ) should be( List( 'H', '_', 'n', '_', '_', '_', 'n' ) )
    }

    it should "only allow you 9 guesses" in {
        val game: HangmanGame = HangmanGame( "Hangman" )
        makeGuesses( game, 9 )
        the[ UnsupportedOperationException ] thrownBy {
            game.guess( 'z' )
        } should have message "you've used up all your guesses"
    }

}