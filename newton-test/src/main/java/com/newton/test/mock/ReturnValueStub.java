package com.newton.test.mock;

import org.mockito.stubbing.OngoingStubbing;

public final class ReturnValueStub<M, R> extends SingleActionStub<M, R> {
	
	private final R value;
	
	ReturnValueStub(Mocker<M> mocker, R value) {
		super(mocker);
		this.value = value;
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<R> stubbing) {
		stubbing.thenReturn(value);
	}
}
