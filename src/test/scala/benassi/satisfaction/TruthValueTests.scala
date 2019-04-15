package benassi
package satisfaction
import org.scalatest.{FlatSpec, Matchers}

class TruthSpec extends FlatSpec with Matchers {

  import TruthImplicits._

  def evaluate[E <: Expression](implicit t: Truth[E]): Option[E] = Option.empty[E]

  "evaluate" should "correctly evaluate the truth of expressions" in {

    evaluate[T]
    evaluate[T & T]
    evaluate[~[F]]
    evaluate[T | F]
    evaluate[F | T]
    evaluate[F -> F]
    evaluate[T -> T]
    evaluate[F -> T]
    evaluate[T <-> T]
    evaluate[F <-> F]

    evaluate[~[T] | (T & (T -> (F | (T & T <-> ~[F & T]))))]

    assertDoesNotCompile("evaluate[F]")
    assertDoesNotCompile("evaluate[F & T]")
    assertDoesNotCompile("evaluate[T & F]")
    assertDoesNotCompile("evaluate[F & F]")
    assertDoesNotCompile("evaluate[~[T]]")

  }

}
