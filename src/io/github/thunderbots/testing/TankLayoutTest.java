package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.control.layout.TankControlLayout;
import io.github.thunderbots.lightning.opmode.TeleOpTest;

@OpMode (type = "Teleop", name = "Tank layout test")
@Active
public class TankLayoutTest extends TeleOpTest {
	
	@Override 
	public ControlLayout createControlLayout() {
		return new TankControlLayout();
	}
	
	@Override 
	protected void mainLoop() {
		Lightning.sendTelemetryData("Control", "Tank control layout");
	}
	
}
