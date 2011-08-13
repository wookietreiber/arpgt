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


/** Contains an abstraction of the role-playing game (RPG) domain and provides a
  * domain-specific language (DSL) for convenient usage.
  *
  * The abstraction is designed to make it fairly easy to implement the rules of
  * a RPG, i.e. how an [[rpg.Attribute]] or [[rpg.Skill]] is checked.
  */
package object rpg {

  // ----------------------------------------------------------------------
  // actor aliases
  // ----------------------------------------------------------------------

  /** Actor type. */
  type Actor = akka.actor.Actor

  /** Actor factory. */
  val Actor = akka.actor.Actor

  /** Event handler used for logging. */
  val EventHandler = akka.event.EventHandler

  /** Convenience type that defines actor message behaviour. */
  type Receive = Actor.Receive

  // ----------------------------------------------------------------------
  // function aliases
  // ----------------------------------------------------------------------

  /** Modifier function. */
  type Mod[A] = A => A

  // ----------------------------------------------------------------------
  // common dice
  // ----------------------------------------------------------------------

  /** Returns a four-sided die. */
  val D4 = Die(4)

  /** Returns a six-sided die. */
  val D6 = Die(6)

  /** Returns an eight-sided die. */
  val D8 = Die(8)

  /** Returns a ten-sided die. */
  val D10 = Die(10)

  /** Returns a twelve-sided die. */
  val D12 = Die(12)

  /** Returns a twenty-sided die. */
  val D20 = Die(20)

  /** Returns a hundred-sided die. */
  val D100 = Die(100)
}
