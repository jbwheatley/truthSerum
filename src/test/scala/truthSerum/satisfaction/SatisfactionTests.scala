package truthSerum.satisfaction

import truthSerum.*

object SatisfactionTests:

  import SatisfactionImplicits.given

  def satisfiable1[E[_] <: Expression](using i: UnarySatisfaction[E]): Option[E[Any]] = Option.empty[E[Any]]
  def satisfiable2[E[_,_] <: Expression](using i: BinarySatisfaction[E]): Option[E[Any, Any]] = Option.empty[E[Any, Any]]
  def satisfiable3[E[_,_,_] <: Expression](using i: TertiarySatisfaction[E]): Option[E[Any, Any, Any]] = Option.empty[E[Any, Any, Any]]
  
  type X[A] = ![![![![A]]]]
  type Y[A] = A & A
  type Z[A] = ![A] | A

  satisfiable1[X]
  satisfiable1[Y]
  satisfiable1[Z]

  type W[A] = A & ![A]

//  satisfiable1[W] //does not compile
  
  type X2[A, B] = A -> (B -> A)
  type Y2[A, B] = ![A] & ![B]
  type Z2[A, B] = B <-> A

  satisfiable2[X2]
  satisfiable2[Y2]
  satisfiable2[Z2]

  type W2[A, B] = ![A -> (B -> A)]

//  satisfiable2[W2] //does not compile

  type X3[A, B, C] = A -> B -> (B -> C -> (A -> C))
  type Y3[A, B, C] = ![A] <-> B & ![C]
  type Z3[A, B, C] = ![A & ![A] & C & ![B] & B & ![C]]

  satisfiable3[X3]
  satisfiable3[Y3]
  satisfiable3[Z3]

  type W3[A, B, C] = ![A -> (B -> A)]
  type U[A, B, C] = A & ![A] & C & ![B] & B & ![C]

//  satisfiable3[W3] //does not compile
//  satisfiable3[U] //does not compile
