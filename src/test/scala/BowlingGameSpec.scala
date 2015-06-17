import org.scalatest._
import workshop.codekata.{BowlingGame, FizzBuzz}

class BowlingGameSpec extends FlatSpec with Matchers with BeforeAndAfter {

    var game: BowlingGame = _

    before {
        game = new BowlingGame
    }

    "BowlingGame" should "be able to play gutterball" in {
        rollMany( 20, 0 )
        game.score should be( 0 )
    }

    private def rollMany( rollCount: Int, pinsKnockedDown: Int ): Unit = {
        for ( i <- 0 until rollCount ) {
            game.roll( pinsKnockedDown )
        }
    }

    private def rollSpare(): Unit = {
        game.roll( 5 )
        game.roll( 5 )
    }

    private def rollStrike(): Unit = {
        game.roll( 10 )
    }

    it should "be able to play a game of 1's" in {
        rollMany( 20, 1 )
        game.score should be( 20 )
    }

    it should "give a player a bonus if they roll a spare" in {
        rollSpare()
        game.roll( 3 )
        rollMany( 17, 0 )
        game.score should be( 16 )
    }

    it should "give a player an extra bonus if they roll a strike" in {
        rollStrike()
        game.roll( 3 )
        game.roll( 4 )
        rollMany( 16, 0 )
        game.score should be( 24 )
    }

    it should "give a player a perfect score for rolling a perfect game" in {
        rollMany( 12, 10 )
        game.score should be( 300 )
    }

}