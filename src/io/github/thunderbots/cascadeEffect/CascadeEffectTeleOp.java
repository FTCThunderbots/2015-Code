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
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.opmode.TeleOp;

/**
 * @author Pranav Mathur
 */

@OpMode(type="TeleOp", name="Cascade Effect")
public class CascadeEffectTeleOp extends TeleOp {

	private Joystick drivingGamepad;

	private CascadeEffectRobot robot;

	private static final String[] DRIVE_MOTOR_NAMES =
			{"front_left", "front_right", "back_left", "back_right"};

	@Override
	protected String[] getDriveMotorNames() {
		return CascadeEffectTeleOp.DRIVE_MOTOR_NAMES;
	}

	@Override
	protected void initializeRobot() {
		// DriveMotorSet motorSet = new
		// DriveMotorSet(CascadeEffectTeleOp.DRIVE_MOTOR_NAMES);
		this.drivingGamepad = Lightning.getJoystick(1);
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			this.getDrive().setMovement(this.drivingGamepad.leftStickY(), this.drivingGamepad.leftStickX());
			this.robot.setConveyorJoystick();
			this.robot.setGoalHookJoystick();
			this.robot.setBackboardJoystick();
		}
	}

}
