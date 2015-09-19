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

package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.hardware.Servo;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

/**
 * Servo Test is designed to test servo functionality. 
 */
public class ServoTest extends LightningOpMode {
	
	Servo testServo;
	
	private static final String SERVO_NAME = "servo";

	@Override
	protected void initializeRobot() {
		this.testServo = Lightning.getServo(SERVO_NAME);
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			this.moveServoFromJoystick(Lightning.getJoystick(1));
			Lightning.sendTelemetryData("servo", testServo.getPosition());
		}
	}
	
	private void moveServoFromJoystick(Joystick j) {
		double increment = 0;
		if (j.rightBumper()) {
			increment = 0.05;
		} else if (j.leftBumper()) {
			increment = -0.05;
		}
		this.testServo.move(increment);
		Lightning.sendTelemetryData("delta", increment);
	}

}
