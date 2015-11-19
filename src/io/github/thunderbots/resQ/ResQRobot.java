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
import io.github.thunderbots.lightning.robot.Robot;

public class ResQRobot extends Robot {

	@Override
	public void initializeRobot() {
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}

	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}
	
	public void setLegPower(double right, double left) {
		Lightning.getMotor("left_leg").setPower(left);
		Lightning.getMotor("right_leg").setPower(right);
	}

}
