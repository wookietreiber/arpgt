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

/** Base trait of skills. */
trait Skill[A <: Attribute] extends Checkable[Int] with ((Int,Int,Mod[Int],List[A]) => Result) {
  /** Returns the name of this skill. */
  def name: String

  /** Returns the attributes usually associated with this skill.
    *
    * Usually skills, like running, are associated with certain attributes, like
    * stamina for running. Sometimes one needs other attributes, like
    * estimating, how hard it is to success under given circumstances, so
    * associated attributes should never be fix.
    */
  def defaultAttributes: List[A]

  /** Returns the result of applying this function to `level`.
    *
    * @param lvl the skill-level
    * @param difficulty opposing level
    * @param mod modifier for `level`
    * @param attributes attributes to use for this check
    */
  override final def apply(lvl: Int, difficulty: Int, mod: Mod[Int] = identity, attributes: List[A] = defaultAttributes): Result =
    check(lvl, difficulty, mod, attributes)

  /** Returns the result depending on the rules defined by this method, using `defaultAttributes`. */
  override protected final def check(lvl: Int, difficulty: Int, mod: Mod[Int]): Result =
    check(lvl, difficulty, mod, defaultAttributes)

  /** Returns the result depending on the rules defined by this method. */
  protected def check(lvl: Int, difficulty: Int, mod: Mod[Int], attributes: List[A]): Result
}
