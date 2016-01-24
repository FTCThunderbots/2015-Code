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

import com.qualcomm.robotcore.hardware.ColorSensor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.annotation.Active;
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Telemetry;

@OpMode(type="Test", name="Color Sensor Ambt")
@Active
public class ColorSensorTest extends LightningOpMode {
	
	protected ColorSensor color;
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.color = Lightning.getSensor("color");
		this.color.enableLed(false);
		Lightning.getTaskScheduler().registerTask(new SensorDataDisplayRunnable());
	}
	
	@Override
	protected void main() {
		
	}
	
	private class SensorDataDisplayRunnable implements Runnable {

		@Override
		public void run() {
			Telemetry.sendData("red", ColorSensorTest.this.color.red());
			Telemetry.sendData("blue", ColorSensorTest.this.color.blue());
			Telemetry.sendData("green", ColorSensorTest.this.color.green());
			Telemetry.sendData("alpha", ColorSensorTest.this.color.alpha());
		}
		
	}
	
}
