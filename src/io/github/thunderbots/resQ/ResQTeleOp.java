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

@OpMode(type="TeleOp", name="ResQ")
public class ResQTeleOp extends TeleOp {
	
	private ResQRobot robot;
	
	private long lastBucketTime;
	private long lastLeftBoopTime;
	private long lastRightBoopTime;
	
	private static final long COOLDOWN_MS = 500;

	@Override
	protected void initializeRobot() {
		super.initializeRobot();
		this.robot = new ResQRobot();
		this.robot.initializeRobot();
		Lightning.getMotor("back_left").setReversed(true);
		Lightning.getMotor("back_right").setReversed(true);
	}

	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}
	
	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			Joystick drivingGamepad = Lightning.getJoystick(1);
			try {
				this.getDrive().setMovement(drivingGamepad.leftStickY(), -drivingGamepad.rightStickX());
			} catch (NullPointerException e) {
				String nulled = "";
				if (this.getDrive() == null) {
					nulled = "drive system";
				} else if (drivingGamepad == null) {
					nulled = "gamepad";
				}
				Lightning.sendTelemetryData(nulled + " is null!!");
			}
			Lightning.sendTelemetryData("joy1",
					drivingGamepad.leftStickY() + ", " + drivingGamepad.rightStickX());
			Lightning.sendTelemetryData("raw",
					this.gamepad1.left_stick_y + ", " + this.gamepad1.right_stick_x);
			this.mainLoop();
		}
	}
	
	@Override
	protected void mainLoop() {
		Joystick driver = Lightning.getJoystick(1);
		Joystick aux = Lightning.getJoystick(2);
		this.setSweeper(aux);
		this.setBucket(aux);
		this.setBoopers(driver);
		this.robot.addDebugInformation();
	}
	
	public void setSweeper(Joystick joy) {
		if (joy.rightBumper())
			this.robot.setSweeperPower(1);
		else if (joy.rightTrigger() == 1)
			this.robot.setSweeperPower(-1);
		else
			this.robot.setSweeperPower(0);
	}
	
	public void setBoopers(Joystick joy) {
		if (joy.leftButton()) {
			if (this.lastLeftBoopTime + COOLDOWN_MS <= System.currentTimeMillis()) {
				this.lastLeftBoopTime = System.currentTimeMillis();
				this.robot.toggleLeftBooper();
			}
		}
		if (joy.rightButton()) {
			if (this.lastRightBoopTime + COOLDOWN_MS <= System.currentTimeMillis()) {
				this.lastRightBoopTime = System.currentTimeMillis();
				this.robot.toggleRightBooper();
			}
		}
	}
	
	public void setBucket(Joystick joy) {
		if (this.lastBucketTime + COOLDOWN_MS > System.currentTimeMillis()) {
			return;
		}
		this.lastBucketTime = System.currentTimeMillis();
		if (joy.xButton()) {
			this.robot.dumpBucketLeft();
		} else if (joy.bButton()) {
			this.robot.dumpBucketRight();
		} else if (joy.yButton()) {
			this.robot.centerBucket();
		}
	}

}
