package truthSerum

trait Truth[E]

trait TruthImplicits extends FalsenessImplicits:
  given Truth[True] = null
  given andTruth[L1 <: Expression, L2 <: Expression](using Truth[L1], Truth[L2]): Truth[L1 & L2] = null
  given notTruth[L <: Expression](using Falseness[L]): Truth[![L]] = null

object TruthImplicits extends TruthImplicits

trait Falseness[E]

trait FalsenessImplicits:
  given Falseness[False] = null
  given notFalseness[L <: Expression](using Truth[L]): Falseness[![L]] = null
  given andLeftFalseness[L1 <: Expression, L2 <: Expression](using Falseness[L1]): Falseness[L1 & L2] = null
  given andRightFalseness[L1 <: Expression, L2 <: Expression](using Truth[L1], Falseness[L2]): Falseness[L1 & L2] = null
