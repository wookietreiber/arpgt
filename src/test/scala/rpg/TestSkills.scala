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

sealed abstract class TestSkill(
    val name: String,
    val defaultAttributes: List[TestAttribute])
  extends Skill[TestAttribute] {

  override def check(lvl: Int, difficulty: Int, mod: Mod[Int], attributes: List[TestAttribute]) =
    new SkillResult(this, lvl, Some(difficulty), Some(mod))(attributes)
}

case object Running extends TestSkill("Running", List(Stamina))

class TestSkills(default: Int) extends Skills[TestAttribute] {
  type Skill = TestSkill

  protected def defaultSkillValues = (s: Skill) => default

  def +(s: Skill, v: Int) { skills += (s -> v) }
}
