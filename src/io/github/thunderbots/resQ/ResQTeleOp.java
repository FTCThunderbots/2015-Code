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
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.control.layout.DriveSpinControlLayout;
import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.resQ.ResQRobot;

@OpMode(name="Tele Op", type="TeleOp")
@Active
public class ResQTeleOp extends TeleOp {

	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	/**
	 * Initializes the robot
	 * This is here to set the Robot into the correct stance
	 * The bucket will be centered, both doors on the bucket will be closed
	 * Both climber arms will move in to regular position
	 * Closes both the boopers
	 */
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
		this.getRobot().closeLeftBooper();
		this.getRobot().closeRightBooper();
		this.getRobot().openLeftBlocker();
		this.getRobot().openRightBlocker();
	}
	
	protected void mainLoop() {
		
		//Moves the legs on the robot by pressing and holding left and right bumpers
		if (Lightning.getJoystick(1).rightBumper()) {
			this.getRobot().walkForward();
		} else if (Lightning.getJoystick(1).leftBumper()) {
			this.getRobot().walkBackward();
		} else {
			this.getRobot().stopWalking();
		}
		
		if (Lightning.getJoystick(1).upButton()) {
			this.getRobot().armBucketForward();
		} else if (Lightning.getJoystick(1).downButton()) {
			this.getRobot().armBucketBackwards();
		} else if (Lightning.getJoystick(1).yButton()) {
			this.getRobot().setArmBucketPositionDefault();
		} else {
			this.getRobot().stopArmBucketRotation();
		}
		
		//Moves the climber arms forward by hitting the rightTrigger button
		if (Lightning.getJoystick(2).rightTriggerPressed()) {
			this.getRobot().moveRightClimberArm(1);
			this.getRobot().moveLeftClimberArm(0);
		}
		
		//Moves the climber arms back to position by hitting the leftTrigger button
		else if (Lightning.getJoystick(2).leftTriggerPressed()) {
			this.getRobot().moveRightClimberArm(0);
			this.getRobot().moveLeftClimberArm(1);
		}
		
		//Opens the left booper using the left button of the DPAD
		if (Lightning.getJoystick(2).leftButton()) {
			this.getRobot().openLeftBooper();
		} else {
			this.getRobot().closeLeftBooper();
		}
		
		//Opens the right booper using the right button of the D-PAD
		if (Lightning.getJoystick(2).rightButton()) {
			this.getRobot().openRightBooper();
		} else {
			this.getRobot().closeRightBooper();
		}
		
		if (Lightning.getJoystick(2).yButton()) {
			this.getRobot().moveArmExtensor(-1);
		} else if (Lightning.getJoystick(2).aButton()) {
			this.getRobot().moveArmExtensor(1);
		} else {
			this.getRobot().moveArmExtensor(0);
		}
		
		if (Lightning.getJoystick(2).upButton()) {
			this.getRobot().openLeftBlocker();
			this.getRobot().openRightBlocker();
		} else if (Lightning.getJoystick(2).downButton()) {
			this.getRobot().closeLeftBlocker();
			this.getRobot().closeRightBlocker();
		}
	}
	public ControlLayout createControlLayout() {
		return new DriveSpinControlLayout() {
			
			@Override
			public double getForwardPower(Joystick joy) {
				if (!joy.rightTriggerPressed())
					return super.getForwardPower(joy);
				return super.getForwardPower(joy) * .3;
			}

			@Override
			public double getClockwisePower(Joystick joy) {
				if (!joy.rightTriggerPressed())
					return super.getClockwisePower(joy);
				return super.getClockwisePower(joy) * .3;
			}
			
		};
	}
	
}
