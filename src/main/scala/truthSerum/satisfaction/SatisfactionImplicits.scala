package truthSerum
package satisfaction

trait SatisfactionImplicits
  extends TertiarySatifactions
  with BinarySatifactions
  with UnarySatifactions
  with TruthImplicits

object SatisfactionImplicits extends SatisfactionImplicits
