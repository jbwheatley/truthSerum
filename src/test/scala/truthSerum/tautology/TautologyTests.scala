package truthSerum
package tautology

object TautologyTests:

  import TruthImplicits.given

  def tautology1[E[_]](using t: UnaryTautology[E]): Option[E[Any]] = Option.empty[E[Any]]
  def tautology2[E[_,_]](using i: BinaryTautology[E]): Option[E[Any, Any]] = Option.empty[E[Any, Any]]
  def tautology3[E[_,_,_]](using i: TertiaryTautology[E]): Option[E[Any, Any, Any]] = Option.empty[E[Any, Any, Any]]


  type X[A] = A | ![A] // Law of the excluded middle

  tautology1[X]

  type Y[A] = A | A
//  tautology1[Y] //does not compile


  type X2[A, B] = (A & (A -> B)) -> B // Law of modus ponens
  type XX[A, B] = (![B] & (A -> B)) -> ![A] //Law of modus tollens
  type Y2[A, B] = (A -> B) <-> (![B] -> ![A]) //Law of contraposition
  type Z2[A, B] = ((![A] -> B) & (![A] -> ![B])) -> A //Reductio ad absurdum

  tautology2[X2]
  tautology2[XX]
  tautology2[Y2]
  tautology2[Z2]

  type W2[A, B] = A -> B -> A
//  tautology2[W2] //does not compile

  type X3[A, B, C] = (A -> B) -> ((B -> C) -> (A -> C)) // Principle of syllogism
  type Y3[A, B, C] = (A <-> B) -> ((A & C) <-> (B & C)) // Substitution of equivalents

  tautology3[X3]
  tautology3[Y3]

  type W3[A, B, C] = A | B | C
//  tautology3[W3] //does not compile