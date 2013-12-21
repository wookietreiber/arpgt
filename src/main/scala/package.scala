/** Contains an abstraction of the role-playing game (RPG) domain and provides a
  * domain-specific language (DSL) for convenient usage.
  *
  * The abstraction is designed to make it fairly easy to implement the rules of
  * a RPG, i.e. how an [[rpg.Attribute]] or [[rpg.Skill]] is checked.
  */
package object rpg {

  // ----------------------------------------------------------------------
  // function aliases
  // ----------------------------------------------------------------------

  /** Modifier function. */
  type Mod[A] = A ⇒ A

  // ----------------------------------------------------------------------
  // common dice
  // ----------------------------------------------------------------------

  /** Returns a three-sided die. */
  lazy val d3: Die = Die(3)

  /** Returns a four-sided die. */
  lazy val d4: Die = Die(4)

  /** Returns a six-sided die. */
  lazy val d6: Die = Die(6)

  /** Returns an eight-sided die. */
  lazy val d8: Die = Die(8)

  /** Returns a ten-sided die. */
  lazy val d10: Die = Die(10)

  /** Returns a twelve-sided die. */
  lazy val d12: Die = Die(12)

  /** Returns a twenty-sided die. */
  lazy val d20: Die = Die(20)

  /** Returns a hundred-sided die. */
  lazy val d100: Die = Die(100)

}
