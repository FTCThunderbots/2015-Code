/* Copyright (C) 2015-2016 Thunderbots Robotics
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;

@OpMode(type = "Autonomous", name = "ResQ")
@Active
public class ResQAutonomous extends Autonomous {

	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}

	/** -1 is Red, 1 is Blue */
	private final static int side = 1;

	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
		this.getRobot().initializeRobot();
	}

	@Override
	protected void main() {
		this.getRobot().getDrive().driveSeconds(.5, .75);
		this.getRobot().getDrive().waitAndStop(2.0);
		this.getRobot().getDrive().rotateSeconds(.5 * ResQAutonomous.side, 1);
		this.getRobot().getDrive().waitAndStop(2.0);
		this.getRobot().getDrive().driveSeconds(.5, .75);
		this.getRobot().getDrive().waitAndStop(2.0);
	}

}
