package rpg

import org.specs2.mutable._
import Check._

class CharacterChecksSpec extends Specification {
  "DSL check syntax" should {
    "work" in {
      val bob = new Test.Character("Bob")
      (
        bob check Test.Running vs 2 under { _ - 3 }
      ) must beAnInstanceOf[Check[Test.Skill,Test.Check[Test.Skill]]]
    }
  }

  "DSL check syntax" should {
    "work" in {
      val bob = new Test.Character("Bob")
      (
        // TODO no function type at circumstances
        bob check Test.Running vs Level(2, "jogger") under Circumstances(_ - 3, "limps")
      ) must beAnInstanceOf[Check[Test.Skill,Test.Check[Test.Skill]]]
    }
  }
}
