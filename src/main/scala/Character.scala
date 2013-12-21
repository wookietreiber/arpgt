package rpg

/** Base class for characters.
  *
  * @tparam A the used attribute type (default attributes of skills)
  * @tparam S the used skill type
  * @tparam C the character type itself
  */
abstract class Character[A <: Attribute,S <: Skill[A],C <: Character[A,S,C]] {

  self: C with Attributes[A] with Skills[A,S] ⇒

  /** Returns this characters name. */
  def name: String

  /** Returns `name`. */
  override def toString: String = name

  /** Returns the result of a check of a certain aspect of the character.
    *
    * @tparam X the type aspect that is checked
    *
    * @param x the aspect of the character to check
    * @param C the instance that performs the check
    */
  def check[X](x: X)(implicit C: CharacterCheck[X,C]): Result =
    C.check(this, x)

  /** Returns a value of a certain aspect of the character.
    *
    * @tparam X the type aspect
    *
    * @param x the aspect of the character to get
    * @param G the instance that performs the get
    */
  def get[X](x: X)(implicit G: CharacterGetter[X,C]): Option[Int] =
    G.get(this, x)

}
