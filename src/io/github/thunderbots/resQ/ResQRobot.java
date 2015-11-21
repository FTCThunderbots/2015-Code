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
	
	private Servo leftBooper;
	private Servo rightBooper;
	
	private Motor peopleCRServo; // cr servo
	
	private static double BOOPER_UP_POSITION = .13;
	private static double BOOPER_DOWN_POSITION = .82;
	
	private static double LEG_MOTOR_SPEED = 1.0;
	private static double PEOPLE_SERVO_SPEED = 0.5;
	
	@Override
	public String[] getDriveMotorNames() {
		return new String[] {"front_left", "front_right", "back_left", "back_right"};
	}

	@Override
	public void initializeRobot() {
		this.leftLeg = Lightning.getMotor("left_leg");
		this.rightLeg = Lightning.getMotor("right_leg");
		this.leftBooper = Lightning.getServo("left_booper");
		this.rightBooper = Lightning.getServo("right_booper");
		this.peopleCRServo = Lightning.getMotor("people");
		
		Lightning.getMotor("front_left").setReversed(true);
		Lightning.getMotor("front_right").setReversed(true);
	}
	
	private void setLegPower(double pow) {
		this.leftLeg.setPower(pow);
		this.rightLeg.setPower(pow);
	}
	
	public void walkForward() {
		this.setLegPower(LEG_MOTOR_SPEED);
	}
	
	public void walkBackward() {
		this.setLegPower(-1 * LEG_MOTOR_SPEED);
	}
	
	public void stopWalking() {
		this.setLegPower(0);
	}
	
	/**
	 * Engages the left booper servo.
	 */
	public void boopLeft() {
		this.leftBooper.moveToPosition(BOOPER_UP_POSITION);
	}
	
	/**
	 * Disengages the left booper servo.
	 */
	public void unboopLeft() {
		this.leftBooper.moveToPosition(BOOPER_DOWN_POSITION);
	}
	
	/**
	 * Engages the right booper servo.
	 */
	public void boopRight() {
		this.rightBooper.moveToPosition(BOOPER_UP_POSITION);
	}
	
	/**
	 * Disengages the right booper servo.
	 */
	public void unboopRight() {
		this.rightBooper.moveToPosition(BOOPER_DOWN_POSITION);
	}
	
	public void extendPeople() {
		this.peopleCRServo.setPower(PEOPLE_SERVO_SPEED);
	}
	
	public void retractPeople() {
		this.peopleCRServo.setPower(-PEOPLE_SERVO_SPEED);
	}
	
	public void stopMovingPeople() {
		this.peopleCRServo.stop();
	}

}
