package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;

public final class SequentialReturnValueStub<M, R> extends SequentialStub<M, R, R> {
	
	SequentialReturnValueStub(Mocker<M> mocker, List<R> values) {
		super(mocker, values);
	}
	
	@SafeVarargs
	SequentialReturnValueStub(Mocker<M> mocker, R... values) {
		this(mocker, Arrays.asList(values));
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<R> stubbing) {
		stubbing.thenReturn(firstValue(), remainingValuesAsArray());
	}

	@Override
	protected SequentialStub<M, R, R> createSequentialStub(Mocker<M> mocker, List<R> values) {
		return new SequentialReturnValueStub<M, R>(mocker, values);
	}
}
