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

case class AttributeEvaluation(
    attribute: Attribute,
    value: Int,
    difficulty: Option[Int] = None,
    mod: Option[Mod[Int]] = None)
  extends Evaluation {

  def vs(difficulty: Int): AttributeEvaluation =
    new AttributeEvaluation(attribute, value, Some(difficulty))

  def under(f: Mod[Int]): AttributeEvaluation =
    new AttributeEvaluation(attribute, value, difficulty, Some(f))
}

case class SkillEvaluation(
    skill: Skill[TestAttribute],
    value: Int,
    difficulty: Option[Int] = None,
    mod: Option[Mod[Int]] = None)
    (val defaultAttributes: List[TestAttribute] = skill.defaultAttributes)
  extends Evaluation {

  def vs(difficulty: Int) =
    new SkillEvaluation(skill, value, Some(difficulty))()

  def under(f: Mod[Int]) =
    new SkillEvaluation(skill, value, difficulty, Some(f))()
}
