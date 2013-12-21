package rpg

import HitPoints._

import org.specs2._

class HitPointsSpec extends Specification { def is = s2"""

  Hit Points Specification

  a 'HitPoints' implementation should
    get hurt correctly                                                                    $e1
    get healed correctly                                                                  $e2
                                                                                                 """
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  def e1 = {
    val hp = new Test.HitPoints {}

    val maxhp = hp.maxhp
    val dmg   = 10

    hp hurt dmg
    hp.hp must_== (maxhp - dmg)
  }

  def e2 = {
    val hp = new Test.HitPoints {}

    val maxhp = hp.maxhp
    val dmg   = 10
    val life  = 4

    hp hurt dmg
    hp heal life
    hp.hp must_== (maxhp - dmg + life)
  }

}
