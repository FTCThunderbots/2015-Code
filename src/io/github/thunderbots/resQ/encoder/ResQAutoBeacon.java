package io.github.thunderbots.resQ.encoder;

import com.qualcomm.robotcore.hardware.ColorSensor;

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.resQ.ResQRobot;

public abstract class ResQAutoBeacon extends Autonomous {
	
	@Override
	protected ResQRobot getRobot() {
		return (ResQRobot) super.getRobot();
	}
	
	/**
	 * Used by subclasses to determine which side of the field the robot is on.
	 * @return -1 for red, 1 for blue
	 */
	protected abstract int getSide();
	
	@Override
	protected void initializeOpMode() {
		super.initializeOpMode();
		this.setRobot(new ResQRobot());
	}
	
	@Override 
	protected void main() {
		//TODO: drive forward 90-ish inches
	}
	
	@OpMode(type="Autonomous", name="Beacon Auto [E][R]")
	//TODO: add @active
	public static class ResQAutoBeaconRed extends ResQAutoBeacon {

		@Override
		protected int getSide() {
			return -1;
		}
		
	}
	
	@OpMode(type="Autonomous", name="Beacon Auto [E][B]")
	//TODO: add @active
	public static class ResQAutoBeaconBlue extends ResQAutoBeacon {

		@Override
		protected int getSide() {
			return 1;
		}
		
	}

}
