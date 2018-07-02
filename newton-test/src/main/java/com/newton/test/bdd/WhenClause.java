package com.newton.test.bdd;

import java.util.ArrayList;
import java.util.List;

public final class WhenClause extends AbstractTestableClause<WhenClause> {

	WhenClause(List<Step> steps) {
		super(steps);
	}
	
	WhenClause() {
		this(new ArrayList<>());
	}

	@Override
	protected WhenClause getThis() {
		return this;
	}
	
	public ThenClause then(Runnable step) {
		addRunnableStep(step);
		return new ThenClause(getSteps());
	}
}
