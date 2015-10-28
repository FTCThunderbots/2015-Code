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
		while (this.opModeIsActive()) {
			// repeat
		}
	}
	
	public static class TestRunnable implements Runnable {
		
		private String s;
		
		public TestRunnable(String s) {
			this.s = s;
		}
		
		@Override
		public void run() {
			Lightning.sendTelemetryData(s);
		}
		
	}

}
