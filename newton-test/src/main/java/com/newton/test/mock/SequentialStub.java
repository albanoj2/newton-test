package com.newton.test.mock;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.function.Function;

import org.mockito.stubbing.OngoingStubbing;

public abstract class SequentialStub<M, R, V> {

	private final Mocker<M> mocker;
	private final List<V> values;

	protected SequentialStub(Mocker<M> mocker, List<V> values) {
		this.mocker = mocker;
		this.values = values;
	}
	
	protected final Mocker<M> getMocker() {
		return mocker;
	}
	
	protected final M getMock() {
		return mocker.getMock();
	}
	
	public final SequentialStub<M, R, V> then(V value) {
		addValue(value);
		return createSequentialStub(mocker, values);
	}
	
	protected abstract SequentialStub<M, R, V> createSequentialStub(Mocker<M> mocker, List<V> values);
	
	public final Mocker<M> whenCalling(Function<M, R> method) {
		handleWhenCalling(when(method.apply(getMock())));
		return mocker;
	}
	
	protected abstract void handleWhenCalling(OngoingStubbing<R> stubbing);
	
	protected final V firstValue() {
		return values.get(0);
	}
	
	@SuppressWarnings("unchecked")
	protected final V[] remainingValuesAsArray() {
		List<V> remainingValues = values.subList(0, values.size());
		return (V[]) remainingValues.toArray();
	}
	
	@SuppressWarnings("unchecked")
	protected final V[] valuesAsArray() {
		return (V[]) values.toArray();
	}
	
	protected final void addValue(V value) {
		values.add(value);
	}
	
	protected final List<V> getValues() {
		return values;
	}
}
