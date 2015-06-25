package workshop.codekata

class JobSelfReferenceException extends RuntimeException( "Jobs can't depend on themselves", null )

class JobCircularDependencyException extends RuntimeException( "Jobs can't have circular dependencies", null )

case class Job( id: String, dependency: String )

object OrderedJobs {

    def addJob( list: List[ String ], job: Job ): List[ String ] = {
        def insertBefore( x: String, y: String ): List[ String ] = {
            ( list.slice( 0, list.indexOf( x ) ) :+ y ) ::: list.drop( list.indexOf( x ) )
        }

        job match {
            case Job( x, y: Any ) if list.contains( x ) && list.contains( y ) =>
                throw new JobCircularDependencyException
            case Job( x, null ) if !list.contains( x ) => list :+ x
            case Job( x, y: Any ) if !list.contains( x ) && !list.contains( y ) => list :+ y :+ x
            case Job( x, y: Any ) if !list.contains( y ) => insertBefore( x, y )
            case Job( x, y: Any ) if !list.contains( x ) => list :+ x
            case _ => list
        }
    }

    def parse( str: String ): List[ String ] = {
        val list: List[ Job ] = str.split( "\n" ).toList.map( x => JobExtractor( x ) )

        def extractJobs( jobsRemaining: List[ Job ], jobsList: List[ String ] ): List[ String ] = {
            jobsRemaining match {
                case x :: _ => extractJobs( jobsRemaining.tail,
                    addJob( jobsList, x ) )
                case Nil => jobsList
            }
        }
        extractJobs( list, List( ) )
    }

    private def JobExtractor( job: String ): Job = {
        job.split( " =>.?" ) match {
            case Array( x, y ) if x == y => throw new JobSelfReferenceException
            case Array( x, y ) => Job( x, y )
            case Array( x ) if x.length > 0 => Job( x, null )
            case _ => null
        }
    }
}
