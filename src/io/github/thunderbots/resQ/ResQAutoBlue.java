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

package io.github.thunderbots.resQ;

import io.github.thunderbots.lightning.annotation.OpMode;
import io.github.thunderbots.lightning.opmode.Autonomous;
import io.github.thunderbots.robotInOneWeek.Ri1WRobot;

@OpMode(type="Autonomous", name="ResQ")
public class ResQAutoBlue extends Autonomous {
	
	@Override
	protected Ri1WRobot getRobot() {
		return (Ri1WRobot) super.getRobot();
	}
	
	@Override
	protected void initializeLightning() {
		this.setRobot(new Ri1WRobot());
		this.getRobot().initializeRobot();
	}

	@Override
	protected void main() {
		this.getRobot().getDrive().driveSeconds(.5, 3);
		this.getRobot().getDrive().waitAndStop(1.0);
		this.getRobot().getDrive().rotateSeconds(-.5, 3);
		this.getRobot().getDrive().waitAndStop(1.0);
		this.getRobot().getDrive().driveSeconds(.5, 6);
		this.getRobot().getDrive().waitAndStop(1.0);
	}

}
