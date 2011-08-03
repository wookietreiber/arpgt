/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <kizkizzbangbang@googlemail.com>                       *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *  This file is part of 'echo-tools'.                                      *
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

import org.specs2.mutable._

class SkillsSpec extends Specification {
  val skill = new Skill
  implicit val default = 42

  """a "Skills" implementation""" should {
    "return the default for unset skills" in {
      val impl = new SkillsImpl
      impl(skill) must_== default
    }

    "return non-default values for set skills" in {
      val impl = new SkillsImpl
      impl + (skill, 4)
      impl(skill) !== default
    }
  }

  class Skill extends GenericSkill
  class SkillsImpl(implicit val default: Int) extends Skills {
    type S = Skill
    override lazy val defaultSkillValues = (s: Skill) => default
    def +(s: Skill, v: Int) { skills += (s -> v) }
  }
}
