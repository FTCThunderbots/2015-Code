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
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.hardware.Servo;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Telemetry;

/**
 * A quick demo to show the peer-to-peer communication between the two phones.
 * The op mode will read buttons from the joystick and display imformation on the
 * robot controller screen.
 *
 * @author Zach Ohara
 */
@OpMode(type="Demo", name="Joystick Demo")
public class JoystickDemo extends LightningOpMode {
	
	private Servo servo;
	
	@Override
	protected void initializeOpMode() {
		try {
			this.servo = Lightning.getServo("servo");
		} catch (IllegalArgumentException ignore) {}
	}
	
	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			Joystick joy1 = Lightning.getJoystick(1);
			Joystick joy2 = Lightning.getJoystick(2);
			Telemetry.sendData("Joy 1", joy1.toButtonList());
			Telemetry.sendData("Joy 2", joy2.toButtonList());
			if (this.servo != null) {
				this.servo.moveToPosition(joy1.leftStickY());
			}
		}
	}
	
}
