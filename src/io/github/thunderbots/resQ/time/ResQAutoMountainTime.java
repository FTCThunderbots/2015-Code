/* Copyright (C) 2015-2016 Thunderbots Robotics
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.thunderbots.resQ.time;

import io.github.thunderbots.annotation.Active;
import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.lightning.utility.Util;
import io.github.thunderbots.resQ.ResQRobot;

public abstract class ResQAutoMountainTime extends Autonomous {
	
	private static final double DRIVE_POWER = 0.75;
	private static final double TURN_POWER = 0.75;
	
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
		this.getRobot().getDrive().driveSeconds(DRIVE_POWER, 1.2);
		Util.sleep(500);
		this.getRobot().getDrive().rotateSeconds(TURN_POWER * this.getSide(), 0.8);
		Util.sleep(500);
		this.getRobot().getDrive().driveSeconds(DRIVE_POWER, 1.2);
	}
	
	@OpMode(type="Autonomous", name="Auto Mountain [T][R]")
	@Active
	public static class ResQAutoMountainRedTime extends ResQAutoMountainTime {

		@Override
		protected int getSide() {
			return -1;
		}
		
	}
	
	@OpMode(type="Autonomous", name="Auto Mountain [T][B]")
	@Active
	public static class ResQAutoMountainBlueTime extends ResQAutoMountainTime {

		@Override
		protected int getSide() {
			return 1;
		}
		
	}
	
}
