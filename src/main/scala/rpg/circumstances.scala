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

/** Describes circumstances used to modify the acting party.
  *
  * @tparam A the type of what will be modified
  */
trait Circumstances[A] {
  /** Returns the modifier. */
  def mod: Mod[A]

  /** Returns the description of the circumstances. */
  def description: String
}

/** Describes good circumstances used to modify the acting party.
  *
  * @param mod the modifier
  * @param description the description of the circumstances
  *
  * @tparam A the type of what will be modified
  */
case class GoodCircumstances[A](mod: Mod[A], description: String = "")
  extends Circumstances[A]

/** Describes bad circumstances used to modify the acting party.
  *
  * @param mod the modifier
  * @param description the description of the circumstances
  *
  * @tparam A the type of what will be modified
  */
case class BadCircumstances[A](mod: Mod[A], description: String = "")
  extends Circumstances[A]
