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

/** Provides attributes. Attributes are lazy, i.e. unset attributes will have a
  * default value specified by `defaultAttributeValues`.
  *
  * @tparam A the used attribute type
  *
  * @see [[rpg.Attribute]]
  */
trait Attributes[A <: Attribute] {
  /** Returns the value of the given attribute. */
  final def apply(a: A) = attrmap(a)

  /** Modifies the value of the given attribute. */
  final def mod(a: A, mod: Mod[Int] = _ + 1) {
    attrmap += (a -> mod(attrmap(a)))
  }

  /** Returns the attribute to value map. */
  final def attributes = attrmap

  /** Returns the default attribute to value function. If you want to override
    * it with a `val` make it a `lazy val`!
    */
  def defaultAttributeValues: A => Int

  /** Returns the attribute to value map. */
  private var attrmap = Map[A,Int]() withDefault defaultAttributeValues

  /** Returns an evaluation to check the given attribute. */
  def check(a: A): Evaluation
}
