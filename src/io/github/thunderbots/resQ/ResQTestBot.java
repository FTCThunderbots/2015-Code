package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.opmode.TeleOp;

public class ResQTestBot extends TeleOp {
	
	@Override
	protected void initializeRobot() {
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("back_left").setReversed(true);
	}

	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}
	
	@Override
	protected void setMovement() {
		Joystick drivingGamepad = Lightning.getJoystick(1);
		this.getDrive().setMovement(drivingGamepad.leftStickY()/2, drivingGamepad.rightStickX()/2);
	}

}
