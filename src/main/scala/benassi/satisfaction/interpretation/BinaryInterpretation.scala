package benassi
package satisfaction
package interpretation

class BinaryInterpretation[E[_,_] <: Expression]

trait BinaryInterpretations extends LowPriorityBinaryInterpretations {

  implicit def true2Interpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[E[T, ?]]
  ): BinaryInterpretation[E] = null
}

trait LowPriorityBinaryInterpretations extends TotalInterpretations {

  implicit def false2Interpretation[E[_, _] <: Expression]
  (implicit i: TotalInterpretation[E[F, ?]]
  ): BinaryInterpretation[E] = null

}

object BinaryInterpretations extends BinaryInterpretations
