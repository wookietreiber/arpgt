/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <wookietreiber@users.berlios.de>                       *
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

import org.specs2.mutable._

class DieSpec extends Specification {
	"dice creation" should {
		"fail with less than 2 sides" in {
			new Die( 1 ) must throwAn [IllegalArgumentException]
			new Die( 0 ) must throwAn [IllegalArgumentException]
			new Die(-42) must throwAn [IllegalArgumentException]
		}
	}

	"dice names" should {
		"start with 'D'" in {
			new Die(42).toString must startWith("D")
		}

		"end with their sides" in {
			val anInt = 42
			new Die(anInt).toString must endWith(anInt.toString)
		}
	}

	"dice with equal sides" should {
		"equal one another" in {
			new Die(42) == new Die(42)
		}

		"have an equal hash" in {
			new Die(42).## == new Die(42).##
		}
	}
}
