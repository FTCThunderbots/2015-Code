package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;

@OpMode(type="Autonomous", name="Auto Mountain [E][B]")
@Active
public class ResQAutoMountainEncoderBlue extends ResQAutoMountainEncoder {

	@Override
	protected int getSide() {
		return 1;
	}

}