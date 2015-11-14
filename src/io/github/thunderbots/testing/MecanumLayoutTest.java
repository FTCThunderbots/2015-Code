package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.layout.MecanumControlLayout;
import io.github.thunderbots.lightning.annotation.Active;

@Active

/**
 * Control Layouts Test is designed to test Control Layout functionality.
 * @author Jake Ohara
 */
@OpMode (type = "Teleop", name = "ControlLayoutsTest")
public class MecanumLayoutTest extends TeleOp {
	
	@Override 
	public ControlLayout createControlLayout() {
		return new MecanumControlLayout();
	}
	@Override 
	protected void mainLoop() {
		Lightning.sendTelemetryData("Type", "MecanumDriveLayout");
		
	}
}
