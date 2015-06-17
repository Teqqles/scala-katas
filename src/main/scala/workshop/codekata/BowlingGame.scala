package workshop.codekata

class BowlingGame {

    var frame  : Int = 1
    var counter: Int = 0

    case class Ball( pins: Int, frame: Int ) {
        def isLastFrameBonus: Boolean = {
            frame > 10
        }
    }

    var ball: List[ Ball ] = List( )

    def score: Int = {
        def calculateScore( ballsLeft: List[ Ball ], total: Int = 0 ): Int = {
            ballsLeft match {
                case a :: b :: c :: _ if isSpare( a, b ) => calculateScore( ballsLeft.tail, total + a.pins + c.pins )
                case a :: b :: c :: _ if isStrike( a ) => calculateScore( ballsLeft.tail,
                    total + a.pins + b.pins + c.pins )
                case a :: _ if a.isLastFrameBonus => calculateScore( ballsLeft.tail, total )
                case a :: _ => calculateScore( ballsLeft.tail, total + a.pins )
                case Nil => total
            }
        }
        calculateScore( ball )
    }

    private def isStrike( a: Ball ): Boolean = {
        a.pins == 10
    }

    private def isSpare( a: Ball, b: Ball ): Boolean = {
        a.pins + b.pins == 10
    }

    def roll( i: Int ): Unit = {
        val lastBall = Ball( i, frame )
        counter += 1
        if ( isStrike( lastBall ) || counter > 2 ) {
            frame += 1
            counter = 1
        }
        
        ball = ball :+ lastBall
    }

}




