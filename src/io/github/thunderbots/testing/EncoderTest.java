package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

public class EncoderTest extends LightningOpMode {
	
	private Motor testMotor;
	
	protected void initializeRobot() {
		this.testMotor = Lightning.getMotor("test");
	}

	@Override
	protected void main() {
		testMotor.setPower(.5);
		long currentTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < currentTime + 5000) {
			Lightning.sendTelemetryData("Encoder", testMotor.getRawPosition());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		testMotor.stop();
		Lightning.sendTelemetryData("Encoder", testMotor.getRawPosition());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
