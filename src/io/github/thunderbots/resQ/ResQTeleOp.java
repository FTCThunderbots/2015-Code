package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.robotInOneWeek.Ri1WRobot;

public class ResQTeleOp extends TeleOp {
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
		
	}

	@Override
	protected void initializeOpMode() {
		this.setRobot(new Ri1WRobot());
		this.getRobot().initializeRobot();
	}

}
