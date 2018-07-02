package com.newton.test.mock;

import java.util.function.Function;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

public class ResponderStub<M, R> extends SingleActionStub<M, R> {

	private final Function<InvocationOnMock, R> responseFunction;
	
	ResponderStub(Mocker<M> mocker, Function<InvocationOnMock, R> responseFunction) {
		super(mocker);
		this.responseFunction = responseFunction;
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<R> stubbing) {
		Answer<?> answer = (invocation) -> responseFunction.apply(invocation);
		stubbing.thenAnswer(answer);
	}
}
