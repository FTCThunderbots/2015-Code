/* Copyright (C) 2015 Thunderbots Robotics
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

import com.qualcomm.robotcore.hardware.ColorSensor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Telemetry;

@OpMode(type="Test", name="Color Sensor Ambt")
@Active
public class ColorSensorTest extends LightningOpMode {
	
	protected ColorSensor color;
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		Lightning.getTaskScheduler().registerTask(new SensorDataDisplayRunnable());
		this.color = Lightning.getSensor("color");
		this.color.enableLed(false);
	}
	
	@Override
	protected void main() {
		
	}
	
	private class SensorDataDisplayRunnable implements Runnable {

		@Override
		public void run() {
			Telemetry.sendTelemetryData("red", ColorSensorTest.this.color.red());
			Telemetry.sendTelemetryData("blue", ColorSensorTest.this.color.blue());
			Telemetry.sendTelemetryData("green", ColorSensorTest.this.color.green());
			Telemetry.sendTelemetryData("alpha", ColorSensorTest.this.color.alpha());
		}
		
	}
	
}
