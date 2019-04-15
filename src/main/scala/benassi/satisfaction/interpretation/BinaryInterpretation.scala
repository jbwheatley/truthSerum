package benassi
package satisfaction
package interpretation

class BinaryInterpretation[E[_,_] <: Expression]

trait BinaryInterpretations extends LowPriorityBinaryInterpretations {

  implicit def true2Interpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[({type λ[α] = E[T, α]})#λ]
  ): BinaryInterpretation[E] = null
}

trait LowPriorityBinaryInterpretations extends TotalInterpretations {

  implicit def false2Interpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[({type λ[α] = E[F, α]})#λ]
  ): BinaryInterpretation[E] = null

}

object BinaryInterpretations extends BinaryInterpretations
