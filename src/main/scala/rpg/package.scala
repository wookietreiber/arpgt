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


package object rpg {

	type Random = scala.util.Random
	val  Random = scala.util.Random

	// ----------------------------------------------------------------------
	// actor aliases
	// ----------------------------------------------------------------------

	type Actor = akka.actor.Actor
	val  Actor = akka.actor.Actor

	val EventHandler = akka.event.EventHandler

	// ----------------------------------------------------------------------
	// common dice
	// ----------------------------------------------------------------------

	val D4   = Die(4)
	val D6   = Die(6)
	val D8   = Die(8)
	val D10  = Die(10)
	val D12  = Die(12)
	val D20  = Die(20)
	val D100 = Die(100)

}
