package rpg

import language.implicitConversions

/** Contains hit-point-related messages and implicit conversions. */
object HitPoints {

  // -----------------------------------------------------------------------------------------------
  // messages
  // -----------------------------------------------------------------------------------------------

  /** Message wrapping hit-points. */
  case class HP(value: Int)

  /** Message for hurting.
    *
    * @param amount has to be positive
    */
  case class Damage(amount: Int) { require(amount > 0) }

  /** Message for healing.
    *
    * @param amount has to be positive
    */
  case class Life(amount: Int) { require(amount > 0) }

  // -----------------------------------------------------------------------------------------------
  // implicit conversions
  // -----------------------------------------------------------------------------------------------

  /** Converts an `Int` to [[rpg.HitPoints.Damage]]. */
  implicit def int2Damage(amount: Int): Damage = Damage(amount)

  /** Converts an `Int` to [[rpg.HitPoints.Life]]. */
  implicit def int2Life(amount: Int): Life = Life(amount)

}

import HitPoints._

/** Provides hit-points.
  *
  * @todo low hit-point modificator
  * @todo damage - armor
  * @todo not heal over maxhp (unless explicitly specified)
  */
trait HitPoints {

  // -----------------------------------------------------------------------------------------------
  // mutable state primitive access and mutation
  // -----------------------------------------------------------------------------------------------

  /** Returns current hit-points, initialised with `maxhp`. */
  private var curhp: Int = maxhp

  /** Returns current hit-points. */
  def hp: Int = curhp

  /** Current hit-points mutator. */
  def hp_=(hp: Int) {
    curhp = hp
  }

  // -----------------------------------------------------------------------------------------------
  // mutable state convenience access and mutation
  // -----------------------------------------------------------------------------------------------

  /** Returns current hit-points wrapped in [[rpg.HitPoints.HP]]. */
  def apply(): HP = HP(hp)

  /** Decreases hit-points by given amount of damage and returns the result. */
  def hurt(dmg: Damage) = {
    hp -= dmg.amount
    hp
  }

  /** Increases hit-points by given amount of life and returns the result. */
  def heal(life: Life) = {
    hp += life.amount
    hp
  }

  // -----------------------------------------------------------------------------------------------
  // abstract definitions
  // -----------------------------------------------------------------------------------------------

  /** Returns maximum hit-points. */
  def maxhp: Int

}
