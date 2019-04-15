package benassi
package satisfaction
package interpretation

class TotalInterpretation[E[_] <: Expression]

trait TotalInterpretations extends LowPriorityTotalInterpretation {

  implicit def trueInterpretation[E[_] <: Expression](implicit t: Truth[E[T]]): TotalInterpretation[E] = null
}

trait LowPriorityTotalInterpretation extends TruthImplicits {

  implicit def falseInterpretation[E[_] <: Expression](implicit t: Truth[E[F]]): TotalInterpretation[E] = null

}

object TotalInterpretations extends TotalInterpretations