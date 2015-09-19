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
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.hardware.Servo;
import io.github.thunderbots.lightning.robot.Robot;

public class ResQRobot implements Robot {
	
	private Servo bucketTiltServo;
	private Motor sweeper;

	@Override
	public void initializeRobot() {
		// TODO Auto-generated method stub
		sweeper = Lightning.getMotor("sweeper");
	}
	
	public void setSweeperJoystick() {
		Joystick joy1 = Lightning.getJoystick(1);
		if (joy1.rightBumper())
			sweeper.setPower(1.0);
		else if (joy1.rightTrigger() == 1)
			sweeper.setPower(-1.0);
		else
			sweeper.setPower(0.0);
	}
	
}
