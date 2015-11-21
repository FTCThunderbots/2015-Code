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
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Util;

public class EncoderTest extends LightningOpMode {
	
	private Motor testMotor;
	private EncoderUpdateRunnable encoderRunnable;
	
	private static final int DELAY = 3000; // in milliseconds
	private static final double POWER = 0.5; // motor power

	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.testMotor = Lightning.getMotor("motor");
		this.encoderRunnable = new EncoderUpdateRunnable();
		Lightning.getTaskScheduler().registerTask(this.encoderRunnable);
	}

	/* (non-Javadoc)
	 * 
	 * EncoderTest.java - tests encoder functionality on a single motor.
	 * 
	 * Setup:
	 * 
	 * Attach a single motor named "motor" in the configuration, and attach an encoder
	 * to that motor.
	 * 
	 * Run the test again without an encoder. The values should stay at zero, but everything
	 * else should remain unchanged.
	 * 
	 * Expected behavior:
	 * 
	 * Currently the standard 'wait' delay is 3 seconds, and the
	 * standard 'forward' motor power is half power.
	 * 
	 * (prodecure | encoder observation)
	 * 
	 * +----------------------------------+-------------------------------------------------------+
	 * | 1. Wait                          | Both values are at 0                                  |
	 * | 2. Move forward                  | Both values increase at the same rate                 |
	 * | 3. Wait                          | Neither value changes. They are equivalent and        |
	 * |                                  | both positive                                         |
	 * | 4. Move backward for double time | Both values decrease at the same rate to              |
	 * |                                  | approximately the negative of the observed value      |
	 * |                                  | at step 3.                                            |
 	 * | 5. Wait                          | Neither value changes. They are equivalent and        |
	 * |                                  | both negative.                                        |
	 * | 6. Reset the 'zero' position     | The 'raw' value does not change. The 'encoder' value  |
	 * |                                  | changes instantly to zero.                            |
	 * | 7. Wait                          | Neither value changes.                                |
	 * | 8. Move forward at double power  | Both values increase at double the rate observed in   |
	 * |                                  | step 2. They are not equivalent.                      |
	 * | 9. Wait                          | Neither value changes.                                |
	 * | 10. Program stops                |                                                       |
	 * |                                  |                                                       |
	 * +------------------------------------------------------------------------------------------+
	 */
	@Override
	protected void main() {
		Util.sleep(DELAY);
		this.testMotor.setPower(POWER);
		Util.sleep(DELAY);
		this.testMotor.stop();
		Util.sleep(DELAY);
		this.testMotor.setPower(-POWER);
		Util.sleep(DELAY * 2);
		this.testMotor.stop();
		Util.sleep(DELAY);
		this.testMotor.getEncoder().reset();
		Util.sleep(DELAY);
		this.testMotor.setPower(POWER * 2);
		Util.sleep(DELAY);
		this.testMotor.stop();
		Util.sleep(DELAY);
	}
	
	protected class EncoderUpdateRunnable implements Runnable {

		@Override
		public void run() {
			Lightning.sendTelemetryData("Raw", EncoderTest.this.testMotor.getRawPosition());
			Lightning.sendTelemetryData("Encoder", EncoderTest.this.testMotor.getEncoder().getPosition());
		}
		
	}

}
