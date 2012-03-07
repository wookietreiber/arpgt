package rpg

import HitPoints._

import org.specs2._

class HitPointsSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "A 'HitPoints' implementation should"                                       ^
    "get hurt and healed correctly"         ! e1                              ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1 = {
    val maxhp = 42
    val dmg   = Damage(10)
    val life  = Life(4)

    val hitPoints = new Test.HitPoints(42)
    hitPoints hurt dmg
    hitPoints heal life
    hitPoints.hp must_== (maxhp - dmg.amount + life.amount)
  }
}
