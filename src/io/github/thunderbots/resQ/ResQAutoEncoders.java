package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.opmode.Autonomous;

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
		this.getRobot().getDrive().driveInches(.5, 12);
	}

}
