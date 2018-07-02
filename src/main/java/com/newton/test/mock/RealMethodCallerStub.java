package com.newton.test.mock;

import org.mockito.stubbing.OngoingStubbing;

public class RealMethodCallerStub<M, R> extends AbstractFunctionHandlingStub<M, R> {

	protected RealMethodCallerStub(MockConfiguration<M> mocker) {
		super(mocker);
	}
	
	@Override
	protected void completeStubbing(OngoingStubbing<R> stub) {
		stub.thenCallRealMethod();
	}

}
