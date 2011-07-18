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

/** Dice-shaking actor, encapsulating the (pseudo-) random number generator.
	*
	* This actor excepts messages of type [[rpg.Die]].
	*/
class Shaker extends Actor {
	/** Returns the random number generator. */
	protected val random = new scala.util.Random

	// -----------------------------------------------------------------------
	// message handling
	// -----------------------------------------------------------------------

	/** Handling done via `messageHandler orElse genericMessageHandler`. */
	override final def receive = messageHandler orElse genericMessageHandler

	/** Defines user specific message handling. */
	protected def messageHandler: Receive = {
		case null =>
	}

	private def genericMessageHandler: Receive = {
		case die @ Die(sides) =>
			val result = random.nextInt(sides) + 1
			self.channel ! result

		case event =>
			EventHandler.warning(self, "Don't know what to do with: " + event)
	}
}
