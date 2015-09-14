package io.github.thunderbots.cascadeEffect;

import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.annotations.OpMode;

@OpMode(type="Autonomous", name="CascadeEffect")
public class CascadeEffectAutonomous extends Autonomous {

	@Override
	protected String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	protected void main() {

	}

}
