package com.newton.test.bdd;

class RunnableStep implements Step {

	private final Runnable runnable;
	
	RunnableStep(Runnable runnable) {
		this.runnable = runnable;
	}

	@Override
	public void execute() {
		runnable.run();
	}
}
