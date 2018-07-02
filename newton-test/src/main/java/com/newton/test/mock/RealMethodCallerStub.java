package com.newton.test.mock;

import org.mockito.stubbing.OngoingStubbing;

public class RealMethodCallerStub<M, R> extends SingleActionStub<M, R> {

	protected RealMethodCallerStub(Mocker<M> mocker) {
		super(mocker);
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<R> stubbing) {
		stubbing.thenCallRealMethod();
	}

}
