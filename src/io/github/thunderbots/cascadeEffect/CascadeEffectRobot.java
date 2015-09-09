package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.TGamepad;
import io.github.thunderbots.lightning.hardware.TMotor;

/**
 * @author Pranav Mathur
 */
public class CascadeEffectRobot {
	
	private TGamepad drivingGamepad;
	private TGamepad secondaryGamepad;

	private TMotor conveyor;
	private TMotor goalHook;
	private TMotor backboard;
	
	protected void initializeRobot() {
		this.drivingGamepad = Lightning.getGamepad1();
		this.secondaryGamepad = Lightning.getGamepad2();
		this.conveyor = Lightning.getMotor("conveyor");
		this.goalHook = Lightning.getMotor("goalHook");
		this.backboard = Lightning.getMotor("backboard");
	}
	
	public void setConveyorJoystick() {
		if (this.secondaryGamepad.rightButton())
			conveyor.setPower(1.0);
		else if (this.secondaryGamepad.rightBumper())
			conveyor.setPower(-1.0);
		else
			conveyor.setPower(0);
	}
	
	public void setGoalHookJoystick() {
		if (this.drivingGamepad.rightButton())
			goalHook.setPower(1.0);
		else if (this.drivingGamepad.rightBumper())
			goalHook.setPower(.4);
		else
			goalHook.setPower(0);
	}
	
	public void setBackboardJoystick() {
		if (this.secondaryGamepad.aButton())
			backboard.setPower(.3);
		else if (this.secondaryGamepad.xButton())
			backboard.setPower(-.3);
		else
			backboard.setPower(0);
	}
	
}
