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

class AttributesSpec extends Specification {
  val attr = new Attribute
  implicit val default = 42

  """an "Attributes" implementation""" should {
    "return the default for unset attributes" in {
      val impl = new AttributesImpl
      impl(attr) must_== default
    }

    "return non-default values for set attributes" in {
      val impl = new AttributesImpl
      impl + (attr, 4)
      impl(attr) !== default
    }
  }

  class Attribute extends GenericAttribute
  class AttributesImpl(implicit val default: Int) extends Attributes {
    type Attr = Attribute
    override lazy val defaultAttributeValues = (a: Attr) => default
    def +(a: Attr, v: Int) { attributes += (a -> v) }
  }
}
