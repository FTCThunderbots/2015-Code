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

import io.github.thunderbots.lightning.hardware.MotorSet;

public class AverageSingleEncoderTest extends AverageEncoderTest {
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.motors = new MotorSet(new String[] {"motor1"});
	}

	/* (non-Javadoc)
	 * 
	 * AverageSingleEncoderTest.java - tests average encoder functionality
	 * on a single motor.
	 * 
	 * Setup:
	 * 
	 * Attach a single motor to the robot, and name it "motor1" in the configuration.
	 * 
	 * Try the program again without the encoder. The values should stay at zero, but
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
	
}
