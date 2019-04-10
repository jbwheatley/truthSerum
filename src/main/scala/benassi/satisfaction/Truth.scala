package benassi
package satisfaction

trait Truth[E]

object Truth extends FalsenessImplicits {

  implicit val theTruth: Truth[True] = null

  implicit def andTruth[L1 <: Expression, L2 <: Expression](implicit t1: Truth[L1], t2: Truth[L2]): Truth[L1 & L2] = null

  implicit def notTruth[L <: Expression](implicit f: Falseness[L]): Truth[~[L]] = null

}

trait Falseness[E]

trait FalsenessImplicits extends LowPriorityFalseness {

  implicit val theFalseness: Falseness[False] = null

  implicit def notFalseness[L <: Expression](implicit f: Truth[L]): Falseness[~[L]] = null

  implicit def andSameFalseness[L1 <: Expression, L2 <: Expression](implicit f1: Falseness[L1], f2: Falseness[L2]): Falseness[L1 & L2] = null
}

trait LowPriorityFalseness {

  implicit def andLeftFalseness[L1 <: Expression, L2 <: Expression](implicit f1: Falseness[L1]): Falseness[L1 & L2] = null
  implicit def andRightFalseness[L1 <: Expression, L2 <: Expression](implicit f1: Falseness[L2]): Falseness[L1 & L2] = null

}
