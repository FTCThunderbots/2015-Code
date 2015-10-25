package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.robot.Robot;

public class SimpleRobot extends Robot {

	private static final String[] DRIVE_MOTOR_NAMES =
			{"front_left", "front_right", "back_left", "back_right"};

	@Override
	public String[] getDriveMotorNames() {
		return SimpleRobot.DRIVE_MOTOR_NAMES;
	}

	@Override
	public void initializeRobot() {

	}

}
