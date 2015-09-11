package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.Autonomous;

public class CascadeEffectAutonomous extends Autonomous {

	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	protected void main() {
		
	}

}
