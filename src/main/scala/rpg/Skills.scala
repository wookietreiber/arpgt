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

/** Provides skills. Skills are lazy, i.e. unset skills will have a
  * default value specified by `defaultSkillValues`.
  *
  * @tparam A the used attribute type (default attributes of skills)
  * @tparam S the used skill type
  *
  * @see [[rpg.Skill]]
  *
  * @todo subtraits FixedSkills and OpenSkills(defines splitSkill for turning
  * e.g. perception(2) into hearing/seeing/tasting/feeling(2) and smelling(3))
  */
trait Skills[A <: Attribute,S <: Skill[A]] {
  /** Returns the value of the given skill. */
  final def apply(s: S) = skillmap(s)

  /** Modifies the value of the given skill. */
  final def mod(s: S, mod: Mod[Int] = _ + 1) {
    skillmap += (s -> mod(skillmap(s)))
  }

  /** Returns the skill to value map. */
  final def skills = skillmap

  /** Returns the default skill to value function. If you want to override it
    * with a `val` make it a `lazy val`!
    */
  def defaultSkillValues: S => Int

  /** Returns the skill to value map. */
  private var skillmap = Map[S,Int]() withDefault defaultSkillValues
}
