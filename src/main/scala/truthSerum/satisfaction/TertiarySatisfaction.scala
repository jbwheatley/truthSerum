package truthSerum
package satisfaction

trait TertiarySatisfaction[E[_,_,_]]

trait TertiarySatifactions extends LowPriorityTertiarySatifactions:
  given true3Interpretation[E[_, _, _]](using BinarySatisfaction[[A, B] =>> E[True, A, B]]): TertiarySatisfaction[E] = null

trait LowPriorityTertiarySatifactions:
  given false3Interpretation[E[_, _, _]](using BinarySatisfaction[[A, B] =>> E[False, A, B]]): TertiarySatisfaction[E] = null

object TertiarySatifactions extends TertiarySatifactions
