package com.newton.test.bdd;

public interface Clause<T extends Clause<T>> {
	public T and(Runnable step);
}
