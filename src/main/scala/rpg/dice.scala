/* **************************************************************************
 *                                                                          *
 *  Copyright (C)  2011  Christian Krause                                   *
 *                                                                          *
 *  Christian Krause <wookietreiber@users.berlios.de>                       *
 *                                                                          *
 ****************************************************************************
 *                                                                          *
 *  This file is part of 'rpg-tools'.                                       *
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

/**
 * An x-sided die.
 *
 * Most common dice are already defined as vals in `package object rpg`.
 *
 * @param sides sides of the die, has to be greater than 1
 */
case class Die(sides: Int) {
	require(sides >= 2, "Too few sides!")

	override val toString = "D" + sides
}
