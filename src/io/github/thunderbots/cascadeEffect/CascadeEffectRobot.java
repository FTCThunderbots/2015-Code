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

package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.Robot;

/**
 * @author Pranav Mathur
 */
public class CascadeEffectRobot implements Robot {

	private Joystick drivingGamepad;
	private Joystick secondaryGamepad;

	private Motor conveyor;
	private Motor goalHook;
	private Motor backboard;

	@Override
	public void initializeRobot() {
		this.drivingGamepad = Lightning.getJoystick(1);
		this.secondaryGamepad = Lightning.getJoystick(2);
		this.conveyor = Lightning.getMotor("conveyor");
		this.goalHook = Lightning.getMotor("goalHook");
		this.backboard = Lightning.getMotor("backboard");
	}

	public void setConveyorJoystick() {
		if (this.secondaryGamepad.rightButton()) {
			this.conveyor.setPower(1.0);
		} else if (this.secondaryGamepad.rightBumper()) {
			this.conveyor.setPower(-1.0);
		} else {
			this.conveyor.setPower(0);
		}
	}

	public void setGoalHookJoystick() {
		if (this.drivingGamepad.rightButton()) {
			this.goalHook.setPower(1.0);
		} else if (this.drivingGamepad.rightBumper()) {
			this.goalHook.setPower(.4);
		} else {
			this.goalHook.setPower(0);
		}
	}

	public void setBackboardJoystick() {
		if (this.secondaryGamepad.aButton()) {
			this.backboard.setPower(.3);
		} else if (this.secondaryGamepad.xButton()) {
			this.backboard.setPower(-.3);
		} else {
			this.backboard.setPower(0);
		}
	}

}
