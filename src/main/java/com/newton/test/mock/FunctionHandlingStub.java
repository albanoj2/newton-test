package com.newton.test.mock;

import java.util.function.Function;

public interface FunctionHandlingStub<M, R> {
	public MockConfiguration<M> whenCalling(Function<M, R> method);
}
