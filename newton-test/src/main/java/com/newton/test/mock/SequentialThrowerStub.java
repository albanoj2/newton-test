package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;

public final class SequentialThrowerStub<M, E extends Throwable> extends SequentialStub<M, E, Class<E>> {
	
	SequentialThrowerStub(Mocker<M> mocker, List<Class<E>> values) {
		super(mocker, values);
	}
	
	@SafeVarargs
	SequentialThrowerStub(Mocker<M> mocker, Class<E>... values) {
		this(mocker, Arrays.asList(values));
	}

	@Override
	protected void handleWhenCalling(OngoingStubbing<E> stubbing) {
		stubbing.thenThrow(valuesAsArray());
	}

	@Override
	protected SequentialStub<M, E, Class<E>> createSequentialStub(Mocker<M> mocker, List<Class<E>> values) {
		return new SequentialThrowerStub<M, E>(mocker, values);
	}
}
