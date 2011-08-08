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

/** Base class of attributes. Almost all RPG systems use a very limited set of
  * attributes, so it is useful to implement them using a sealed class hierarchy
  * and case objects:
  *
  * {{{
  *   sealed abstract class MyAttribute extends Attribute
  *
  *   case object Strength     extends MyAttribute
  *   case object Charisma     extends MyAttribute
  *   case object Intelligence extends MyAttribute
  * }}}
  *
  * This has certain advantages:
  *
  *  - own super-type, which is useful for abstract and parameterized types
  *  - sealed hierarchy and case objects come in handy for pattern matching
  *  - `toString` will nicely return the name of the case object
  *
  * Attributes should never hold the actual value of the attribute, because they
  * are usually saved in an attribute-value map.
  *
  * @see [[rpg.Attributes]] for how attributes are usually saved
  */
abstract class Attribute
