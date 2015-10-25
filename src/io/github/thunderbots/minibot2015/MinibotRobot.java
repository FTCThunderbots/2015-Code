package io.github.thunderbots.minibot2015;

import io.github.thunderbots.lightning.robot.Robot;

public class MinibotRobot extends Robot {

	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"left_motor", "right_motor"};
	}

	@Override
	public void initializeRobot() {

	}

}
