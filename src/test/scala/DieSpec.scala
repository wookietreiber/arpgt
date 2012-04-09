package rpg

import org.specs2._

class DieSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "a 'Die' should have at least 2 'sides', i.e."                              ^
    "its creation should work with 2 or more 'sides'"   ! e1(2,6,20)          ^
    "and fail otherwise"                                ! e2(1,0,-42)         ^
                                                                             p^
  "a 'Die' should be rollable, i.e."                                          ^
    "be a function of '() => Int'"                      ! e3                  ^
    "when used return values from '1' to 'sides'"       ! e4                  ^
    "provide a 'roll n times' method"                   ! e5                  ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1(ss: Int*) = foreach(ss) { s =>
    Die(s) must not {
      throwAn[IllegalArgumentException]
    }
  }

  def e2(ss: Int*) = foreach(ss) { s =>
    Die(s) must throwAn[IllegalArgumentException] {
      Die.sidesErrorMessage
    }
  }

  def e3 = Die(6) must beAnInstanceOf[() => Int]

  def e4 = foreach(List.fill(1000)(Die(6).apply())) { x =>
    x must beBetween(1,6)
  }

  def e5 = foreach(Die(6) roll 1000) { x =>
    x must beBetween(1,6)
  }

  // -----------------------------------------------------------------------
  // util
  // -----------------------------------------------------------------------

  def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

}
