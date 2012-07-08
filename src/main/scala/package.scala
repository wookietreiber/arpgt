/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011-2012  Christian Krause                              *
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


/** Contains an abstraction of the role-playing game (RPG) domain and provides a
  * domain-specific language (DSL) for convenient usage.
  *
  * The abstraction is designed to make it fairly easy to implement the rules of
  * a RPG, i.e. how an [[rpg.Attribute]] or [[rpg.Skill]] is checked.
  */
package object rpg {

  // ----------------------------------------------------------------------
  // function aliases
  // ----------------------------------------------------------------------

  /** Modifier function. */
  type Mod[A] = A ⇒ A

  // ----------------------------------------------------------------------
  // common dice
  // ----------------------------------------------------------------------

  /** Returns a three-sided die. */
  lazy val d3 = Die(3)

  /** Returns a four-sided die. */
  lazy val d4 = Die(4)

  /** Returns a six-sided die. */
  lazy val d6 = Die(6)

  /** Returns an eight-sided die. */
  lazy val d8 = Die(8)

  /** Returns a ten-sided die. */
  lazy val d10 = Die(10)

  /** Returns a twelve-sided die. */
  lazy val d12 = Die(12)

  /** Returns a twenty-sided die. */
  lazy val d20 = Die(20)

  /** Returns a hundred-sided die. */
  lazy val d100 = Die(100)

}
