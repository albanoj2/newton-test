package com.newton.test.bdd;

import java.util.List;

abstract class AbstractTestableClause<T extends Clause<T>> extends AbstractClause<T> implements TestableClause {

	protected AbstractTestableClause(List<Step> steps) {
		super(steps);
	}

	@Override
	public void test() {
		executeSteps();
	}
}
