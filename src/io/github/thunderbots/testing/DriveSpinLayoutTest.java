package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.TeleOpTest;

@OpMode (type = "Teleop", name = "Drive-Spin layout test")
@Active
public class DriveSpinLayoutTest extends TeleOpTest {
	
	@Override 
	protected void mainLoop() {
		Lightning.sendTelemetryData("Control", "Drive-Spin control layout");
	}
	
}
