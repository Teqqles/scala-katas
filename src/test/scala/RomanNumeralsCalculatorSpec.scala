import org.scalatest._
import workshop.codekata.RomanNumeralsCalculator

class RomanNumeralsCalculatorSpec extends FlatSpec with Matchers {

    "RomanNumeralsCalculator" should "return an integer with single numerals" in {
        RomanNumeralsCalculator( "i" ).getInt should be( 1 )
        RomanNumeralsCalculator( "v" ).getInt should be( 5 )
        RomanNumeralsCalculator( "x" ).getInt should be( 10 )
        RomanNumeralsCalculator( "l" ).getInt should be( 50 )
        RomanNumeralsCalculator( "c" ).getInt should be( 100 )
        RomanNumeralsCalculator( "d" ).getInt should be( 500 )
        RomanNumeralsCalculator( "m" ).getInt should be( 1000 )
    }

    it should "calculate high numerals followed by low" in {
        RomanNumeralsCalculator( "vi" ).getInt should be( 6 )
        RomanNumeralsCalculator( "xv" ).getInt should be( 15 )
    }
}



