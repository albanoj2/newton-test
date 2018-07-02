package com.newton.test.mock;

import java.util.function.Function;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

public class ArgumentsResponderStub<M, R> extends SingleActionStub<M, R> {

	private final Function<Arguments, R> responseFunction;
	
	ArgumentsResponderStub(Mocker<M> mocker, Function<Arguments, R> responseFunction) {
		super(mocker);
		this.responseFunction = responseFunction;
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<R> stubbing) {
		
		Answer<?> answer = (invocation) -> {
			Object[] rawArguments = invocation.getArguments();
			return responseFunction.apply(Arguments.from(rawArguments));
		};
		
		stubbing.thenAnswer(answer);
	}
}
