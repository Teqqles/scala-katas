package workshop.codekata

object NasaCountdown {
    def Countdown( startingCount: Int ): List[ Int ] = {
        def generateCountdownEntry( currentCount: Int, countdown: List[ Int ] ): List[ Int ] = {
            currentCount match {
                case _ if currentCount < 0 => countdown
                case _ => generateCountdownEntry( currentCount - 1, countdown :+ currentCount )
            }
        }
        generateCountdownEntry(
            startingCount, List( ) )
    }
}



