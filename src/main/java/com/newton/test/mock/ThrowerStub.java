package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;

import com.newton.test.utils.ArrayBasedList;

public class ThrowerStub<M, E extends Throwable> extends AbstractFunctionHandlingStub<M, Object> {
	
	private final ArrayBasedList<Class<E>> throwables;

	protected ThrowerStub(MockConfiguration<M> configuration, List<Class<E>> initialThrowables) {
		super(configuration);
		this.throwables = new ArrayBasedList<>(initialThrowables);
	}
	
	protected ThrowerStub(MockConfiguration<M> configuration, Class<E> initialThrowable) {
		this(configuration, Arrays.asList(initialThrowable));
	}
	
	public ThrowerStub<M, E> then(Class<E> nextThrowable) {
		throwables.add(nextThrowable);
		return this;
	}

	@Override
	protected void completeStubbing(OngoingStubbing<Object> stub) {
		
		if (throwables.hasOneElement()) {
			stub.thenReturn(throwables.getFirst());
		}
		else {
			stub.thenReturn(throwables.asArray());
		}
	}

}
