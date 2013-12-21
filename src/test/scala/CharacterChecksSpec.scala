package rpg

import org.specs2._

class CharacterChecksSpec extends Specification { def is = s2"""

  Character Check Specification

  simple checks should work in
    simple attribute checks                                                               $e1
    simple skill checks                                                                   $e2
                                                                                                 """
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  import Test._

  def e1 = {
    val bob = new Character("Bob")
    val res = bob check Stamina
    res must beAnInstanceOf[Result]
  }

  def e2 = {
    val bob = new Character("Bob")
    val res = bob check Running
    res must beAnInstanceOf[Result]
  }
/*
  def ey = {
    val bob = new Character("Bob")
    val res = bob check Running vs 2 under { _ - 3 }
    res must beAnInstanceOf[?]
  }
*//*
  def ez = {
    val bob = new Character("Bob")
    val res = bob check Running vs Level(2, "jogger") under Circumstances("limps") { _ - 3 }
    res must beAnInstanceOf[?]
  }
*/
}
