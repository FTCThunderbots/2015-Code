package io.github.thunderbots.testing;

import com.qualcomm.robotcore.hardware.TouchSensor;

import io.github.thunderbots.sdk.TRobot;
import io.github.thunderbots.sdk.opmode.SimpleOpMode;

/**
 * @author Zach Ohara
 */
public class SensorTest extends SimpleOpMode {

	private TouchSensor touch;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] getDriveMotorNames() {
		return new String[0];
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void initializeRobot() {
		super.initializeRobot();
		this.touch = TRobot.getTouchSensor("touchsensor");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			TRobot.sendTelemetryData("pressed", this.touch.isPressed());
			TRobot.sendTelemetryData("value", this.touch.getValue());
		}
	}

}
