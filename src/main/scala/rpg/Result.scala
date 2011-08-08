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

/** Represents the outcome of a check.
  *
  * Results are devided in the two subcategories [[rpg.Success]] and
  * [[rpg.Failure]]. There are no ties - the actual ruleset decides whether a
  * tie favours the acting party or the reacting party.
  */
sealed abstract class Result {
  /** Returns the description of this result. */
  val description: String

  /** Returns the description of this result. */
  override def toString = description
}

/** The acting party succeeded in any way. */
abstract class Success extends Result

/** The acting party failed in any way. */
abstract class Failure extends Result

/** The acting party is incapable of performing the check. */
case class Incapable(description: String = "") extends Failure

/** The acting party is inferior. */
case class Inferior(description: String = "") extends Failure

/** The acting party is superior. */
case class Superior(description: String = "") extends Success

/** The acting party failed. */
case class Failed(description: String = "") extends Failure

/** The acting party succeeded. */
case class Succeeded(description: String = "") extends Success
