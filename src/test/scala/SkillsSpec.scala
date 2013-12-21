package rpg

import org.specs2._

class SkillsSpec extends Specification { def is = s2"""

  Skills Specification

  an 'Skills' implementation should
    return the default for unset skills                                                   $e1
    return non-default values for modified skills                                         $e2
                                                                                                 """
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  val skill   = Test.Running
  val default = 0

  def e1 = {
    val impl = new Test.Skills {}

    impl(skill) must_== default
  }

  def e2 = {
    val impl = new Test.Skills {}

    impl.mod(skill) { _ + 1 }
    impl(skill) !== default
  }

}
