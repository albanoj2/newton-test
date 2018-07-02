package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;

import org.mockito.stubbing.OngoingStubbing;

import com.newton.test.utils.ArrayBasedList;

public final class ReturnValueStub<M, R> extends AbstractFunctionHandlingStub<M, R> {
	
	private final ArrayBasedList<R> returnValues;

	protected ReturnValueStub(MockConfiguration<M> configuration, R initialReturnValue) {
		this(configuration, Arrays.asList(initialReturnValue));
	}
	
	protected ReturnValueStub(MockConfiguration<M> configuration, List<R> initialReturnValues) {
		super(configuration);
		this.returnValues = new ArrayBasedList<>(initialReturnValues);
	}
	
	public ReturnValueStub<M, R> then(R nextReturnValue) {
		returnValues.add(nextReturnValue);
		return this;
	}

	@Override
	protected void completeStubbing(OngoingStubbing<R> stub) {
		
		if (returnValues.hasOneElement()) {
			stub.thenReturn(returnValues.getFirst());
		}
		else {
			stub.thenReturn(returnValues.getFirst(), returnValues.getAfterFirstAsArray());
		}
	}
}
