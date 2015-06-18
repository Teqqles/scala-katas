import org.scalatest._
import workshop.codekata.NasaCountdown

class NasaCountdownSpec extends FlatSpec with Matchers {

    "NasaCountdown" should "countdown to zero given any number" in {
        NasaCountdown.Countdown( 5 ) should be (List(5,4,3,2,1,0))
        NasaCountdown.Countdown( 11 ) should be (List(11,10,9,8,7,6,5,4,3,2,1,0))
    }

    it should "not countdown if we're given negative values" in {
        NasaCountdown.Countdown( -5 ) should be (List())
    }

}