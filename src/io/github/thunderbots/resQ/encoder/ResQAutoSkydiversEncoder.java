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

package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.annotation.Active;
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.drive.DriveSystem;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;
import io.github.thunderbots.resQ.ResQRobot;

public abstract class ResQAutoSkydiversEncoder extends Autonomous {
	
	private static final double MOVEMENT_POWER = 0.8;
	private static final long STEP_DELAY = 1500; // in milliseconds
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
	}
	
	/**
	 * -1 is Red, 1 is Blue
	 */
	protected abstract int getSide();

	@Override
	protected void main() {
		DriveSystem ds = this.getRobot().getDrive(); // for brevity
		ResQRobot resQRobot = this.getRobot(); //creating instance of the class here
		// start in front of the driver station
		// drive forward to the beacon repair area
		//TODO: Implement color sensor on the robot, and hit the beacon.
		
		/*
		 * Drives forward using MOVEMENT_POWER for 100 inches up until the beacon zone, it then stops for 1500 milliseconds.
		 */
		ds.driveInches(MOVEMENT_POWER, 100);
		Util.sleep(STEP_DELAY);
		
		/*
		 * Moves the Climber Arm forwards to drop the skydivers. Then sleeps for 1500 milliseconds
		 */
		//moveClimberArm methods commented out because they are currently commented out in ResQRobot
		resQRobot.moveLeftClimberArm(0);
		resQRobot.moveRightClimberArm(1);
		Util.sleep(STEP_DELAY);
		
		/*
		 * Moves the Climber Arm back to default position and sleeps for 500 milliseconds.
		 */
		resQRobot.moveLeftClimberArm(1);
		resQRobot.moveRightClimberArm(0);
		Util.sleep(500);
		
		
		//The following code is ALL USING ESTIMATES and needs testing before it may be used!
		
		/*
		 * The Robot then turns all the way around and sleeps for 500 milliseconds.
		 */
		ds.rotateDegrees(MOVEMENT_POWER, 56);
		Util.sleep(500);
		
		/*
		 * Moves the Robot forward 24 inches at a power of 0.8. Then waits for 1500 milliseconds.
		 */
		ds.driveInches(MOVEMENT_POWER, 24);
		Util.sleep(STEP_DELAY);
		
		/*
		 * Turns the robot 90 degrees depending which side it's on. Waits for 1500 milliseconds.
		 */
		ds.rotateDegrees(MOVEMENT_POWER, 90 *this.getSide());
		Util.sleep(STEP_DELAY);
		
		/*
		 * Moves the robot up the ramp and waits for 500 milliseconds
		 * 
		 * NOTE: YOU WANT TO WAIT FOR THE DRIVER STATION TO SHOW INIT AGAIN ON THE SCREEN, DO NOT HIT STOP, IT HAS CAUSED PROBLEMS IN A PREVIOUS COMPETITION.
		 * HAVE PATIENCE MY CHILDREN.
		 */
		ds.driveInches(MOVEMENT_POWER, 10);
		Util.sleep(500);
		
	}
	
	@OpMode(type="Autonomous", name="Auto Skydivers [E][B]")
	@Active
	public static class ResQAutoSkydiversEncoderBlue extends ResQAutoSkydiversEncoder {
		
		@Override
		protected int getSide() {
			return 1;
		}
		
	}
	
	@OpMode(type="Autonomous", name="Auto Skydivers [E][R]")
	@Active
	public static class ResQAutoSkydiversEncoderRed extends ResQAutoSkydiversEncoder {
		
		@Override
		protected int getSide() {
			return -1;
		}
		
	}
	
}
