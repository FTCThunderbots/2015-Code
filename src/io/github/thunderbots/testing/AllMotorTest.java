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

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.qualcomm.robotcore.hardware.DcMotor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

public class AllMotorTest extends LightningOpMode {
	
	private List<Motor> allMotors;

	@Override
	protected void initializeRobot() {
		this.allMotors = new ArrayList<Motor>();
		for (Entry<String, DcMotor> entry : this.hardwareMap.dcMotor.entrySet()) {
			DcMotor m = entry.getValue();
			this.allMotors.add(new Motor(m));
		}
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			double power = Lightning.getJoystick(1).leftStickY();
			for (Motor m : this.allMotors) {
				m.setPower(power);
				Lightning.sendTelemetryData(m.getName(), m.getRawPosition());
			}
		}
	}

}
