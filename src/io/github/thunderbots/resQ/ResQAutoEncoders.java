package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;

public abstract class ResQAutoEncoders extends Autonomous {
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	/**
	 * -1 is Red, 1 is Blue
	 */
	protected abstract int getSide();
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
	}

	@Override
	protected void main() {
		this.getRobot().getDrive().driveInches(.5, 24);
		Util.sleep(3000);
		this.getRobot().getDrive().rotateDegrees(.5, 180);
		Util.sleep(3000);
		this.getRobot().getDrive().driveInches(.5, 24);
	}

}
