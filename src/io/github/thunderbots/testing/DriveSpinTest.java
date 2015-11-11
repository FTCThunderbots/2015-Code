package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.TeleOp;
import io.github.thunderbots.lightning.Lightning;

/**
 * Control Layouts Test is designed to test Control Layout functionality.
 * @author Jake Ohara
 */
@OpMode (type = "Teleop", name = "ControlLayoutsTest")
public class DriveSpinTest extends TeleOp {
	
	@Override 
	protected void mainLoop() {
		Lightning.sendTelemetryData("Type", "DriveSpinControlLayout");
		
	}
}
