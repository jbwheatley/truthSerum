package benassi
package satisfaction

sealed trait Expression

trait Operator extends Expression

trait Literal extends Expression

class True extends Literal
class False extends Literal

class And[L1, L2] extends Operator
class Not[L] extends Operator
