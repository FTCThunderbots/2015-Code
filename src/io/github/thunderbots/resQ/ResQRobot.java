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
	private Motor armBucket;
//	private Motor sweeper;
	private Motor armExtensor;
	
/*	private Servo bucketTilt;
	private Servo blueBucketDoor;
	private Servo redBucketDoor;
	private Servo leftClimberArm;
	private Servo rightClimberArm;
*/	private Servo leftBooper;
	private Servo rightBooper;
	
	private static final double LEG_MOTOR_SPEED = 1.0;
	
	private static final double ARM_BUCKET_ROTATION_SPEED = 1.0;
	
//	private static final double BUCKET_TILT_INCREMENT = 0.02;
	
	/*
	 * 
	 * We find closed position by subtracting 1 by the other buckets closed position.
	 * This sets up the positions of the boopers and buckets
	 * 
	 */
//	private static final double BLUE_BUCKET_DOOR_OPEN_POSITION = 0; 
//	private static final double BLUE_BUCKET_DOOR_CLOSED_POSITION = .6;
	
	private static final double LEFT_BOOPER_OPEN_POSITION = 1;
	private static final double LEFT_BOOPER_CLOSED_POSITION = .45;
	
//	private static final double RED_BUCKET_DOOR_OPEN_POSITION = 1; 
//	private static final double RED_BUCKET_DOOR_CLOSED_POSITION = .4;
	
	private static final double RIGHT_BOOPER_OPEN_POSITION = 0;
	private static final double RIGHT_BOOPER_CLOSED_POSITION = .45;
	
	private static final double ENCODER_TICKS_PER_DRIVE_INCH = 131.25;
	private static final double ENCODER_TICKS_PER_ROTATION_DEGREE = 131.25;
	
	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	public void initializeRobot() {
		this.leftLeg = Lightning.getMotor("left_leg");
		this.rightLeg = Lightning.getMotor("right_leg");
//		this.sweeper = Lightning.getMotor("sweeper");
		this.armBucket = Lightning.getMotor("arm_bucket");
		this.armExtensor = Lightning.getMotor("arm_extensor");
//		this.bucketTilt = Lightning.getServo("bucket_tilt");
//		this.blueBucketDoor = Lightning.getServo("left_bucket");
//		this.redBucketDoor = Lightning.getServo("right_bucket");
//		this.leftClimberArm = Lightning.getServo("climber_arm_left");
//		this.rightClimberArm = Lightning.getServo("climber_arm_right");
		this.leftBooper = Lightning.getServo("left_booper");
		this.rightBooper = Lightning.getServo("right_booper");
		
		//These values tested and accurate as of December 9, 2015
		this.getDrive().setEncoderTicksPerDriveInch(ENCODER_TICKS_PER_DRIVE_INCH);
		this.getDrive().setEncoderTicksPerRotationDegree(ENCODER_TICKS_PER_ROTATION_DEGREE);
		

	}
	
	/*
	 * Walking methods (legs)
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
	 * Sweeper method
	 */
	
/*	public void moveSweeper(int pow) {
		this.sweeper.setPower(pow);
	}
*/	
	/*
	 * Arm bucket rotation methods
	 */
	
	public void armBucketFoward() {
		this.setArmBucketRotation(-ARM_BUCKET_ROTATION_SPEED);
	}
	
	public void stopArmBucketRotation() {
		this.setArmBucketRotation(0);
	}
	
	private void setArmBucketRotation(double pow) {
		this.armBucket.setPower(pow);
	}
	
	public void setArmBucketPositionDefault() {
		if(armBucket.getEncoder().getPosition() < 0) {
			this.setArmBucketRotation(ARM_BUCKET_ROTATION_SPEED);
		}
	}
	
	/**
	 * Extends or retracts the arm, based off of it's power
	 * @param pow
	 */
	public void moveArmExtensor(double pow) {
		this.armExtensor.setPower(pow);
	}
	
	/*
	 * Bucket tilting methods
	 */
	
/*	public void tiltBucketCW() {
		this.tiltBucket(1);
	}
	
	public void tiltBucketCCW() {
		this.tiltBucket(-1);
	}
	
	private void tiltBucket(int direction) {
		this.bucketTilt.move(BUCKET_TILT_INCREMENT * direction);
	}
*/
	
	/*
	 * Setting up methods for movement that will be binded in ResQTeleOp to a button on a controller
	 */
	
/*	public void openBlueBucketDoor() {
		this.blueBucketDoor.moveToPosition(BLUE_BUCKET_DOOR_OPEN_POSITION);
	}
	
	public void closeBlueBucketDoor() {
		this.blueBucketDoor.moveToPosition(BLUE_BUCKET_DOOR_CLOSED_POSITION);
	}
	
	public void openRedBucketDoor() {
		this.redBucketDoor.moveToPosition(RED_BUCKET_DOOR_OPEN_POSITION);
	}
	
	public void closeRedBucketDoor() {
		this.redBucketDoor.moveToPosition(RED_BUCKET_DOOR_CLOSED_POSITION);
	}
*/
	
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
	
/*	public void moveBucket(int pos) {
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
*/
}
