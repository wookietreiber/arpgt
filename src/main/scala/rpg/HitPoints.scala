/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                       *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *  This file is part of 'arpgt'.                                           *
 *                                                                          *
 *  This project is free software: you can redistribute it and/or modify    *
 *  it under the terms of the GNU General Public License as published by    *
 *  the Free Software Foundation, either version 3 of the License, or       *
 *  any later version.                                                      *
 *                                                                          *
 *  This project is distributed in the hope that it will be useful,         *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 *  GNU General Public License for more details.                            *
 *                                                                          *
 *  You should have received a copy of the GNU General Public License       *
 *  along with this project. If not, see <http://www.gnu.org/licenses/>.    *
 *                                                                          *
 ****************************************************************************/


package rpg

/** Contains hit-point-related messages and implicit conversions. */
object HitPoints {
  /** Message wrapping hit-points. */
  case class HP(value: Int) extends (() => Int) {
    /** Returns `value`. */
    override def apply() = value
  }

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

  /** Converts an `Int` to [[rpg.HitPoints.Damage]]. */
  implicit def int2Damage(amount: Int) = Damage(amount)

  /** Converts an `Int` to [[rpg.HitPoints.Life]]. */
  implicit def int2Life(amount: Int) = Life(amount)
}

import HitPoints._

/** Provides hit-points.
  *
  * @todo low hit-point modificator
  * @todo damage - armor
  */
trait HitPoints {

  // -------------------------------------------------------------------
  // mutable state primitive access and mutation
  // -------------------------------------------------------------------

  /** Returns current hit-points, initialised with `maxhp`. */
  private var curhp = maxhp

  /** Returns current hit-points. */
  def hp = curhp

  /** Current hit-points mutator. */
  def hp_=(hp: Int) {
    curhp = hp
  }

  // -------------------------------------------------------------------
  // mutable state convenience access and mutation
  // -------------------------------------------------------------------

  /** Returns current hit-points wrapped in [[rpg.HitPoints.HP]]. */
  def apply() = HP(hp)

  /** Decreases hit-points by given amount of damage and returns the result. */
  def hurt(implicit dmg: Damage) = {
    hp -= dmg.amount
    hp
  }

  /** Increases hit-points by given amount of life and returns the result. */
  def heal(implicit life: Life) = {
    hp += life.amount
    hp
  }

  // -------------------------------------------------------------------
  // abstract definitions
  // -------------------------------------------------------------------

  /** Returns maximum hit-points. */
  def maxhp: Int
}
