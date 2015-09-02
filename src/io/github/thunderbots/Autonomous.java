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

package io.github.thunderbots;

import io.github.thunderbots.sdk.drive.DriveSystem;
import io.github.thunderbots.sdk.drive.TankDrive;
import io.github.thunderbots.sdk.opmode.TLinearOpMode;

/**
 * The Autonomous class is a base class that all autonomous programs should extend. It will handle
 * everything directly related to driving and moving the robot.
 *
 * @author Pranav Mathur
 */
public abstract class Autonomous extends TLinearOpMode {
	
	private DriveSystem drive;
	
	/**
	 * Gets an array of Strings representing the names of the motors used for driving.
	 * <p>
	 * If the robot has four motors, this array should be in the format of:
	 * <pre> [front left, front right, back left, back right] </pre>
	 * If the robot has only two motors, this array should be in the format of:
	 * <pre> [left, right] </pre>
	 *
	 * @return the names of the driving motors.
	 */
	protected abstract String[] getDriveMotorNames();
	
	/**
	 * Constructs a DriveSystem that the robot should use. TankDrive is assumed by default,
	 * but this can be changed on an individual basis by overriding this method.
	 *
	 * @return
	 */
	protected DriveSystem createDriveSystem() {
		return new TankDrive(this.getDriveMotorNames());
	}

	@Override
	protected void initializeRobot() {
		this.drive = this.createDriveSystem();
	}

	protected abstract void main();

}
