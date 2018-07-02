package com.newton.test.bdd;

public final class Clauses {

	private Clauses() {}
	
	public static GivenClause given(Runnable step) {
		GivenClause clause = new GivenClause();
		clause.addRunnableStep(step);
		return clause;
	}
	
	public static WhenClause when(Runnable step) {
		WhenClause clause = new WhenClause();
		clause.addRunnableStep(step);
		return clause;
	}
}
