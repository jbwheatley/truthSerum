package benassi
package satisfaction
package interpretation

class TertiaryInterpretation[E[_,_,_] <: Expression]

trait TertiaryInterpretations extends LowPriorityTertiaryInterpretations {

  implicit def true3Interpretation[E[_, _, _] <: Expression]
  (implicit i: BinaryInterpretation[E[T, ?, ?]]
  ): TertiaryInterpretation[E] = null
}

trait LowPriorityTertiaryInterpretations extends BinaryInterpretations {

  implicit def false3Interpretation[E[_, _, _] <: Expression]
  (implicit i: BinaryInterpretation[E[F, ?, ?]]
  ): TertiaryInterpretation[E] = null

}

object TertiaryInterpretations extends TertiaryInterpretations
