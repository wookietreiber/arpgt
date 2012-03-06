/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011-2012  Christian Krause                              *
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

object Die {
  private[rpg] lazy val sidesErrorMessage = "Too few sides."
}

/** An x-sided die.
  *
  * Most common dice are already defined as vals in `package object rpg`.
  *
  * @param sides sides of the die, has to be greater than or equal to 2
  */
case class Die(sides: Int) extends (() => Int) {

  require(sides >= 2, Die.sidesErrorMessage)

  /** Returns the result of rolling this die. */
  override def apply() = Random.nextInt(sides) + 1

  /** Returns the results of rolling this die `n` times. */
  def roll(implicit n: Int = 1) = List.fill(n)(apply())

  /** Returns `"d" + sides`. */
  override val toString = "d" + sides

}
