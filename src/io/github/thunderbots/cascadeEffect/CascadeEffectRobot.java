package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.sdk.TRobot;
import io.github.thunderbots.sdk.control.TGamepad;
import io.github.thunderbots.sdk.hardware.TMotor;

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
		this.drivingGamepad = TRobot.getGamepad1();
		this.secondaryGamepad = TRobot.getGamepad2();
		this.conveyor = TRobot.getMotor("conveyor");
		this.goalHook = TRobot.getMotor("goalHook");
		this.backboard = TRobot.getMotor("backboard");
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
