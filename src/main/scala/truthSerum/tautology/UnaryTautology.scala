package truthSerum
package tautology

trait UnaryTautology[E[_]]

object UnaryTautology:
  given [E[_]](using Truth[E[True]], Truth[E[False]]): UnaryTautology[E] = null