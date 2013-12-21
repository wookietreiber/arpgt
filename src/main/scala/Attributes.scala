package rpg

/** Provides attributes. Attributes are lazy, i.e. unset attributes will have a default value
  * specified by `defaultAttributeValues`.
  *
  * @tparam A the used attribute type
  *
  * @see [[rpg.Attribute]]
  */
trait Attributes[A <: Attribute] {

  /** Returns the value of the given attribute. */
  final def apply(a: A): Int = attrmap(a)

  /** Modifies the value of the given attribute. */
  final def mod(a: A)(mod: Mod[Int]) {
    attrmap += (a → mod(attrmap(a)))
  }

  /** Returns the attribute to value map. */
  final def attributes: Map[A,Int] = attrmap

  /** Returns the default attribute to value function. If you want to override it with a `val` make
    * it a `lazy val`!
    */
  def defaultAttributeValues: A ⇒ Int

  /** Returns the attribute to value map. */
  private var attrmap: Map[A,Int] = Map[A,Int]() withDefault defaultAttributeValues

}
