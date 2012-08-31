package rpg

import org.specs2.mutable._

class SkillsSpec extends Specification {
  val skill = Test.Running
  val default = 0

  """a "Skills" implementation""" should {
    "return the default for unset skills" in {
      val impl = new Test.Skills {}
      impl(skill) must_== default
    }

    "return non-default values for set skills" in {
      val impl = new Test.Skills {}
      impl.mod(skill) { _ + 1 }
      impl(skill) !== default
    }
  }
}
