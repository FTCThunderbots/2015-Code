package io.github.thunderbots.testing;

import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;
import io.github.thunderbots.resQ.ResQRobot;

@OpMode(name="EncoderTestAuto", type="Autonomous")
public class EncoderTestAuto extends Autonomous{
	
	private static final double DRIVE_POWER = 0.80;
	private static final double TURN_POWER = 0.80;
	private static final double SWING_POWER = 0.80;
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
	}
	
	@Override
	protected void main() {
		this.getRobot().getDrive().driveTicks(EncoderTestAuto.DRIVE_POWER, 3500);
		Util.sleep(2000);
		this.getRobot().getDrive().rotateTicks(EncoderTestAuto.TURN_POWER, 3500);
		Util.sleep(2000);
		this.getRobot().getDrive().swingTicks(false, EncoderTestAuto.SWING_POWER, 3500);
	}

}
