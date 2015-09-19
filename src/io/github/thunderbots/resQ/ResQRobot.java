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

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.hardware.Motor;
import io.github.thunderbots.lightning.hardware.Servo;
import io.github.thunderbots.lightning.robot.Robot;

public class ResQRobot implements Robot {
	
	private Servo bucketTiltServo;
	
	private Motor bucketFingers1;
	private Motor bucketFingers2;
	
	/*
	 * These values are relevant when the bucket dumps to the right. Use their negatives for a left
	 * dump.
	 */
	public static final double BUCKET_TILT_DELTA = 0.22;
	public static final double BUCKET_FINGERS_POWER = 1;

	@Override
	public void initializeRobot() {
		this.bucketTiltServo = Lightning.getServo(null);
		this.bucketFingers1 = Lightning.getMotor(null);
		this.bucketFingers2 = Lightning.getMotor(null);
	}
	
	public void centerBucketServo() {
		this.bucketTiltServo.center();
	}
	
	public void dumpBucketLeft() {
		this.dumpBucket(-1);
	}
	
	public void dumpBucketRight() {
		this.dumpBucket(1);
	}
	
	/*
	 * direction is -1 for left, or +1 for right.
	 */
	private void dumpBucket(int dir) {
		this.bucketTiltServo.move(dir * BUCKET_TILT_DELTA);
		this.bucketFingers1.setPower(dir * BUCKET_FINGERS_POWER);
		this.bucketFingers2.setPower(dir * BUCKET_FINGERS_POWER);
	}

}
