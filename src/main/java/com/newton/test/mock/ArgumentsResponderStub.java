package com.newton.test.mock;

import java.util.function.Function;

import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

public class ArgumentsResponderStub<M, R> extends AbstractFunctionHandlingStub<M, R> {

	private final Function<Arguments, R> responseFunction;
	
	ArgumentsResponderStub(MockConfiguration<M> mocker, Function<Arguments, R> responseFunction) {
		super(mocker);
		this.responseFunction = responseFunction;
	}

	@Override
	protected void completeStubbing(OngoingStubbing<R> stub) {

		Answer<?> answer = (invocation) -> {
			Object[] rawArguments = invocation.getArguments();
			return responseFunction.apply(Arguments.from(rawArguments));
		};
		
		stub.thenAnswer(answer);
	}
}
