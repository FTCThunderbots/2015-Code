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
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.lightning.robot.Robot;
import io.github.thunderbots.robotInOneWeek.Ri1WRobot;

@OpMode(type = "TeleOp", name = "ResQ")
public class ResQReverse extends TeleOp {

	@Override
	protected Ri1WRobot getRobot() {
		return (Ri1WRobot) super.getRobot();
	}

	private long lastBucketTime;
	private long lastLeftBoopTime;
	private long lastRightBoopTime;

	private static final long COOLDOWN_MS = 500;

	@Override
	protected void initializeOpMode() {
		this.getRobot().initializeRobot();
	}

	@Override
	protected void mainLoop() {
		Joystick driver = Lightning.getJoystick(1);
		Joystick aux = Lightning.getJoystick(2);
		this.setSweeper(aux);
		this.setBucket(aux);
		this.setBoopers(driver);
		this.getRobot().addDebugInformation();
	}

	public void setSweeper(Joystick joy) {
		if (joy.rightBumper()) {
			this.getRobot().setSweeperPower(1);
		} else if (joy.rightTrigger() == 1) {
			this.getRobot().setSweeperPower(-1);
		} else {
			this.getRobot().setSweeperPower(0);
		}
	}

	public void setBoopers(Joystick joy) {
		if (joy.leftButton()) {
			if (this.lastLeftBoopTime + ResQReverse.COOLDOWN_MS <= System.currentTimeMillis()) {
				this.lastLeftBoopTime = System.currentTimeMillis();
				this.getRobot().toggleLeftBooper();
			}
		}
		if (joy.rightButton()) {
			if (this.lastRightBoopTime + ResQReverse.COOLDOWN_MS <= System.currentTimeMillis()) {
				this.lastRightBoopTime = System.currentTimeMillis();
				this.getRobot().toggleRightBooper();
			}
		}
	}

	public void setBucket(Joystick joy) {
		if (this.lastBucketTime + ResQReverse.COOLDOWN_MS > System.currentTimeMillis()) {
			return;
		}
		this.lastBucketTime = System.currentTimeMillis();
		if (joy.xButton()) {
			this.getRobot().dumpBucketLeft();
		} else if (joy.bButton()) {
			this.getRobot().dumpBucketRight();
		} else if (joy.yButton()) {
			this.getRobot().centerBucket();
		}
	}

	@Override
	protected Robot createRobot() {
		return new Ri1WRobot();
	}

}
