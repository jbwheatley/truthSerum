package benassi
package tautology

trait BinaryTautology[E[_,_]]

object BinaryTautology {
  implicit def tautology[E[_, _]](implicit t: UnaryTautology[E[T, ?]], f: UnaryTautology[E[F, ?]]): BinaryTautology[E] = null
}
