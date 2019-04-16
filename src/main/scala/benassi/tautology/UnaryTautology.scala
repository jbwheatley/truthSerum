package benassi
package tautology

trait UnaryTautology[E[_]]

object UnaryTautology {
  implicit def tautology[E[_]](implicit t: Truth[E[T]], f: Truth[E[F]]): UnaryTautology[E] = null
}