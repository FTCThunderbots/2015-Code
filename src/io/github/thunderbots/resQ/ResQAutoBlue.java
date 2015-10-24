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

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.robotInOneWeek.Ri1WRobot;

@OpMode(type = "Autonomous", name = "ResQ")
public class ResQAutoBlue extends Autonomous {

	Ri1WRobot robot;

	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.robot = new Ri1WRobot();
		this.robot.initializeRobot();
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	protected void main() {
		this.getDrive().driveSeconds(.5, 3);
		this.getDrive().waitAndStop(1.0);
		this.getDrive().rotateSeconds(-.5, 3);
		this.getDrive().waitAndStop(1.0);
		this.getDrive().driveSeconds(.5, 6);
		this.getDrive().waitAndStop(1.0);
	}

}
