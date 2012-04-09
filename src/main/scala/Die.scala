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

/** A die that can be rolled.
  *
  * Common dice are defined in package object [[rpg]] so you can easily use them:
  *
  * {{{
  * scala> import rpg._
  * import rpg._
  *
  * scala> d6 roll 20
  * res0: List[Int] = List(1, 4, 2, 1, 4, 4, 3, 1, 6, 3, 4, 2, 1, 2, 5, 3, 6, 2, 6, 6)
  *
  * scala> d20 roll 3
  * res1: List[Int] = List(8, 11, 8)
  * }}}
  *
  * @param  sides  sides of this die
  */
case class Die(sides: Int) extends Random with (() => Int) {

  require(sides >= 2, Die.sidesErrorMessage)

  /** Returns the result of rolling this die. */
  override def apply(): Int = nextInt(sides) + 1

  /** Returns the results of rolling this die `n` times. */
  def roll(implicit n: Int = 1): List[Int] = List.fill(n)(apply())

}
