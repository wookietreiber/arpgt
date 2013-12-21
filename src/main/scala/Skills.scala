package rpg

/** Provides skills. Skills are lazy, i.e. unset skills will have a default value specified by
  * `defaultSkillValues`.
  *
  * @tparam A the used attribute type (default attributes of skills)
  * @tparam S the used skill type
  *
  * @see [[rpg.Skill]]
  *
  * @todo subtraits FixedSkills and OpenSkills(defines splitSkill for turning e.g. perception(2)
  * into hearing/seeing/tasting/feeling(2) and smelling(3))
  */
trait Skills[A <: Attribute,S <: Skill[A]] {

  /** Returns the skill to value map. */
  private var skillmap: Map[S,Int] = Map[S,Int]() withDefault defaultSkillValues

  /** Returns the value of the given skill. */
  final def apply(s: S): Int = skillmap(s)

  /** Modifies the value of the given skill. */
  final def mod(s: S)(mod: Mod[Int]) {
    skillmap += (s → mod(skillmap(s)))
  }

  /** Returns the skill to value map. */
  final def skills: Map[S,Int] = skillmap

  /** Returns the default skill to value function. If you want to override it
    * with a `val` make it a `lazy val`!
    */
  def defaultSkillValues: S ⇒ Int

}
