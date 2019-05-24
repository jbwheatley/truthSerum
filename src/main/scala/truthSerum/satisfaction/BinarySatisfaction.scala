package truthSerum
package satisfaction

trait BinarySatisfaction[E[_,_]]

trait BinarySatifactions extends LowPriorityBinarySatifactions {

  implicit def true2Interpretation[E[_, _]]
  (implicit i: UnarySatisfaction[E[T, ?]]
  ): BinarySatisfaction[E] = null
}

trait LowPriorityBinarySatifactions {

  implicit def false2Interpretation[E[_, _]]
  (implicit i: UnarySatisfaction[E[F, ?]]
  ): BinarySatisfaction[E] = null

}

object BinarySatifactions extends BinarySatifactions
