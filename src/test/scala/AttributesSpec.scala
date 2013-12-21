package rpg

import org.specs2._

class AttributesSpec extends Specification { def is = s2"""

  Attributes Specification

  an 'Attributes' implementation should
    return the default for unset attributes                                               $e1
    return non-default values for modified attributes                                     $e2
                                                                                                 """
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  val attr    = Test.Stamina
  val default = 8

  def e1 = {
    val impl = new Test.Attributes {}

    impl(attr) must_== default
  }

  def e2 = {
    val impl = new Test.Attributes {}

    impl.mod(attr) { _ + 4 }
    impl(attr) !== default
  }

}
