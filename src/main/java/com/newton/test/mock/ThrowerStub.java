package com.newton.test.mock;

import org.mockito.stubbing.OngoingStubbing;

public final class ThrowerStub<M, E extends Throwable> extends SingleActionStub<M, E> {

	private final Class<E> exceptionType;
	
	ThrowerStub(Mocker<M> mocker, Class<E> exceptionType) {
		super(mocker);
		this.exceptionType = exceptionType;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void handleWhenCalling(OngoingStubbing<E> stubbing) {
		stubbing.thenThrow(exceptionType);
	}
}
