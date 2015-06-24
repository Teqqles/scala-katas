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

    it should "allow uppercase numerals" in {
        RomanNumeralsCalculator( "I" ).getInt should be( 1 )
        RomanNumeralsCalculator( "V" ).getInt should be( 5 )
    }

    it should "allow multiple characters" in {
        RomanNumeralsCalculator( "ii" ).getInt should be( 2 )
        RomanNumeralsCalculator( "iii" ).getInt should be( 3 )
    }

    it should "calculate high numerals followed by low" in {
        RomanNumeralsCalculator( "vi" ).getInt should be( 6 )
        RomanNumeralsCalculator( "xv" ).getInt should be( 15 )
        RomanNumeralsCalculator( "dcl" ).getInt should be( 650 )
    }

    it should "calculate low numerals followed by high" in {
        RomanNumeralsCalculator( "iv" ).getInt should be( 4 )
        RomanNumeralsCalculator( "ix" ).getInt should be( 9 )
        RomanNumeralsCalculator( "xiv" ).getInt should be( 14 )
        RomanNumeralsCalculator( "cd" ).getInt should be( 400 )
        RomanNumeralsCalculator( "cm" ).getInt should be( 900 )
    }

    it should "return zero when an empty string is supplied" in {
        RomanNumeralsCalculator( "" ).getInt should be( 0 )
    }

    it should "throw an exception when invalid characters are supplied" in {
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "virtual" )
        } should have message "only i,v,x,l,c,d and m are allowed"
    }

    it should "throw an exception when 'I', 'X', 'C', and 'M' can be repeated more than 3 times in a row" in {
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "iiii" )
        } should have message "symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "xxxx" )
        } should have message "symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "cccc" )
        } should have message "symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "mmmm" )
        } should have message "symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row"
    }

    it should "throw an exception when 'V', 'L', and 'D' are repeated" in {
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "vv" )
        } should have message "symbols 'V', 'L', and 'D' can never be repeated"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "ll" )
        } should have message "symbols 'V', 'L', and 'D' can never be repeated"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "dd" )
        } should have message "symbols 'V', 'L', and 'D' can never be repeated"
    }

    it should "throw an exception when '1' symbols ('I', 'X', and 'C') are subtracted from values greater than the 2 next highest values" in {
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "il" )
        } should have message "'1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "ic" )
        } should have message "'1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "cic" )
        } should have message "'1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')"
    }

    it should "throw an exception when more than one subtraction is made" in {
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "xxc" )
        } should have message "only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not)"
        the [IllegalArgumentException] thrownBy {
            RomanNumeralsCalculator( "cxxc" )
        } should have message "only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not)"
    }
}



