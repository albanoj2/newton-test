package com.newton.test.mock;

import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.mockito.stubbing.OngoingStubbing;

abstract class AbstractFunctionHandlingStub<M, R> implements FunctionHandlingStub<M, R> {
	
	private final MockConfiguration<M> configuration;
	
	protected AbstractFunctionHandlingStub(MockConfiguration<M> configuration) {
		this.configuration = configuration;
	}

	@Override
	public MockConfiguration<M> whenCalling(Function<M, R> method) {
		OngoingStubbing<R> stub = when(method.apply(getMock()));
		completeStubbing(stub);
		return configuration;
	}
	
	private M getMock() {
		return configuration.getMock();
	}

	protected abstract void completeStubbing(OngoingStubbing<R> stub);
}
