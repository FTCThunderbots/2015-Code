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

package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.lightning.drive.DriveSystem;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.resQ.ResQRobot;

public abstract class ResQAutoSkydiversEncoder extends Autonomous {
	
	private static final double MOTOR_POWER = 0.8;
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
	}
	
	/**
	 * -1 is Red, 1 is Blue
	 */
	protected abstract int getSide();

	@Override
	protected void main() {
		DriveSystem ds = this.getRobot().getDrive(); // for brevity
		
		// start in front of the driver station
		
		// drive forward to the beacon repair area
		ds.driveInches(MOTOR_POWER, 60);
		// rotate to square with the basket
		ds.rotateDegrees(MOTOR_POWER * this.getSide(), 15 * this.getSide());
		// move forward a little bit to reach the bucket
		ds.driveInches(MOTOR_POWER, 6);
		// TODO: drop the skydivers here
		// back up to get room to rotate
		ds.driveInches(-MOTOR_POWER, -6);
		// rotate to go back to the mountain
		ds.rotateDegrees(-MOTOR_POWER * this.getSide(), -15 * this.getSide());
		// go back to the mountain
		ds.driveInches(-MOTOR_POWER, -30);
		// rotate to face the mountain
		ds.rotateDegrees(MOTOR_POWER * this.getSide(), 90 * this.getSide());
		// drive up the mountain
		ds.driveInches(MOTOR_POWER, 10);
		
		// ayy lmao
	}
	
}
