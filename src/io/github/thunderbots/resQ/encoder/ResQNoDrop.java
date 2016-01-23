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
@OpMode(type="Autonomous", name="Auto No Sky [E]")
@Active
public class ResQNoDrop extends Autonomous {
	
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
		
		// start in front of the driver station, should be lined up in a straight line
		// directly to the beacon repair area
		// drive forward to the beacon repair area
		
		/*
		 * Drives forward using MOVEMENT_POWER for some inches up until the beacon zone, it then stops for 1500 milliseconds.
		 */
		ds.driveInches(MOVEMENT_POWER, 92);
		Util.sleep(STEP_DELAY);
		
		Util.sleep(STEP_DELAY);

	}
	
}	
