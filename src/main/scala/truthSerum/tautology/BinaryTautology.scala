package truthSerum
package tautology

trait BinaryTautology[E[_,_]]

object BinaryTautology:
  given [E[_, _]](using UnaryTautology[[A] =>> E[True, A]], UnaryTautology[[A] =>> E[False, A]]): BinaryTautology[E] = null
