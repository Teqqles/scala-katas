# Scala Katas

A repo for practicing Scala implementation using code katas.  Feel free to download, browse through the tests and have a go with your own implementation.

## Fizz Buzz

[./src/main/scala/workshop/codekata/FizzBuzz.scala](https://github.com/Teqqles/scala-katas/blob/master/src/main/scala/workshop/codekata/FizzBuzz.scala)

[./src/test/scala/FizzBuzzSpec.scala](https://github.com/Teqqles/scala-katas/blob/master/src/test/scala/FizzBuzzSpec.scala)

Return “fizz”, “buzz” or “fizzbuzz”.

For a given natural number greater than zero return:

“fizz” if the number is dividable by 3
“buzz” if the number is dividable by 5
“fizzbuzz” if the number is dividable by 15
the same number if no other requirement is fulfilled

## Roman Numerals Calculator
### from: http://securesoftwaredev.com/2011/12/05/practicing-tdd-using-the-roman-numerals-kata/

1. Given a single Roman numeral I can convert this to integers
2. Given multiple Roman numerals I can add these together (when supplied in order)
3. The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM')
4. The symbols 'I', 'X', 'C', and 'M' can be repeated at most 3 times in a row.
5. The symbols 'V', 'L', and 'D' can never be repeated.
6. The '1' symbols ('I', 'X', and 'C') can only be subtracted from the 2 next highest values ('IV' and 'IX', 'XL' and 'XC', 'CD' and 'CM').
7. Only one subtraction can be made per numeral ('XC' is allowed, 'XXC' is not).
8. The '5' symbols ('V', 'L', and 'D') can never be subtracted.

## String Calculator
### from: http://osherove.com/tdd-kata-1/

[./src/main/scala/workshop/codekata/StringCalculator.scala](https://github.com/Teqqles/scala-katas/blob/master/src/main/scala/workshop/codekata/StringCalculator.scala)

[./src/test/scala/StringCalculatorSpec.scala](https://github.com/Teqqles/scala-katas/blob/master/src/test/scala/StringCalculatorSpec.scala)

1. Given a string "" return 0
2. Given a string containing a number "1" return that number
3. Given a string containing two numbers "1,2" calculate and return the sum of those numbers
