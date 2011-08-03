/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                       *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *  This file is part of 'echo-tools'.                                      *
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

/** Contains hit-point-related messages. */
object HitPoints {
  /** Message for hurting.
    *
    * @param amount must be positive
    */
  case class Damage(amount: Int) { require(amount > 0) }

  /** Message for healing.
    *
    * @param amount must be positive
    */
  case class Life(amount: Int) { require(amount > 0) }
}

import HitPoints._

/** Provides hit-points. */
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

  /** Returns current hit-points. */
  def apply() = hp

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
