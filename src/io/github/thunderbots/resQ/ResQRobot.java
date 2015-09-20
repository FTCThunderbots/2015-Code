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
	
	private Motor sweeper;
	
	private Servo bucketTiltServo;
	
	/**
	 * <pre>
	 * Boop the
	 *    _
	 *   / \
	 *   |O|
	 *    Y
	 *    |
	 *   / \
	 *  /   \
	 *  
	 *  THESE
	 *  </pre>
	 */
	private Servo leftBooperServo;
	private Servo rightBooperServo;
	
	private boolean isLeftBooping;
	private boolean isRightBooping;
	
//	private Motor bucketFingers1;
//	private Motor bucketFingers2;
	
	public static final String SWEEPER_NAME = "sweeper";
	public static final String BUCKET_TILT_SERVO_NAME = "bucket_tilt";
	public static final String[] BOOPER_SERVO_NAMES = {"left_booper", "right_booper"};
	public static final String[] BUCKET_FINGERS_NAMES = {"fingers1", "fingers2"};
	
	public static final double BOOPER_DOWN = 0.13;
	public static final double BOOPER_UP = 0.82;
	
	/*
	 * These values are relevant when the bucket dumps to the right. Use their negatives for a left
	 * dump.
	 */
	public static final double BUCKET_TILT_DELTA = 0.15;
	public static final double BUCKET_FINGERS_POWER = 1;

	@Override
	public void initializeRobot() {
		this.sweeper = Lightning.getMotor(SWEEPER_NAME);
		this.bucketTiltServo = Lightning.getServo(BUCKET_TILT_SERVO_NAME);
		this.leftBooperServo = Lightning.getServo(BOOPER_SERVO_NAMES[0]);
		this.rightBooperServo = Lightning.getServo(BOOPER_SERVO_NAMES[1]);
		this.unboopLeft();
		this.unboopRight();
		this.centerBucket();
//		this.bucketFingers1 = Lightning.getMotor(BUCKET_FINGERS_NAMES[0]);
//		this.bucketFingers2 = Lightning.getMotor(BUCKET_FINGERS_NAMES[1]);
	}
	
	public void addDebugInformation() {
		Lightning.sendTelemetryData("Sweeper", this.sweeper.getPower());
		Lightning.sendTelemetryData("Bucket", this.bucketTiltServo.getPosition());
		Lightning.sendTelemetryData("Left boop", this.leftBooperServo.getPosition());
		Lightning.sendTelemetryData("Right boop", this.rightBooperServo.getPosition());
//		Lightning.sendTelemetryData("Fingers 1", this.bucketFingers1.getPower());
//		Lightning.sendTelemetryData("Fingers 2", this.bucketFingers2.getPower());
	}
	
	/*
	 * +--------------------------+
	 * |       Sweeper motor      |
	 * +--------------------------+
	 */
	
	public void setSweeperPower(double power) {
		this.sweeper.setPower(power);
	}
	
	/*
	 * +---------------------------+
	 * |       Boop the THESE      |
	 * +---------------------------+
	 */
	
	public void toggleLeftBooper() {
		if (this.isLeftBooping) {
			this.unboopLeft();
		} else {
			this.boopLeft();
		}
	}
	
	public void boopLeft() {
		this.leftBooperServo.moveToPosition(Servo.MAX_POSITION - BOOPER_DOWN);
		this.isLeftBooping = true;
	}
	
	public void unboopLeft() {
		this.leftBooperServo.moveToPosition(Servo.MAX_POSITION - BOOPER_UP);
		this.isLeftBooping = false;
	}
	
	public void toggleRightBooper() {
		if (this.isRightBooping) {
			this.unboopRight();
		} else {
			this.boopRight();
		}
	}
	
	public void boopRight() {
		this.rightBooperServo.moveToPosition(BOOPER_DOWN);
		this.isRightBooping = true;
	}
	
	public void unboopRight() {
		this.rightBooperServo.moveToPosition(BOOPER_UP);
		this.isRightBooping = false;
	}
	
	/*
	 * +---------------------------+
	 * |    Bucket tilting stuff   |
	 * +---------------------------+
	 */
	
	/**
	 * Re-centers the bucket.
	 */
	public void centerBucket() {
		this.bucketTiltServo.center();
	}
	
	/**
	 * Dumps the bucket to the left.
	 */
	public void dumpBucketLeft() {
		this.dumpBucket(-1);
	}
	
	/**
	 * Dumps the bucket to the right.
	 */
	public void dumpBucketRight() {
		this.dumpBucket(1);
	}
	
	/**
	 * Dumps the center bucket in the given direction.
	 *
	 * @param dir -1 if the bucket should dump to the left, or +1 if the bucket should dump to the right.
	 */
	private void dumpBucket(int dir) {
		this.bucketTiltServo.move(dir * BUCKET_TILT_DELTA);
//		this.bucketFingers1.setPower(dir * BUCKET_FINGERS_POWER);
//		this.bucketFingers2.setPower(dir * BUCKET_FINGERS_POWER);
	}
	
}
