package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.sdk.Robot;
import io.github.thunderbots.sdk.control.TGamepad;
import io.github.thunderbots.sdk.hardware.TMotor;

public class CascadeEffectRobot {
	
	private TGamepad drivingGamepad;
	private TGamepad secondaryGamepad;

	private TMotor conveyor;
	private TMotor goalHook;
	
	protected void initializeRobot() {
		this.drivingGamepad = Robot.getGamepad1();
		this.secondaryGamepad = Robot.getGamepad2();
		this.conveyor = Robot.getMotor("conveyor");
		this.goalHook = Robot.getMotor("goalHook");
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
		if (this.secondaryGamepad.rightButton())
			goalHook.setPower(1.0);
		else if (this.secondaryGamepad.rightBumper())
			goalHook.setPower(.4);
		else
			goalHook.setPower(0);
	}
	
}
