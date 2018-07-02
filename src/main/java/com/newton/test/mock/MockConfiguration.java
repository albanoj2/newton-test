package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.mockito.invocation.InvocationOnMock;

public final class MockConfiguration<M> {

	private final M mock;
	
	MockConfiguration(M mock) {
		this.mock = mock;
	}
	
	public static <T> MockConfiguration<T> configure(T mock) {
		return new MockConfiguration<>(mock);
	}

	M getMock() {
		return mock;
	}
	
	public <R> ReturnValueStub<M, R> toReturn(R value) {
		return new ReturnValueStub<>(this, value);	
	}
	
	public <R> ReturnValueStub<M, R> toReturnOnFirstCall(R value) {
		return new ReturnValueStub<>(this, value);	
	}
	
	@SuppressWarnings("unchecked")
	public <R> ReturnValueStub<M, R> toSeqentiallyReturn(R firstValue, R... values) {
		List<R> sequentialValues = (List<R>) Arrays.asList(firstValue, values);
		return new ReturnValueStub<>(this, sequentialValues);	
	}
	
	public <E extends Throwable> ThrowerStub<M, E> toThrow(Class<E> throwableType) {
		return new ThrowerStub<>(this, throwableType);	
	}
	
	public <E extends Throwable> ThrowerStub<M, E> toThrowOnFirstCall(Class<E> throwableType) {
		return new ThrowerStub<>(this, throwableType);	
	}
	
	@SuppressWarnings("unchecked")
	public <E extends Throwable> ThrowerStub<M, E> toSequentiallyThrow(Class<E>... throwables) {
		return new ThrowerStub<M, E>(this, Arrays.asList(throwables));	
	}
	
	public <R> ResponderStub<M, R> toRespondWith(Function<InvocationOnMock, R> response) {
		return new ResponderStub<M, R>(this, response);	
	}
	
	public <R> ArgumentsResponderStub<M, R> toRespondToArgumentsWith(Function<Arguments, R> handler) {
		return new ArgumentsResponderStub<M, R>(this, handler);	
	}
	
	public <R> RealMethodCallerStub<M, R> toExecuteRealMethod() {
		return new RealMethodCallerStub<>(this);
	}
	
	public M andGetMock() {
		return mock;
	}
}
