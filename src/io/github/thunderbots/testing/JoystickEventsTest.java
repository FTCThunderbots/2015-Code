package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.control.ButtonHandler;
import io.github.thunderbots.lightning.control.JoystickButton;
import io.github.thunderbots.lightning.control.JoystickListener;
import io.github.thunderbots.lightning.control.ButtonHandler.PressType;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

public class JoystickEventsTest extends LightningOpMode implements JoystickListener {

	@Override
	protected void initializeOpMode() {
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
		Lightning.sendTelemetryData("Type", "[joy1] A button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.A, joystick = 1, type = PressType.RELEASE)
	public void onAButtonRelease() {
		Lightning.sendTelemetryData("Type", "[joy1] A button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.B, joystick = 1, type = PressType.PRESS)
	public void onBButtonPress() {
		Lightning.sendTelemetryData("Type", "[joy1] B button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.B, joystick = 1, type = PressType.RELEASE)
	public void onBButtonRelease() {
		Lightning.sendTelemetryData("Type", "[joy1] B button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.A, joystick = 2, type = PressType.PRESS)
	public void onJ2AButtonPress() {
		Lightning.sendTelemetryData("Type", "[joy1] A button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.A, joystick = 2, type = PressType.RELEASE)
	public void onJ2AButtonRelease() {
		Lightning.sendTelemetryData("Type", "[joy1] A button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.B, joystick = 2, type = PressType.PRESS)
	public void onJ2BButtonPress() {
		Lightning.sendTelemetryData("Type", "[joy1] B button pressed");
	}
	
	@ButtonHandler(button = JoystickButton.B, joystick = 2, type = PressType.RELEASE)
	public void onJ2BButtonRelease() {
		Lightning.sendTelemetryData("Type", "[joy1] B button pressed");
	}

}
