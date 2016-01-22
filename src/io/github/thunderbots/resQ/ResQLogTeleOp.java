package io.github.thunderbots.resQ;

import io.github.thunderbots.annotation.Active;
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.control.layout.LogControlLayout;

@OpMode(name = "Log TeleOp", type = "TeleOp")
@Active
public class ResQLogTeleOp extends ResQTeleOp {
	
	public ControlLayout createControlLayout() {
		return new LogControlLayout();
	}
	
}
