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

/** Contains implicit conversion from convenience methods to what is used by the
  * factory methods of [[rpg.Check]] instances.
  */
object Check {

  // -------------------------------------------------------------------
  // messages
  // -------------------------------------------------------------------

  case class Checker(checked: Any, checkedValue: Int, description: String) {
    override def toString = description + "(" + checked + "," + checkedValue + ")"
  }

  /** Simple reacting party.
    *
    * @param difficulty how hard this reacting party is to defeat
    * @param description short description of this reacting party
    *
    * @tparam A value type
    */
  case class Level[A](difficulty: A, description: String = "opponent") {
    /** Returns `"level " + difficulty + " " + description`. */
    override def toString = "level " + difficulty + " " + description
  }

  /** Describes circumstances used to modify the acting party.
    *
    * @param mod the modifier
    * @param description the description of the circumstances
    */
  case class Circumstances(mod: Mod[Int], description: String = "") {
    /** Returns `description`. */
    override def toString = description
  }

  val NoCircumstances = Circumstances(identity)

  // -------------------------------------------------------------------
  // implicit conversions
  // -------------------------------------------------------------------

  implicit def level2tuple[A](lvl: Level[A]) =
    (lvl.difficulty -> lvl.description)

  implicit def circumstances2tuple(c: Circumstances) =
    (c.mod -> c.description)
}

import Check._

abstract class Check {
  def vs(difficulty: Int): Check
  def vs(opponent: Level[Int]): Check = vs(opponent.difficulty)

  def under(f: Mod[Int]): Check
  def under(c: Circumstances): Check = under(c.mod)

  def result: Result

  override def toString = result.toString
}
