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

public class TaskSchedulerTest extends LightningOpMode {

	@Override
	protected void initializeOpMode() {
		Lightning.getTaskScheduler().registerTask(new TestRunnable("A"));
		Lightning.getTaskScheduler().registerTask(new TestRunnable("B"));
		Lightning.getTaskScheduler().registerTask(new TestRunnable("C"));
		
	}

	@Override
	protected void main() {
		TestRunnable runnableA = new TestRunnable("A");
		TestRunnable runnableB = new TestRunnable("B");
		TestRunnable runnableC = new TestRunnable("C");
		//references to each of the test runnables
		Lightning.getTaskScheduler().registerTask(runnableA);
		Lightning.getTaskScheduler().registerTask(runnableB);
		Lightning.getTaskScheduler().registerTask(runnableC);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Lightning.getTaskScheduler().removeTask(runnableA);
		Lightning.getTaskScheduler().removeTask(runnableB);
		Lightning.getTaskScheduler().removeTask(runnableC);
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
