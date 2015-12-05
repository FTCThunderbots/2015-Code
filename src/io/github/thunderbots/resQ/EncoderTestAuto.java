package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;

@OpMode(name="EncoderTestAuto", type="Autonomous")
@Active
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
		this.getRobot().initializeRobot();
	}
	
	@Override
	protected void main() {
		this.getRobot().getDrive().driveTicks(EncoderTestAuto.DRIVE_POWER, 500);
		this.getRobot().getDrive().rotateTicks(EncoderTestAuto.TURN_POWER, 500);
		this.getRobot().getDrive().swingTicks(false, EncoderTestAuto.SWING_POWER, 500);
		
	}

}
