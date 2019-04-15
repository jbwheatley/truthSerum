package benassi
package satisfaction
package interpretation

trait BinaryInterpretation[E[_,_]]

object BinaryInterpretation extends LowPriorityBinaryInterpretation {

  implicit def trueInterpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[({type λ[α] = E[T, α]})#λ]
  ): BinaryInterpretation[E] = null
}

trait LowPriorityBinaryInterpretation {

  implicit def falseInterpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[({type λ[α] = E[F, α]})#λ]
  ): BinaryInterpretation[E] = null

}
