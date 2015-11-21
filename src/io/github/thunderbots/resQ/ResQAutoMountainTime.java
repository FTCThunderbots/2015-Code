/* Copyright (C) 2015 Thunderbots Robotics
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

import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;

public abstract class ResQAutoMountainTime extends Autonomous {
	
	private static final double DRIVE_POWER = 0.75;
	private static final double TURN_POWER = 0.75;
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	/**
	 * -1 is Red, 1 is Blue
	 */
	protected abstract int getSide();
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
		this.getRobot().initializeRobot();
	}
	
	@Override
	protected void main() {
		this.getRobot().getDrive().driveSeconds(DRIVE_POWER, 2.0);
		Util.sleep(500);
		this.getRobot().getDrive().rotateSeconds(TURN_POWER * this.getSide(), 0.75);
		this.getRobot().getDrive().driveSeconds(DRIVE_POWER, 1.5);
	}
	
}