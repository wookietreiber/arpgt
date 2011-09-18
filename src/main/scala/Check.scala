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

  /** The subject of a [[rpg.Check]].
    *
    * @param description describes the subject, e.g. the name of a character
    * @param checked which aspect is checked, e.g. an attribute
    * @param value the value of what is checked
    *
    * @tparam A the type of the checked aspect
    */
  case class Checkee[A](description: String, checked: A, value: Int)

  /** Simple reacting party.
    *
    * @param difficulty how hard this reacting party is to defeat
    * @param description short description of this reacting party
    *
    * @tparam A value type
    */
  case class Level[A](difficulty: A, description: String = "anonymous")

  /** Describes circumstances used to modify the acting party.
    *
    * @param mod the modifier
    * @param description the description of the circumstances
    */
  case class Circumstances(mod: Mod[Int], description: String = "") {
    /** Returns `description`. */
    override def toString = description
  }
}

import Check._

abstract class Check[A,C <: Check[A,C]] {
  /** Returns the subject of this check. */
  val checkee: Checkee[A]

  /** Optionally returns the opponent of the checkee. */
  val opponent: Option[Checkee[A]]

  def copy(checkee: Checkee[A] = checkee, opponent: Option[Checkee[A]] = opponent): C

  def vs(lvl: Int): C =
    vs(Checkee("anonymous", checkee.checked, lvl))

  def vs(lvl: Level[Int]): C =
    vs(Checkee(lvl.description, checkee.checked, lvl.difficulty))

  def vs(reactor: Checkee[A]): C =
    copy(opponent = Some(reactor))

  def under(mod: Mod[Int]): C = copy(checkee.copy(
    description = checkee.description + "(before:" + checkee.value + ")",
    value = mod(checkee.value)))

  def under(c: Circumstances): C = copy(checkee.copy(
    description = checkee.description + "(" + c.description + ")",
    value = c.mod(checkee.value)))

  def result: Result

  override def toString = checkee + " vs " + opponent + " --> " + result
}
