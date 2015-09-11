package io.github.thunderbots.testing;

import com.qualcomm.robotcore.hardware.TouchSensor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.opmode.SimpleOpMode;

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
		this.touch = (TouchSensor)Lightning.getSensor("touchsensor");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			Lightning.sendTelemetryData("pressed", this.touch.isPressed());
			Lightning.sendTelemetryData("value", this.touch.getValue());
		}
	}

}
