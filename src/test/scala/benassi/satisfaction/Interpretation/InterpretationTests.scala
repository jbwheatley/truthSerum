package benassi
package satisfaction
package Interpretation

import benassi.satisfaction.interpretation.{BinaryInterpretation, TertiaryInterpretation, TotalInterpretation}
import org.scalatest.{FlatSpec, Matchers}

class InterpretationSpec extends FlatSpec with Matchers {

  import benassi.satisfaction.interpretation.TertiaryInterpretations._

  def satisfiable1[E[_] <: Expression](implicit i: TotalInterpretation[E]): Option[E[Any]] = Option.empty[E[Any]]
  def satisfiable2[E[_,_] <: Expression](implicit i: BinaryInterpretation[E]): Option[E[Any, Any]] = Option.empty[E[Any, Any]]
  def satisfiable3[E[_,_,_] <: Expression](implicit i: TertiaryInterpretation[E]): Option[E[Any, Any, Any]] = Option.empty[E[Any, Any, Any]]

  "satisfiable1" should "compile if the expression has a satisfying interpretation" in {

    type X[A] = ~[~[~[~[A]]]]
    type Y[A] = A & A
    type Z[A] = ~[A] | A

    satisfiable1[X]
    satisfiable1[Y]
    satisfiable1[Z]

    type W[A] = A & ~[A]

    assertDoesNotCompile("satisfiable1[W]")
  }

  "satisfiable2" should "compile if the expression has a satisfying interpretation" in {

    type X[A, B] = A -> (B -> A)
    type Y[A, B] = ~[A] & ~[B]
    type Z[A, B] = B <-> A

    satisfiable2[X]
    satisfiable2[Y]
    satisfiable2[Z]

    type W[A, B] = ~[A -> (B -> A)]

    assertDoesNotCompile("satisfiable2[W]")
  }

  "satisfiable3" should "compile if the expression has a satisfying interpretation" in {

    type X[A, B, C] = A -> B -> (B -> C -> (A -> C))
    type Y[A, B, C] = ~[A] <-> B & ~[C]
    type Z[A, B, C] = ~[A & ~[A] & C & ~[B] & B & ~[C]]

    satisfiable3[X]
    satisfiable3[Y]
    satisfiable3[Z]

    type W[A, B, C] = ~[A -> (B -> A)]
    type U[A, B, C] = A & ~[A] & C & ~[B] & B & ~[C]

    assertDoesNotCompile("satisfiable3[W]")
    assertDoesNotCompile("satisfiable3[U]")

  }


}
