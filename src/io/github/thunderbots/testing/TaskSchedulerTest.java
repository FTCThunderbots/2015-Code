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

import io.github.thunderbots.lightning.Lightning;
import io.github.thunderbots.lightning.opmode.LightningOpMode;
import io.github.thunderbots.lightning.utility.Util;

public class TaskSchedulerTest extends LightningOpMode {

	private TestRunnable runnableA;
	private TestRunnable runnableB;
	private TestRunnable runnableC;
	
	private static final int DELAY = 4000; // in milliseconds
	
	@Override
	protected void initializeOpMode() {
		this.runnableA = new TestRunnable("A");
		this.runnableB = new TestRunnable("B");
		this.runnableC = new TestRunnable("C");
	}

	/* (non-Javadoc)
	 * 
	 * TaskSchedulerTest.java - tests the task scheduler's ability to register and remove
	 * background tasks.
	 * 
	 * Setup:
	 * 
	 * No hardware is required to run this test. Only the phone software, and any basic
	 * hardware that the phone software requires, is necessesary to run this test.
	 * 
	 * Expected behavior:
	 * 
	 * When the test is started, the following text should appear on the driver station
	 * screen.
	 * 
	 * +-----------+
	 * |           |
	 * |   A : A   |
	 * |   B : B   |
	 * |   C : C   |
	 * |           |
	 * +-----------+
	 * 
	 * The text should appear on the screen for 4 seconds, then the text should disappear.
	 * After the text disappears, the op mode should continue running for an additional
	 * 4 seconds before stopping.
	 * 
	 */
	
	@Override
	protected void main() {
		Lightning.getTaskScheduler().registerTask(this.runnableA);
		Lightning.getTaskScheduler().registerTask(this.runnableB);
		Lightning.getTaskScheduler().registerTask(this.runnableC);
		Util.sleep(DELAY);
		Lightning.getTaskScheduler().removeTask(this.runnableA);
		Lightning.getTaskScheduler().removeTask(this.runnableB);
		Lightning.getTaskScheduler().removeTask(this.runnableC);
		Util.sleep(DELAY);
	}

	public static class TestRunnable implements Runnable {

		private String s;

		public TestRunnable(String s) {
			this.s = s;
		}

		@Override
		public void run() {
			Lightning.sendTelemetryData(this.s, this.s);
		}

	}

}
