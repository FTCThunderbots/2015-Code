/* Copyright (C) 2015 Thunderbots-5604
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
import io.github.thunderbots.lightning.control.TGamepad;
import io.github.thunderbots.lightning.drive.DriveMotorSet;
import io.github.thunderbots.lightning.drive.DriveSystem;
import io.github.thunderbots.lightning.drive.TankDrive;
import io.github.thunderbots.TeleOp;

/**
 * @author Pranav Mathur
 */
public class CascadeEffectTeleOp extends TeleOp {
	
	private DriveSystem drive;
	private TGamepad drivingGamepad;
	
	private CascadeEffectRobot robot;
	
	private static final String[] DRIVE_MOTOR_NAMES = {"front_left", "front_right", "back_left", "back_right"};
	
	@Override
	protected String[] getDriveMotorNames() {
		return DRIVE_MOTOR_NAMES;
	}

	@Override
	protected void initializeRobot() {
		DriveMotorSet motorSet = new DriveMotorSet(DRIVE_MOTOR_NAMES);
		this.drive = new TankDrive(motorSet);
		this.drivingGamepad = Lightning.getGamepad1();
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			this.drive.setMovement(drivingGamepad.leftStickY(), drivingGamepad.leftStickX());
			robot.setConveyorJoystick();
			robot.setGoalHookJoystick();
			robot.setBackboardJoystick();
		}
	}

}