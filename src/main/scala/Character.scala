/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  Copyright © 2011-2012 Christian Krause                                                       *
 *                                                                                               *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                                            *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                               *
 *  This file is part of 'arpgt'.                                                                *
 *                                                                                               *
 *  This project is free software: you can redistribute it and/or modify it under the terms      *
 *  of the GNU General Public License as published by the Free Software Foundation, either       *
 *  version 3 of the License, or any later version.                                              *
 *                                                                                               *
 *  This project is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;    *
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.    *
 *  See the GNU General Public License for more details.                                         *
 *                                                                                               *
 *  You should have received a copy of the GNU General Public License along with this project.   *
 *  If not, see <http://www.gnu.org/licenses/>.                                                  *
 *                                                                                               *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package rpg

/** Base class for characters.
  *
  * @tparam A the used attribute type (default attributes of skills)
  * @tparam S the used skill type
  * @tparam C the character type itself
  */
abstract class Character[A <: Attribute,S <: Skill[A],C <: Character[A,S,C]] {

  self: C with Attributes[A] with Skills[A,S] ⇒

  /** Returns this characters name. */
  def name: String

  /** Returns `name`. */
  override def toString: String = name

  /** Returns the result of a check of a certain aspect of the character.
    *
    * @tparam X the type aspect that is checked
    *
    * @param x the aspect of the character to check
    * @param c the instance that performs the check
    */
  def check[X](x: X)(implicit c: CharacterCheck[X,C]): Result =
    c.check(this, x)

}
