package rpg

import org.specs2.mutable._

class HitPointsSpec extends Specification {
  import HitPoints._

  implicit val maxhp = 42
  implicit val dmg   = Damage(10)
  val life = 4

  """a "HitPoints" implementation""" should {
    "get hurt and healed correctly" in {
      val impl = new Test.HitPoints(42)
      impl.hurt
      impl heal life
      impl.hp must_== (maxhp - dmg.amount + life)
    }
  }
}
