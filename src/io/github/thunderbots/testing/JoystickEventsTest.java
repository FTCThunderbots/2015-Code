package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.ButtonHandler;
import io.github.thunderbots.lightning.control.JoystickButton;
import io.github.thunderbots.lightning.control.JoystickListener;
import io.github.thunderbots.lightning.control.ButtonHandler.PressType;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

public class JoystickEventsTest extends LightningOpMode implements JoystickListener {

	@Override
	protected void initializeRobot() {
		Lightning.getJoystickMonitor(1).registerJoystickListener(this);
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			// repeat endlessly here
		}
	}
	
	@ButtonHandler(button = JoystickButton.A, joystick = 1, type = PressType.PRESS)
	public void onAButtonPress() {
		Lightning.sendTelemetryData("A button pressed");
	}

}
