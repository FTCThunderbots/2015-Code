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
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.hardware.MotorSet;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Util;

@Active
public class AverageEncoderTest extends LightningOpMode {

	protected MotorSet motors;
	private EncoderUpdateRunnable encoderRunnable;
	
	protected static final int DELAY = 3000; // in milliseconds
	protected static final double POWER = 0.5; // motor power
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.motors = new MotorSet(new String[] {"motor1", "motor2"});
		this.encoderRunnable = new EncoderUpdateRunnable();
		Lightning.getTaskScheduler().registerTask(this.encoderRunnable);
	}

	/* (non-Javadoc)
	 * 
	 * AverageEncoderTest.java - tests average encoder functionality on two motors.
	 * 
	 * Setup:
	 * 
	 * Attach two motors to the robot. Name them "motor1" and "motor2" in the configuration.
	 * Attach an encoder to each of these motors.
	 * 
	 * Try the program again without any encoders. The values should stay at zero, but
	 * everything else should remain unchanged.
	 * 
	 * Expected behavior:
	 * 
	 * Currently the standard 'wait' delay is 3 seconds, and the
	 * standard 'forward' motor power is half power.
	 * 
	 * (prodecure | encoder observation)
	 * 
	 * +----------------------------------+------------------------------------------------+
	 * | 1. Wait                          | Value is zero.                                 |
	 * | 2. Move forward                  | Value increases.                               |
	 * | 3. Wait                          | Value does not change.                         |
	 * | 4. Move backward for double time | Value decreases steadily to approximately the  |
	 * |                                  | negative of the value observed in step 3.      |
 	 * | 5. Wait                          | Value does not change.                         |
	 * | 8. Move forward at double power  | Value increases at double the rate observed in |
	 * |                                  | step 2                                         |
	 * | 9. Wait                          | Value does not change.                         |
	 * | 10. Program stops                |                                                |
	 * |                                  |                                                |
	 * +-----------------------------------------------------------------------------------+
	 */
	@Override
	protected void main() {
		Util.sleep(DELAY);
		this.motors.setMotorPower(POWER);
		Util.sleep(DELAY);
		this.motors.stopAllMotors();
		Util.sleep(DELAY);
		this.motors.setMotorPower(-POWER);
		Util.sleep(DELAY * 2);
		this.motors.stopAllMotors();
		Util.sleep(DELAY);
		this.motors.setMotorPower(POWER * 2);
		Util.sleep(DELAY);
		this.motors.stopAllMotors();
		Util.sleep(DELAY);
	}
	
	protected class EncoderUpdateRunnable implements Runnable {

		@Override
		public void run() {
			Lightning.sendTelemetryData("Raw", AverageEncoderTest.this.motors.getAverageEncoderValue());
		}
		
	}
	
}
