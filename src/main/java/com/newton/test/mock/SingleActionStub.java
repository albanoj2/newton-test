package com.newton.test.mock;

import static org.mockito.Mockito.when;

import java.util.function.Function;

import org.mockito.stubbing.OngoingStubbing;

abstract class SingleActionStub<M, R> {

	private final Mocker<M> mocker;
	
	protected SingleActionStub(Mocker<M> mocker) {
		this.mocker = mocker;
	}
	
	public final Mocker<M> whenCalling(Function<M, R> method) {
		handleWhenCalling(when(method.apply(getMock())));
		return mocker;
	}
	
	protected final Mocker<M> getMocker() {
		return mocker;
	}
	
	protected final M getMock() {
		return mocker.getMock();
	}
	
	protected abstract void handleWhenCalling(OngoingStubbing<R> stubbing);
}
