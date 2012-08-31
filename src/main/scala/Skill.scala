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

/** Base class of skills. Depending on how open the RPG system is you want to implement, you should
  * decide whether you want to implement all skills as a sealed class hierarchy with case objects or
  * just a few case classes which can be dynamically set up on a need to have basis.
  *
  * Usually skills, like athletics, are associated with certain attributes, e.g. athletics may
  * depend on stamina, strength and agility. These `defaultAttributes` are used when a skill is
  * checked. But sometimes, especially when it comes to estimating the outcome of an action,
  * checking a skill needs other attributes, like logic or intuition, so associated attributes
  * should neither be fix nor should they have no default.
  *
  * Skills should never hold their actual value, because they are usually saved in a skill-value
  * map.
  *
  * @tparam A used attribute type
  *
  * @see [[rpg.Skills]] for how skills are usually saved
  * @see [[rpg.Attribute]] for the attribute definition
  */
abstract class Skill[A <: Attribute] {

  /** Returns the attributes that are usually used to check this skill. */
  def defaultAttributes: Seq[A]

}
