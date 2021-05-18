package truthSerum
package tautology

trait TertiaryTautology[E[_,_,_]]

object TertiaryTautology:
  given [E[_,_,_]](using BinaryTautology[[A, B] =>> E[True,A,B]], BinaryTautology[[A, B] =>> E[False,A,B]]): TertiaryTautology[E] = null
