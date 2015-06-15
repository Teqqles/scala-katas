import org.scalatest._
import workshop.codekata.PrimeFactors

class PrimeFactorsSpec extends FlatSpec with Matchers {

    "PrimeFactors" should "return an empty list when supplied with 1" in {
        PrimeFactors.generate( 1 ) should be( List( ) )
    }

    "PrimeFactors" should "return a list containing 2 when supplied with 2" in {
        PrimeFactors.generate( 2 ) should be( List( 2 ) )
    }

    "PrimeFactors" should "return a list containing 3 when supplied with 3" in {
        PrimeFactors.generate( 3 ) should be( List( 3 ) )
    }

    "PrimeFactors" should "return a list containing 2, 2 when supplied with 4" in {
        PrimeFactors.generate( 4 ) should be( List( 2, 2 ) )
    }

    "PrimeFactors" should "return a list containing 2, 3 when supplied with 6" in {
        PrimeFactors.generate( 6 ) should be( List( 2, 3 ) )
    }

    "PrimeFactors" should "return a list containing 2, 2, 2 when supplied with 8" in {
        PrimeFactors.generate( 8 ) should be( List( 2, 2, 2 ) )
    }

    "PrimeFactors" should "return a list containing 3, 3 when supplied with 9" in {
        PrimeFactors.generate( 9 ) should be( List( 3, 3 ) )
    }

}