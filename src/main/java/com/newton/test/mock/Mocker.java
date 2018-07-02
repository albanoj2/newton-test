package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.mockito.invocation.InvocationOnMock;

public final class Mocker<M> {

	private final M mock;
	
	Mocker(M mock) {
		this.mock = mock;
	}
	
	public static <T> Mocker<T> configure(T mock) {
		return new Mocker<>(mock);
	}

	M getMock() {
		return mock;
	}
	
	public <R> ReturnValueStub<M, R> toReturn(R value) {
		return new ReturnValueStub<>(this, value);	
	}
	
	public <R> SequentialStub<M, R, R> toReturnOnFirstCall(R value) {
		return new SequentialReturnValueStub<>(this, value);	
	}
	
	@SuppressWarnings("unchecked")
	public <R> SequentialReturnValueStub<M, R> toSeqentiallyReturn(R firstValue, R... values) {
		List<R> sequentialValues = (List<R>) Arrays.asList(firstValue, values);
		return new SequentialReturnValueStub<>(this, sequentialValues);	
	}
	
	public <E extends Throwable> ThrowerStub<M, E> toThrow(Class<E> throwableType) {
		return new ThrowerStub<>(this, throwableType);	
	}
	
	public <E extends Throwable> SequentialStub<M, E, Class<E>> toThrowOnFirstCall(Class<E> throwableType) {
		return new SequentialThrowerStub<>(this, throwableType);	
	}
	
	@SuppressWarnings("unchecked")
	public <E extends Throwable> SequentialThrowerStub<M, E> toSequentiallyThrow(Class<E>... throwables) {
		return new SequentialThrowerStub<M, E>(this, Arrays.asList(throwables));	
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
	
	public M done() {
		return mock;
	}
}
