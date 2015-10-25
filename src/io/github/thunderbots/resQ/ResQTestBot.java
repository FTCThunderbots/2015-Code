package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.robotInOneWeek.Ri1WRobot;

public class ResQTestBot extends TeleOp {
	
	@Override
	protected void initializeLightning() {
		this.setRobot(new Ri1WRobot());
		this.getRobot().initializeRobot();
	}
	
	@Override
	protected void setMovement() {
		Joystick drivingGamepad = Lightning.getJoystick(1);
		this.getRobot().getDrive().setMovement(drivingGamepad.leftStickY()/2, drivingGamepad.rightStickX()/2);
	}

}
