import org.scalatest._
import workshop.codekata.StringCalculator

class StringCalculatorSpec extends FlatSpec with Matchers {

    "StringCalculator" should "calculate up to three numbers in a string, returning zero for empty" in {
        StringCalculator.add( "" ) should be( 0 )
        StringCalculator.add( "1" ) should be( 1 )
        StringCalculator.add( "1,2" ) should be( 3 )
    }

    it should "handle more than two numbers" in {
        StringCalculator.add( "1,2,3,4,5" ) should be( 15 )
    }

    it should "allow the use of new line as an alternative delimiter" in {
        StringCalculator.add( "1\n2,3" ) should be( 6 )
    }

    it should "support inline delimiters" in {
        StringCalculator.add( "//;\n1;2" ) should be( 3 )
    }

    it should "throw an exception 'negatives not allowed' when negatives are present" in {
        the [NumberFormatException] thrownBy {
            StringCalculator.add( "1,-2,3" )
        } should have message "negatives not allowed (-2)"
    }

    it should "show all negatives present in a string when throwing an exception" in {
        the [NumberFormatException] thrownBy {
            StringCalculator.add( "1,-2,3,-5" )
        } should have message "negatives not allowed (-2,-5)"
    }

    it should "ignore numbers bigger than 1000" in {
        StringCalculator.add( "1,2,1003" ) should be( 3 )
    }

    it should "support delimiters of any length within []" in {
        StringCalculator.add( "//[***]\n2***3" ) should be( 5 )
    }

    it should "support multiple delimiters of any length within []" in {
        StringCalculator.add( "//[***][%]\n2***3%5" ) should be( 10 )
    }

}