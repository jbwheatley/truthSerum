package truthSerum
package tautology

trait TertiaryTautology[E[_,_,_]]

object TertiaryTautology {
  implicit def tautology[E[_,_,_]](implicit t: BinaryTautology[E[T,?,?]], f: BinaryTautology[E[F,?,?]]): TertiaryTautology[E] = null
}


