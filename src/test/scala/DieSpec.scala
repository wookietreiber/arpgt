package rpg

import org.scalacheck.Gen
import org.scalacheck.Prop
import org.specs2._

class DieSpec extends Specification with ScalaCheck { def is = s2"""

  Die Specification

  a 'Die' should have at least 2 'sides', i.e.
    its creation should work with 2 or more 'sides'                             $e1
    and fail otherwise                                                          $e2

  a 'Die' should be rollable, i.e.
    be a function of '() => Int'                                                $e3
    when used return values from '1' to 'sides'                                 $e4
    provide a 'roll n times' method                                             $e5
                                                                                                 """
  // -----------------------------------------------------------------------------------------------
  // tests
  // -----------------------------------------------------------------------------------------------

  def e1 = Prop.forAll(sidesGen) { (sides: Int) =>
    Die(sides) must not {
      throwAn[IllegalArgumentException]
    }
  }

  def e2 = Prop.forAll(sidesGenFail) { (sides: Int) =>
    Die(sides) must throwAn[IllegalArgumentException] {
      Die.sidesErrorMessage
    }
  }

  def e3 = Die(6) must beAnInstanceOf[() => Int]

  def e4 = Prop.forAll(sidesGen) { (sides: Int) =>
    val results = List.fill(100)(Die(sides).apply())

    foreach(results) {
      _ must beBetween(1,sides)
    }
  }

  def e5 = Prop.forAll(sidesGen) { (sides: Int) =>
    val results = Die(sides) roll 100

    (results must have size(100)) and
    (results must contain(beBetween(1,sides)).foreach)
  }

  // -----------------------------------------------------------------------------------------------
  // util
  // -----------------------------------------------------------------------------------------------

  def sidesGen = Gen.choose(2,100)
  def sidesGenFail = Gen.choose(-100,1)

  def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

}
