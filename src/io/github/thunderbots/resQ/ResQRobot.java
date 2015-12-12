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

public class ResQRobot extends Robot {
	
	private Motor leftLeg;
	private Motor rightLeg;
	private Motor scoringArm;
	private Motor sweeper;
	
	private Servo bucketTilt;
	private Servo blueBucketDoor;
	private Servo redBucketDoor;
	private Servo leftClimberArm;
	private Servo rightClimberArm;
	private Servo leftBooper;
	private Servo rightBooper;
	
	
	private static final double LEG_MOTOR_SPEED = 1.0;
	
	private static final double BUCKET_TILT_INCREMENT = 0.02;
	
	// These values are calculated for the blue side
	// TODO set these values
	private static final double BLUE_BUCKET_DOOR_OPEN_POSITION = 0; 
	private static final double BLUE_BUCKET_DOOR_CLOSED_POSITION = 1;
	
	private static final double LEFT_BOOPER_OPEN_POSITION = 0;
	private static final double LEFT_BOOPER_CLOSED_POSITION = 1;
	
	private static final double RED_BUCKET_DOOR_OPEN_POSITION = 0; 
	private static final double RED_BUCKET_DOOR_CLOSED_POSITION = 1;
	
	private static final double RIGHT_BOOPER_OPEN_POSITION = 1;
	private static final double RIGHT_BOOPER_CLOSED_POSITION = 0;
	
	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	public void initializeRobot() {
		this.leftLeg = Lightning.getMotor("left_leg");
		this.rightLeg = Lightning.getMotor("right_leg");
		this.scoringArm = Lightning.getMotor("scoring_arm");
		this.sweeper = Lightning.getMotor("sweeper");
		this.bucketTilt = Lightning.getServo("bucket_tilt");
		this.blueBucketDoor = Lightning.getServo("left_bucket");
		this.redBucketDoor = Lightning.getServo("right_bucket");
		this.leftClimberArm = Lightning.getServo("climber_arm_left");
		this.rightClimberArm = Lightning.getServo("climber_arm_right");
		this.leftBooper = Lightning.getServo("left_booper");
		this.rightBooper = Lightning.getServo("right_booper");
		//These values tested and accurate as of December 9, 2015
		this.getDrive().setEncoderTicksPerDriveInch(131.25);
		this.getDrive().setEncoderTicksPerRotationDegree(11.94);
		
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}
	
	/*
	 * Walking stuff
	 */
	
	public void walkForward() {
		this.setLegPower(LEG_MOTOR_SPEED);
	}
	
	public void walkBackward() {
		this.setLegPower(-LEG_MOTOR_SPEED);
	}
	
	public void stopWalking() {
		this.setLegPower(0);
	}
	
	private void setLegPower(double pow) {
		this.leftLeg.setPower(pow);
		this.rightLeg.setPower(pow);
	}
	
	/*
	 * Bucket tilt stuff
	 */
	
	public void tiltBucketCW() {
		this.tiltBucket(1);
	}
	
	public void tiltBucketCCW() {
		this.tiltBucket(-1);
	}
	
	private void tiltBucket(int direction) {
		this.bucketTilt.move(BUCKET_TILT_INCREMENT * direction);
	}
	
	/*
	 * Bucket door opening/closing
	 */
	
	public void openBlueBucketDoor() {
		this.blueBucketDoor.moveToPosition(BLUE_BUCKET_DOOR_OPEN_POSITION);
	}
	
	public void closeBlueBucketDoor() {
		this.blueBucketDoor.moveToPosition(BLUE_BUCKET_DOOR_CLOSED_POSITION);
	}
	
	public void openRedBucketDoor() {
		this.redBucketDoor.moveToPosition(Servo.MAX_POSITION
				- RED_BUCKET_DOOR_OPEN_POSITION);
	}
	
	public void closeRedBucketDoor() {
		this.redBucketDoor.moveToPosition(Servo.MAX_POSITION
				- RED_BUCKET_DOOR_CLOSED_POSITION);
	}
	
	public void openLeftBooper() {
		this.leftBooper.moveToPosition(LEFT_BOOPER_OPEN_POSITION);
	}
	
	public void openRightBooper() {
		this.rightBooper.moveToPosition(RIGHT_BOOPER_OPEN_POSITION);
	}
	
	public void closeLeftBooper() {
		this.leftBooper.moveToPosition(LEFT_BOOPER_CLOSED_POSITION);
	}
	
	public void closeRightBooper() {
		this.rightBooper.moveToPosition(RIGHT_BOOPER_CLOSED_POSITION);
	}
	
	/*
	 * Old, outdated stuff
	 */
	
	public void moveScoringArm(double pow) {
		this.scoringArm.setPower(pow);
	}
	
	public void moveBucket(int pos) {
		if (pos == -1)
			this.bucketTilt.moveToPosition(0);
		else if (pos == 0)
			this.bucketTilt.moveToPosition(0.5);
		else
			this.bucketTilt.moveToPosition(1);
	}
	
	public void moveLeftClimberArm(int pos) {
		this.leftClimberArm.moveToPosition(pos);
		
	}
	public void moveRightClimberArm(int pos) {
		this.rightClimberArm.moveToPosition(pos);
	}
	
	public void moveSweeper(int pow) {
		this.sweeper.setPower(pow);
	}

}
