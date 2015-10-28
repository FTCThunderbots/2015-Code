package io.github.thunderbots.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.qualcomm.robotcore.hardware.DcMotor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.opmode.LightningOpMode;

public class AllMotorTest extends LightningOpMode {
	
	private List<Motor> allMotors;

	@Override
	protected void initializeOpMode() {
		this.allMotors = new ArrayList<Motor>();
		for (Entry<String, DcMotor> entry : this.hardwareMap.dcMotor.entrySet()) {
			DcMotor m = entry.getValue();
			this.allMotors.add(new Motor(m));
		}
	}

	@Override
	protected void main() {
		while (this.opModeIsActive()) {
			double power = Lightning.getJoystick(1).leftStickY();
			for (Motor m : this.allMotors) {
				m.setPower(power);
				Lightning.sendTelemetryData(m.getName(), m.getRawPosition());
			}
		}
	}

}
