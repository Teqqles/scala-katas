
import org.scalatest.{Matchers, FlatSpec}
import workshop.codekata.NumbersInWords

class NumbersInWordsSpec extends FlatSpec with Matchers {
    "NumbersInWords" should "convert single numbers without currency into words" in {
        NumbersInWords.toWords( "1" ) should be( "one" )
        NumbersInWords.toWords( "2" ) should be( "two" )
        NumbersInWords.toWords( "9" ) should be( "nine" )
    }

    it should "handle numbers with a decimal" in {
        NumbersInWords.toWords( "1.01" ) should be( "one point zero one" )
        NumbersInWords.toWords( "2.1" ) should be( "two point one" )
        NumbersInWords.toWords( "9.3" ) should be( "nine point three" )
    }

    it should "display 10s as words" in {
        NumbersInWords.toWords( "10" ) should be( "ten" )
        NumbersInWords.toWords( "11" ) should be( "eleven" )
        NumbersInWords.toWords( "12" ) should be( "twelve" )
        NumbersInWords.toWords( "12" ) should be( "twelve" )
        NumbersInWords.toWords( "20" ) should be( "twenty" )
        NumbersInWords.toWords( "31" ) should be( "thirty one" )
        NumbersInWords.toWords( "51" ) should be( "fifty one" )
    }

    it should "display teens as words" in {
        NumbersInWords.toWords( "13" ) should be( "thirteen" )
        NumbersInWords.toWords( "15" ) should be( "fifteen" )
        NumbersInWords.toWords( "19" ) should be( "nineteen" )
    }

    it should "display 100s as words" in {
        NumbersInWords.toWords( "100" ) should be( "one hundred" )
        NumbersInWords.toWords( "101" ) should be( "one hundred and one" )
        NumbersInWords.toWords( "111" ) should be( "one hundred and eleven" )
        NumbersInWords.toWords( "333" ) should be( "three hundred and thirty three" )
    }

    it should "display 1000s as words" in {
        NumbersInWords.toWords( "1000" ) should be( "one thousand" )
        NumbersInWords.toWords( "1010" ) should be( "one thousand and ten" )
        NumbersInWords.toWords( "1111" ) should be( "one thousand, one hundred and eleven" )
        NumbersInWords.toWords( "3003" ) should be( "three thousand and three" )
    }

    it should "display 10000s as words" in {
        NumbersInWords.toWords( "10000" ) should be( "ten thousand" )
        NumbersInWords.toWords( "10100" ) should be( "ten thousand, one hundred" )
        NumbersInWords.toWords( "11101" ) should be( "eleven thousand, one hundred and one" )
        NumbersInWords.toWords( "90003" ) should be( "ninty thousand and three" )
    }

    it should "display 100000s as words" in {
        NumbersInWords.toWords( "100000" ) should be( "one hundred thousand" )
        NumbersInWords.toWords( "100100" ) should be( "one hundred thousand, one hundred" )
        NumbersInWords.toWords( "101201" ) should be( "one hundred and one thousand, two hundred and one" )
        NumbersInWords.toWords( "900004" ) should be( "nine hundred thousand and four" )
    }

    it should "covert back to numbers" in {
        NumbersInWords.toNumbers( "nine point three" ) should be( "9.3" )
        NumbersInWords.toNumbers( "one hundred thousand" ) should be( "100000" )
        NumbersInWords.toNumbers( "one hundred thousand, one hundred" ) should be( "100100" )
        NumbersInWords.toNumbers( "one hundred and one thousand, two hundred and one" ) should be( "101201" )
        NumbersInWords.toNumbers( "nine hundred thousand and four" ) should be( "900004" )
    }
}



