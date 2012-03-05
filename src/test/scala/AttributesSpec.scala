package rpg

import org.specs2.mutable._

class AttributesSpec extends Specification {
  val attr = Test.Stamina
  val default = 42

  """an "Attributes" implementation""" should {
    "return the default for unset attributes" in {
      val impl = new Test.Attributes(default)
      impl(attr) must_== default
    }

    "return non-default values for modified attributes" in {
      val impl = new Test.Attributes(default)
      impl.mod(attr, _ + 4)
      impl(attr) !== default
    }
  }
}
