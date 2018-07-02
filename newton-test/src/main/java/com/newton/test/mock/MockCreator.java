package com.newton.test.mock;

import org.mockito.Mockito;

public class MockCreator<M> {

	private final M mock;
	
	private MockCreator(M mock) {
		this.mock = mock;
	}
	
	public static <T> T createBlankMockOf(Class<T> type) {
		return Mockito.mock(type);
	}
	
	public static <T> MockCreator<T> createMockOf(Class<T> type) {
		T mock = Mockito.mock(type);
		return new MockCreator<T>(mock);
	}
	
	public Mocker<M> andConfigureIt() {
		return new Mocker<>(mock);
	}
}
