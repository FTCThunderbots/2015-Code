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
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.drive.DriveSystem;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.utility.Telemetry;
import io.github.thunderbots.resQ.ResQTeleOp;

@OpMode(type="Test", name="Encoder Drive Test")
@Active
public class EncoderDriveSystemTest extends ResQTeleOp {
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		Lightning.getTaskScheduler().registerTask(new EncoderUpdateRunnable());
	}
	
	@Override
	protected void mainLoop() {
		super.mainLoop();
		if (Lightning.getJoystick(1).upButton()) {
			this.getRobot().getDrive().resetEncoders();
		}
	}
	
	private class EncoderUpdateRunnable implements Runnable {
		
		private DriveSystem drive;
		private Motor[] motorSet;
		
		public EncoderUpdateRunnable() {
			this.drive = EncoderDriveSystemTest.this.getRobot().getDrive();
			this.motorSet = this.drive.getMotorSet().getMotorArray();
		}

		@Override
		public void run() {
			for (int i = 0; i < 4; i++) {
				Telemetry.sendData("motor" + i, motorSet[i].getEncoder().getPosition());
			}
			Telemetry.sendData("drive", drive.getDriveTicks());
			Telemetry.sendData("rotate", drive.getRotateTicks());
			Telemetry.sendData("swingCW", drive.getSwingTicks(true));
			Telemetry.sendData("swingCCW", drive.getSwingTicks(false));
		}
		
	}
	
}
