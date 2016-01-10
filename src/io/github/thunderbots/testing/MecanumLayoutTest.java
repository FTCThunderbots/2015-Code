package io.github.thunderbots.testing;

import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.Joystick;
import io.github.thunderbots.lightning.control.layout.ControlLayout;
import io.github.thunderbots.lightning.control.layout.MecanumControlLayout;
import io.github.thunderbots.lightning.opmode.TeleOpTest;
import io.github.thunderbots.lightning.utility.Telemetry;

@OpMode (type = "Teleop", name = "Mecanum layout test")
public class MecanumLayoutTest extends TeleOpTest {
	
	@Override 
	public ControlLayout createControlLayout() {
		return new MecanumControlLayout();
	}
	
	@Override 
	protected void mainLoop() {
		Joystick drivingGamepad = Lightning.getJoystick(1);
		Telemetry.sendData("Type", "Mecanum Control Layout");
		double right = ((MecanumControlLayout) this.getControlLayout()).getRightStrafePower(drivingGamepad);
		Telemetry.sendData("right", right);
	}
	
}
