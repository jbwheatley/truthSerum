package truthSerum
package satisfaction

trait TertiarySatisfaction[E[_,_,_]]

trait TertiarySatifactions extends LowPriorityTertiarySatifactions {

  implicit def true3Interpretation[E[_, _, _]]
  (implicit i: BinarySatisfaction[E[T, ?, ?]]
  ): TertiarySatisfaction[E] = null
}

trait LowPriorityTertiarySatifactions {

  implicit def false3Interpretation[E[_, _, _]]
  (implicit i: BinarySatisfaction[E[F, ?, ?]]
  ): TertiarySatisfaction[E] = null

}

object TertiarySatifactions extends TertiarySatifactions
