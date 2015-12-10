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
import io.github.thunderbots.lightning.hardware.Servo;
import io.github.thunderbots.lightning.robot.Robot;

public class ResQRobot extends Robot {
	
//	private Motor leftLeg;
//	private Motor rightLeg;
//	private Motor scoringArm;
	
	private Servo bucketTilt;
//	private Servo leftBucketDoor;
//	private Servo rightBucketDoor;
	private Servo climberArm;
	
	private static double LEG_MOTOR_SPEED = 1.0;
	
	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	public void initializeRobot() {
//		this.leftLeg = Lightning.getMotor("left_leg");
//		this.rightLeg = Lightning.getMotor("right_leg");
//		this.scoringArm = Lightning.getMotor("scoring_arm");
		this.bucketTilt = Lightning.getServo("bucket_tilt");
//		this.leftBucketDoor = Lightning.getServo("left_bucket");
//		this.rightBucketDoor = Lightning.getServo("right_bucket");
		this.climberArm = Lightning.getServo("climber_arm");
		// These values tested and accurate as of December 9
		this.getDrive().setEncoderTicksPerDriveInch(131.25);
		this.getDrive().setEncoderTicksPerRotationDegree(11.94);
		
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}
	
	private void setLegPower(double pow) {
//		this.leftLeg.setPower(pow);
//		this.rightLeg.setPower(pow);
	}
	
	public void walkForward() {
		this.setLegPower(LEG_MOTOR_SPEED);
	}
	
	public void walkBackward() {
		this.setLegPower(-LEG_MOTOR_SPEED);
	}
	
	public void stopWalking() {
		this.setLegPower(0);
	}
	
	public void moveScoringArm(double pow) {
//		this.scoringArm.setPower(pow);
	}
	
	public void moveBucket(int pos) {
		if (pos == -1)
			this.bucketTilt.moveToPosition(0);
		else if (pos == 0)
			this.bucketTilt.moveToPosition(0.5);
		else
			this.bucketTilt.moveToPosition(1);
	}
	
	public void moveClimberArm(int pos) {
		this.climberArm.moveToPosition(pos);
	}

}
