package rpg

import Check._

object Test {

  class HitPoints(val maxhp: Int) extends rpg.HitPoints

  // -----------------------------------------------------------------------
  // attributes
  // -----------------------------------------------------------------------

  sealed abstract class Attribute extends rpg.Attribute

  case object Stamina extends Attribute

  class Attributes(default: Int) extends rpg.Attributes[Attribute,Check[Attribute]] {
    override lazy val defaultAttributeValues = (a: Attribute) ⇒ default
    def check(a: Attribute) = new Check(Checkee("", a, attributes(a)))
  }

  // -----------------------------------------------------------------------
  // skills
  // -----------------------------------------------------------------------

  sealed abstract class Skill(val defaultAttributes: List[Attribute])
    extends rpg.Skill[Attribute]

  case object Running extends Skill(List(Stamina))

  class Skills(default: Int) extends rpg.Skills[Attribute,Skill,Check[Skill]] {
    override lazy val defaultSkillValues = (s: Skill) ⇒ default

    override def check(s: Skill, using: List[Attribute]) =
      new Check(Checkee("", s, skills(s)))
  }

  // -----------------------------------------------------------------------
  // checking
  // -----------------------------------------------------------------------

  case class Check[A](
      checkee: Checkee[A],
      opponent: Option[Checkee[A]] = None)
    extends rpg.Check[A,Check[A]] {

    def copy(checkee: Checkee[A] = checkee, opponent: Option[Checkee[A]] = opponent) =
      Check(checkee, opponent)

    override def result = Succeeded()
  }

  // -----------------------------------------------------------------------
  // character
  // -----------------------------------------------------------------------

  class Character(val name: String)
    extends rpg.Character[Attribute,Skill,Check[Attribute],Check[Skill]] {

    override val attributes = new Attributes(2)
    override val hitpoints = new HitPoints(42)
    override val skills = new Skills(-1)
  }
}
