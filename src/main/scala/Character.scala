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

/** Base class of characters. A character is basically the composition of
  * [[rpg.Attributes]], [[rpg.Skills]] and [[rpg.HitPoints]].
  *
  * @tparam A the used attribute type (default attributes of skills)
  * @tparam S the used skill type
  *
  * @see [[rpg.Attributes]]
  * @see [[rpg.Skills]]
  * @see [[rpg.HitPoints]]
  */
abstract class Character[A <: Attribute,S <: Skill[A],CA <: Check[A,CA],CS <: Check[S,CS]] {
  /** Returns this characters name. */
  def name: String

  /** Returns `name`. */
  override def toString = name

  // -------------------------------------------------------------------
  // composition
  // -------------------------------------------------------------------

  /** Returns this characters attributes. */
  val attributes: Attributes[A,CA]

  /** Returns this characters hit-points. */
  val hitpoints: HitPoints

  /** Returns this characters skills. */
  val skills: Skills[A,S,CS]

  // -------------------------------------------------------------------
  // convenience (DSL)
  // -------------------------------------------------------------------

  /** Returns a check of the given attribute.
    *
    * This is a convenience method, i.e. it just forwards to
    * `attributes.check(a)`.
    */
  def check(a: A) = attributes.check(a)

  /** Returns a check of the given skill.
    *
    * This is a convenience method, i.e. it just forwards t, `skills.check(s)`.
    */
  def check(s: S, using: List[A]) = skills.check(s, using)

  /** Returns a check of the given skill.
    *
    * This is a convenience method, i.e. it just forwards to `skills.check(s)`.
    */
  def check(s: S) = skills.check(s)
}