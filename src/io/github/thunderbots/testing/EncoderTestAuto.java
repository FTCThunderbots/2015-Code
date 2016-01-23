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

package io.github.thunderbots.testing;

import io.github.thunderbots.lightning.annotation.OpMode;
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
