import org.scalatest._
import workshop.codekata.{JobCircularDependencyException, JobSelfReferenceException, OrderedJobs}

class OrderedJobsSpec extends FlatSpec with Matchers {

    "orderedJobs" should "empty string should contain no jobs" in {
        OrderedJobs.parse( "" ) should be( List( ) )
    }

    it should "contain the job 'a' given string 'a =>' " in {
        OrderedJobs.parse( "a =>" ) should be( List( "a" ) )
    }

    it should "string 'a =>\nb =>\nc =>' should contain the jobs 'a', 'b' and 'c'" in {
        OrderedJobs.parse( "a =>\nb =>\nc =>" ) should be( List( "a", "b", "c" ) )
    }

    it should "string 'a =>\nb => c\n c=>' should contain the jobs 'a', 'b' and 'c'" in {
        OrderedJobs.parse( "a =>\nb => c\nc =>" ) should be( List( "a", "b", "c" ) )
    }

    it should "string 'a =>\nb => c\n c=>' should contain the job 'c' before the job 'b'" in {
        OrderedJobs.parse( "a =>\nb => c\nc =>" ) should be( List( "a", "c", "b" ) )
    }

    it should "string 'a =>\nb => c\nc => f\nd => a\ne => b\nf =>' should follow correct dependencies" in {
        OrderedJobs.parse( "a =>\nb => c\nc => f\nd => a\ne => b\nf =>" ) should be(
            List( "a",
                "f",
                "c",
                "b",
                "d",
                "e" ) )
    }

    it should "string 'a =>\nb =>\nc => c' should raise an error saying 'Jobs can't depend on themselves'" in {
        the[ JobSelfReferenceException ] thrownBy {
            OrderedJobs.parse( "a =>\nb =>\nc => c" )
        } should have message "Jobs can't depend on themselves"
    }

    it should "string 'a =>\nb => c\nc => f\nd => a\ne =>\nf => b' should raise an error saying 'Jobs can't have circular dependencies'" in {
        the[ JobCircularDependencyException ] thrownBy {
            OrderedJobs.parse( "a =>\nb => c\nc => f\nd => a\ne =>\nf => b" )
        } should have message "Jobs can't have circular dependencies"

    }

}