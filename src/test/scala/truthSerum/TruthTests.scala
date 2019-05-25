package truthSerum

import org.scalatest.{FlatSpec, Matchers}
import shapeless.test.illTyped

class TruthTests extends FlatSpec with Matchers {

  import TruthImplicits._

  def evaluate[E <: Expression](implicit t: Truth[E]): Option[E] = Option.empty[E]

  "evaluate" should "correctly evaluate the truth of expressions" in {

    evaluate[T]
    evaluate[T & T]
    evaluate[![F]]
    evaluate[T | F]
    evaluate[F | T]
    evaluate[F -> F]
    evaluate[T -> T]
    evaluate[F -> T]
    evaluate[T <-> T]
    evaluate[F <-> F]

    evaluate[![T] | (T & (T -> (F | (T & T <-> ![F & T]))))]

    illTyped("evaluate[F]", "could not find implicit value for parameter.*")
    illTyped("evaluate[F & T]", "could not find implicit value for parameter.*")
    illTyped("evaluate[T & F]", "could not find implicit value for parameter.*")
    illTyped("evaluate[F & F]", "could not find implicit value for parameter.*")
    illTyped("evaluate[![T]]", "could not find implicit value for parameter.*")

  }

}
