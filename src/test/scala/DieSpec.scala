package rpg

import org.specs2._

class DieSpec extends Specification { def is =

  // -----------------------------------------------------------------------
  // fragments
  // -----------------------------------------------------------------------

  "'Die' creation should"                                                     ^
    "work for 2 or more 'sides'"            ! e1(2,6,20)                      ^
    "fail otherwise"                        ! e2(1,0,-42)                     ^
                                                                             p^
  """'Die.toString' must match '("d"+s)'""" ! e3(6,20,100)                    ^
                                                                             p^
  "a 'Die' must be rollable"                ! e4                            ^t^
    "return results between 1 and 'sides'"  ! e5                              ^
                                                                            end
  // -----------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------

  def e1(ss: Int*) = foreach(ss) { s =>
    Die(s) must not (throwAn[IllegalArgumentException])
  }

  def e2(ss: Int*) = foreach(ss) { s =>
    Die(s) must throwAn[IllegalArgumentException]
  }

  def e3(ss: Int*) = foreach(ss) { s =>
    ("d"+s).r.unapplySeq(Die(s).toString) must beSome
  }

  def e4 = Die(6)() must beBetween(1,6)

  def e5 = foreach(Die(6) roll 1000) { x =>
    x must beBetween(1,1000)
  }

  // -----------------------------------------------------------------------
  // util
  // -----------------------------------------------------------------------

  def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

}
