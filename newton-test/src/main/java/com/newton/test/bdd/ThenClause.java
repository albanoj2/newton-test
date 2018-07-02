package com.newton.test.bdd;

import java.util.List;

public class ThenClause extends AbstractTestableClause<ThenClause> {

	protected ThenClause(List<Step> steps) {
		super(steps);
	}

	@Override
	protected ThenClause getThis() {
		return this;
	}
}
