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

package io.github.thunderbots.resQ.encoder;

import io.github.thunderbots.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
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
