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
import io.github.thunderbots.lightning.opmode.LightningOpMode;

import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CompassSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * @author Zach Ohara
 */
public class GeneralSensorTest extends LightningOpMode {

	public static final String SENSOR_NAME = "sensor";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeOpMode() {
		// take no action
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void main() {
		try {
			AccelerationSensor sensor = Lightning.getSensor(GeneralSensorTest.SENSOR_NAME);
			// AccelerationSensor sensor =
			// this.hardwareMap.accelerationSensor.get(SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "acceleration");
				Lightning.sendTelemetryData("Data", sensor.getAcceleration());
			}
		} catch (Exception ignore) {
		}

		try {
			ColorSensor sensor = Lightning.getSensor(GeneralSensorTest.SENSOR_NAME);
			// AccelerationSensor sensor =
			// this.hardwareMap.accelerationSensor.get(SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "color");
				Lightning.sendTelemetryData("Data", sensor.toString());
			}
		} catch (Exception ignore) {
		}

		try {
			CompassSensor sensor = Lightning.getSensor(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "compass");
				Lightning.sendTelemetryData("Data", sensor.getDirection());
			}
		} catch (Exception ignore) {
		}

		try {
			GyroSensor sensor = Lightning.getSensor(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "gyro");
				Lightning.sendTelemetryData("Data", sensor.getRotation());
			}
		} catch (Exception ignore) {
		}

		try {
			IrSeekerSensor sensor = Lightning.getSensor(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "ir seeker");
				Lightning.sendTelemetryData("Data", sensor.getAngle() + ", " + sensor.getStrength());
			}
		} catch (Exception ignore) {
		}

		try {
			LightSensor sensor = this.hardwareMap.lightSensor.get(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "light");
				Lightning.sendTelemetryData("Data", sensor.getLightDetected());
			}
		} catch (Exception ignore) {
		}

		try {
			OpticalDistanceSensor sensor =
					this.hardwareMap.opticalDistanceSensor.get(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "optical distance");
				Lightning.sendTelemetryData("Data", sensor.getLightDetected());
			}
		} catch (Exception ignore) {
		}

		try {
			TouchSensor sensor = this.hardwareMap.touchSensor.get(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "touch");
				Lightning.sendTelemetryData("Data", sensor.getValue());
			}
		} catch (Exception ignore) {
		}

		try {
			UltrasonicSensor sensor = this.hardwareMap.ultrasonicSensor.get(GeneralSensorTest.SENSOR_NAME);
			while (this.opModeIsActive()) {
				Lightning.sendTelemetryData("Type", "ultrasonic");
				Lightning.sendTelemetryData("Data", sensor.getUltrasonicLevel());
			}
		} catch (Exception ignore) {
		}
	}

}
