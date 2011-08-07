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

class AttributeResult(
    val attribute: Attribute,
    val level: Int,
    val difficulty: Option[Int] = None,
    val mod: Option[Mod[Int]] = None)
  extends Result {

  def vs(difficulty: Int): AttributeResult =
    new AttributeResult(attribute, level, Some(difficulty))

  def under(f: Mod[Int]): AttributeResult =
    new AttributeResult(attribute, level, difficulty, Some(f))
}

class SkillResult(
    val skill: Skill[TestAttribute],
    val level: Int,
    val difficulty: Option[Int] = None,
    val mod: Option[Mod[Int]] = None)
    (val defaultAttributes: List[TestAttribute] = skill.defaultAttributes)
  extends Result {

  def vs(difficulty: Int) =
    new SkillResult(skill, level, Some(difficulty))()

  def under(f: Mod[Int]) =
    new SkillResult(skill, level, difficulty, Some(f))()
}
