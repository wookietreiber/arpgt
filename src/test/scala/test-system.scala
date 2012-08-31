package rpg

import Result._

object Test {

  case class Attribute(name: String)
    extends rpg.Attribute

  case class Skill(name: String, defaultAttributes: Seq[Attribute])
    extends rpg.Skill[Attribute]

  trait Attributes extends rpg.Attributes[Attribute] {
    def defaultAttributeValues = { _ ⇒ 8 }
  }

  trait Skills extends rpg.Skills[Attribute,Skill] {
    def defaultSkillValues = { _ ⇒ 0 }
  }

  trait HitPoints extends rpg.HitPoints {
    def maxhp = 42
  }

  case class Character(name: String) extends rpg.Character[Attribute,Skill,Character]
    with Attributes with Skills with HitPoints

  val Stamina = Attribute("Stamina")
  val Running = Skill("Running", Seq(Stamina))

  implicit val AttributeCheck = new CharacterCheck[Attribute,Character] {
    def check(c: Character, a: Attribute) = Tie()
  }

  implicit val SkillCheck = new CharacterCheck[Skill,Character] {
    def check(c: Character, s: Skill) = Tie()
  }

}
