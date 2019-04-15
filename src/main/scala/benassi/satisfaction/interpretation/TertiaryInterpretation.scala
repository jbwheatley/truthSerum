package benassi
package satisfaction
package interpretation

trait TertiaryInterpretation[E[_,_,_]]

object TertiaryInterpretation extends LowPriorityTertiaryInterpretation {

  implicit def trueInterpretation[E[_, _, _] <: Expression]
  (implicit i: BinaryInterpretation[({type λ[α, β] = E[T, α, β]})#λ]
  ): TertiaryInterpretation[E] = null
}

trait LowPriorityTertiaryInterpretation {

  implicit def falseInterpretation[E[_, _, _] <: Expression]
  (implicit i: BinaryInterpretation[({type λ[α, β] = E[F, α, β]})#λ]
  ): TertiaryInterpretation[E] = null

}
