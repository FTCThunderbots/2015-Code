package io.github.thunderbots.resQ.time;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;

@OpMode(type="Autonomous", name="Auto Mountain [T][B]")
@Active
public class ResQAutoMountainBlueTime extends ResQAutoMountainTime {

	@Override
	protected int getSide() {
		return 1;
	}
	
}
