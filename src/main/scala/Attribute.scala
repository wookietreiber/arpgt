package rpg

/** Base class of attributes. Almost all RPG systems use a very limited set of attributes, so it is
  * useful to implement them using a sealed class hierarchy and case objects:
  *
  * {{{
  * sealed abstract class MyAttribute extends Attribute
  *
  * case object Strength     extends MyAttribute
  * case object Charisma     extends MyAttribute
  * case object Intelligence extends MyAttribute
  * }}}
  *
  * This has certain advantages:
  *
  *  - own super-type, which is useful for abstract and parameterized types
  *  - sealed hierarchy and case objects come in handy for pattern matching
  *  - `toString` will nicely return the name of the case object
  *
  * Attributes should never hold their actual value, because they are usually saved in an
  * attribute-value map.
  *
  * @see [[rpg.Attributes]] for how attributes are usually saved
  */
abstract class Attribute
