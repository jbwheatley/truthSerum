package benassi
package satisfaction
package interpretation

trait TotalInterpretation[E[_]]

object TotalInterpretation extends LowPriorityTotalInterpretation {

  implicit def trueInterpretation[E[_] <: Expression](implicit t: Truth[E[T]]): TotalInterpretation[E] = null
}

trait LowPriorityTotalInterpretation {

  type Aux[E[_], Out0] = TotalInterpretation[E] { type Out = Out0 }

  implicit def falseInterpretation[E[_] <: Expression](implicit t: Truth[E[T]]): TotalInterpretation[E] = null

}
