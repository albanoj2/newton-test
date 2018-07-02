package com.newton.test.mock;

import java.util.function.Function;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

public class ResponderStub<M, R> extends AbstractFunctionHandlingStub<M, R> {

	private final Function<InvocationOnMock, R> responseFunction;
	
	ResponderStub(MockConfiguration<M> mocker, Function<InvocationOnMock, R> responseFunction) {
		super(mocker);
		this.responseFunction = responseFunction;
	}
	
	@Override
	protected void completeStubbing(OngoingStubbing<R> stub) {
		Answer<?> answer = (invocation) -> responseFunction.apply(invocation);
		stub.thenAnswer(answer);
	}
}
