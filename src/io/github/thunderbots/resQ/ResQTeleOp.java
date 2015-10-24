package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.opmode.TeleOp;

public class ResQTeleOp extends TeleOp {
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
		
	}

	@Override
	protected void initializeLightning() {
		this.getRobot().initializeRobot();
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}

	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

}
