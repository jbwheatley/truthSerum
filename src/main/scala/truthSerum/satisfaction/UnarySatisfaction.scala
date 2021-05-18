package truthSerum
package satisfaction

trait UnarySatisfaction[E[_]]

trait UnarySatifactions extends LowPriorityUnaryInterpretation:
  given trueInterpretation[E[_]](using Truth[E[True]]): UnarySatisfaction[E] = null

trait LowPriorityUnaryInterpretation:
  given falseInterpretation[E[_]](using Truth[E[False]]): UnarySatisfaction[E] = null

object UnarySatifactions extends UnarySatifactions
