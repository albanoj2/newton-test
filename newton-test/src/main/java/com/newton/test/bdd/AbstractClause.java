package com.newton.test.bdd;

import java.util.List;

abstract class AbstractClause<T extends Clause<T>> implements Clause<T> {

	private final List<Step> steps;
	
	protected AbstractClause(List<Step> steps) {
		this.steps = steps;
	}

	protected final void executeSteps() {
		steps.forEach(step -> step.execute());
	}

	@Override
	public T and(Runnable step) {
		addRunnableStep(step);
		return getThis();
	}
	
	protected abstract T getThis();
	
	protected final void addStep(Step step) {
		steps.add(step);
	}
	
	protected final void addRunnableStep(Runnable step) {
		addStep(new RunnableStep(step));
	}
	
	protected final List<Step> getSteps() {
		return steps;
	}
}
