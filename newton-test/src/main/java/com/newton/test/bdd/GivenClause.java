package com.newton.test.bdd;

import java.util.ArrayList;

public final class GivenClause extends AbstractClause<GivenClause> {
	
	GivenClause() {
		super(new ArrayList<>());
	}

	public WhenClause when(Runnable step) {
		addRunnableStep(step);
		return new WhenClause(getSteps());
	}

	@Override
	protected GivenClause getThis() {
		return this;
	}
}
