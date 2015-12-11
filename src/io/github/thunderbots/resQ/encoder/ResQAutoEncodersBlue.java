package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;

@OpMode(name = "Auto Encoder Blue", type = "Autonomous")
@Active
public class ResQAutoEncodersBlue extends ResQAutoEncoders {

	@Override
	protected int getSide() {
		return 1;
	}

}