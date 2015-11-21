package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.Active;
import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;

@Active
@OpMode(type="Autonomous", name="Auto Mountain [R]")

public class AutoMountainRed extends Autonomous{
		@Override
		protected ResQRobot getRobot() {
			return (ResQRobot) super.getRobot();
		}
		
		/** -1 is Red, 1 is Blue */
		private final static int side = -1;

		@Override
		protected void initializeOpMode() {
			super.initializeOpMode();
			this.setRobot(new ResQRobot());
			this.getRobot().initializeRobot();
		}
		
		@Override
		protected void main() {
			this.getRobot().getDrive().driveSeconds(.75, 2.0);
			this.getRobot().getDrive().waitAndStop(0.5);
			this.getRobot().getDrive().rotateSeconds(.75 * AutoMountainRed.side, .75);
			this.getRobot().getDrive().driveSeconds(.75, 1.5);
		}

	
}
