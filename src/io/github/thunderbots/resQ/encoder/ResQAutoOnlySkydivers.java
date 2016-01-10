package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.annotation.Active;
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.drive.DriveSystem;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;
import io.github.thunderbots.resQ.ResQRobot;

/**
 * @author Jake Ohara
 */
@OpMode(type="Autonomous", name="Auto Skydivers Only [E]")
@Active
public class ResQAutoOnlySkydivers extends Autonomous {
	
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

	@Override
	protected void main() {
		DriveSystem ds = this.getRobot().getDrive(); // for brevity
		ResQRobot resQRobot = this.getRobot(); //creating instance of the class here
		
		// start in front of the driver station, should be lined up in a straight line
		// directly to the beacon repair area
		// drive forward to the beacon repair area
		
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

	}
	
}	
