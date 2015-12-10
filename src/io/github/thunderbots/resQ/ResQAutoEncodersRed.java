package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;

@OpMode(name = "Auto Encoder Red", type = "Autonomous")
@Active
public class ResQAutoEncodersRed extends ResQAutoEncoders {

	@Override
	protected int getSide() {
		return -1;
	}
	
}
