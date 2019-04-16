package benassi
package tautology

import org.scalatest.{FlatSpec, Matchers}

class TautologyTests extends FlatSpec with Matchers {

  import TruthImplicits._

  def tautology1[E[_]](implicit t: UnaryTautology[E]): Option[E[Any]] = Option.empty[E[Any]]
  def tautology2[E[_,_]](implicit i: BinaryTautology[E]): Option[E[Any, Any]] = Option.empty[E[Any, Any]]
  def tautology3[E[_,_,_]](implicit i: TertiaryTautology[E]): Option[E[Any, Any, Any]] = Option.empty[E[Any, Any, Any]]

  "tautology1" should "compile only if the expression is tautological" in {

    type X[A] = A | ~[A] // Law of the excluded middle

    tautology1[X]

    type Y[A] = A | A
    assertDoesNotCompile("tautology1[Y]")
  }

  "tautology2" should "compile only if the expression is tautological" in {

    type X[A, B] = (A & (A -> B)) -> B // Law of modus ponens
    type XX[A, B] = (~[B] & (A -> B)) -> ~[A] //Law of modus tollens
    type Y[A, B] = (A -> B) <-> (~[B] -> ~[A]) //Law of contraposition
    type Z[A, B] = ((~[A] -> B) & (~[A] -> ~[B])) -> A //Reductio ad absurdum

    tautology2[X]
    tautology2[XX]
    tautology2[Y]
    tautology2[Z]

    type W[A, B] = A -> B -> A
    assertDoesNotCompile("tautology2[W]")
  }

  "tautology3" should "compile only if the expression is tautological" in {

    type X[A, B, C] = (A -> B) -> ((B -> C) -> (A -> C)) // Principle of syllogism
    type Y[A, B, C] = (A <-> B) -> ((A & C) <-> (B & C)) // Substitution of equivalents

    tautology3[X]
    tautology3[Y]

    type W[A, B, C] = A | B | C
    assertDoesNotCompile("tautology2[W]")
  }


}
