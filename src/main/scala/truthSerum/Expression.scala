package truthSerum

sealed trait Expression

sealed trait Operator extends Expression

sealed trait TruthValue extends Expression

class True extends TruthValue
class False extends TruthValue

class &[L1, L2] extends Operator
class ![L] extends Operator
