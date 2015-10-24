package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Util;

public class EncoderTest extends LightningOpMode {
	
	private Motor testMotor;
	
	protected void initializeLightning() {
		this.testMotor = Lightning.getMotor("test");
	}

	@Override
	protected void main() {
		testMotor.setPower(.5);
		Util.sleep(5000);
		testMotor.stop();
		Lightning.sendTelemetryData("Encoder", testMotor.getRawPosition());
		Util.sleep(5000);
	}

}
