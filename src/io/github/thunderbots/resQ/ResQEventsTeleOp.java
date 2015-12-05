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
import io.github.thunderbots.lightning.control.ButtonHandler;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.control.JoystickButton;
import io.github.thunderbots.lightning.control.JoystickListener;
import io.github.thunderbots.lightning.control.ButtonHandler.PressType;
import io.github.thunderbots.lightning.opmode.TeleOp;

@OpMode(name="Event Tele Op", type="TeleOp")
public class ResQEventsTeleOp extends TeleOp implements JoystickListener {

	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}

	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		Lightning.getJoystickMonitor(1).registerJoystickListener(this);
		Lightning.getJoystickMonitor(2).registerJoystickListener(this);
		this.setRobot(new ResQRobot());
		this.getRobot().initializeRobot();
	}
	
	@ButtonHandler(button=JoystickButton.RIGHT_BUMPER, joystick=1)
	public void walkForward() {
		this.getRobot().walkForward();
	}
	
	@ButtonHandler(button=JoystickButton.LEFT_BUMPER, joystick=1)
	public void walkBackward() {
		this.getRobot().walkBackward();
	}
	
	@ButtonHandler(button=JoystickButton.RIGHT_BUMPER, joystick=1, type=PressType.RELEASE)
	public void stopWalkingForward() {
		this.stopWalking();
	}

	@ButtonHandler(button=JoystickButton.LEFT_BUMPER, joystick=1, type=PressType.RELEASE)
	public void stopWalkingBackward() {
		this.stopWalking();
	}
	
	public void stopWalking() {
		Joystick driver = Lightning.getJoystick(1);
		if (!driver.leftBumper()  && !driver.rightBumper()) {
			this.getRobot().stopWalking();
		}
	}

}
