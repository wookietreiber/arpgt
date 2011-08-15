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
  * There are always two parties in a check: the acting party (or actor) is
  * performing some task, is initiating it and the reacting party (or reactor)
  * is the (abstract) opponent of the actor, which can be something like
  * [[rpg.Level]], too, it sets on one part how hard it is for the actor to
  * succeed or not.
  *
  * Hence results always describe the acting party. They are devided in the two
  * subcategories [[rpg.Success]] and [[rpg.Failure]]. There are no ties - the
  * actual ruleset decides whether a tie favours the acting party or not.
  *
  * @see [[rpg.Success]]
  * @see [[rpg.Failure]]
  */
sealed abstract class Result {
  /** Returns the description of this result. */
  def description: String

  /** Returns `description`. */
  override def toString = description
}

/** The acting party succeeded in any way.
  *
  * @see [[rpg.Succeeded]]
  * @see [[rpg.Superior]]
  */
abstract class Success extends Result

/** The acting party failed in any way.
  *
  * @see [[rpg.Failed]]
  * @see [[rpg.Inferior]]
  * @see [[rpg.Incapable]]
  */
abstract class Failure extends Result

/** The acting party is incapable of performing the check. */
case class Incapable(description: String = "incapable") extends Failure

/** The acting party is inferior. */
case class Inferior(description: String = "inferior") extends Failure

/** The acting party is superior. */
case class Superior(description: String = "superior") extends Success

/** The acting party failed. */
case class Failed(description: String = "failed") extends Failure

/** The acting party succeeded. */
case class Succeeded(description: String = "succeeded") extends Success
