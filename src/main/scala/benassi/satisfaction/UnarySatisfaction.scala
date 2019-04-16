package benassi
package satisfaction

trait UnarySatisfaction[E[_]]

trait UnarySatifactions extends LowPriorityUnaryInterpretation {

  implicit def trueInterpretation[E[_]](implicit t: Truth[E[T]]): UnarySatisfaction[E] = null
}

trait LowPriorityUnaryInterpretation {

  implicit def falseInterpretation[E[_]](implicit t: Truth[E[F]]): UnarySatisfaction[E] = null

}

object UnarySatifactions extends UnarySatifactions
