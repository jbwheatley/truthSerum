package truthSerum

object TruthTests:

  import TruthImplicits.given
  
  def evaluate[E <: Expression](using t: Truth[E]): Option[E] = Option.empty[E]

  evaluate[T]
  evaluate[T & T]
  evaluate[![F]]
  evaluate[T | F]
  evaluate[F | T]
  evaluate[F -> F]
  evaluate[T -> T]
  evaluate[F -> T]
  evaluate[T <-> T]
  evaluate[F <-> F]

  evaluate[![T] | (T & (T -> (F | (T & T <-> ![F & T]))))]

  //Don't compile
//  evaluate[F]
//  evaluate[F & T]
//  evaluate[T & F]
//  evaluate[F & F]
//  evaluate[![T]]
