package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.control.layout.TankControlLayout;
import io.github.thunderbots.lightning.opmode.TeleOpTest;
import io.github.thunderbots.lightning.utility.Telemetry;

@OpMode (type = "Teleop", name = "Tank layout test")
public class TankLayoutTest extends TeleOpTest {
	
	@Override 
	public ControlLayout createControlLayout() {
		return new TankControlLayout();
	}
	
	@Override 
	protected void mainLoop() {
		Telemetry.sendTelemetryData("Control", "Tank control layout");
	}
	
}
