package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;

@OpMode(type="Autonomous", name="Auto Mountain [T][R]")
@Active
public class ResQAutoMountainRedTime extends ResQAutoMountainTime {

	@Override
	protected int getSide() {
		return -1;
	}
	
}
