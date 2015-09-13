package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.Robot;
import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.hardware.Motor;

/**
 * @author Pranav Mathur
 */
public class CascadeEffectRobot extends Robot {

	private Joystick drivingGamepad;
	private Joystick secondaryGamepad;

	private Motor conveyor;
	private Motor goalHook;
	private Motor backboard;

	@SuppressWarnings("deprecation")
	protected void initializeRobot() {
		this.drivingGamepad = Lightning.getJoystick1();
		this.secondaryGamepad = Lightning.getJoystick2();
		this.conveyor = Lightning.getMotor("conveyor");
		this.goalHook = Lightning.getMotor("goalHook");
		this.backboard = Lightning.getMotor("backboard");
	}

	public void setConveyorJoystick() {
		if (this.secondaryGamepad.rightButton()) {
			this.conveyor.setPower(1.0);
		} else if (this.secondaryGamepad.rightBumper()) {
			this.conveyor.setPower(-1.0);
		} else {
			this.conveyor.setPower(0);
		}
	}

	public void setGoalHookJoystick() {
		if (this.drivingGamepad.rightButton()) {
			this.goalHook.setPower(1.0);
		} else if (this.drivingGamepad.rightBumper()) {
			this.goalHook.setPower(.4);
		} else {
			this.goalHook.setPower(0);
		}
	}

	public void setBackboardJoystick() {
		if (this.secondaryGamepad.aButton()) {
			this.backboard.setPower(.3);
		} else if (this.secondaryGamepad.xButton()) {
			this.backboard.setPower(-.3);
		} else {
			this.backboard.setPower(0);
		}
	}

}
