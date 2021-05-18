package truthSerum
package satisfaction

trait BinarySatisfaction[E[_,_]]

trait BinarySatifactions extends LowPriorityBinarySatifactions:
  given true2Interpretation[E[_, _]](using UnarySatisfaction[[A] =>> E[True, A]]): BinarySatisfaction[E] = null


trait LowPriorityBinarySatifactions:
  given false2Interpretation[E[_, _]](using UnarySatisfaction[[A] =>> E[False, A]]): BinarySatisfaction[E] = null

object BinarySatifactions extends BinarySatifactions
