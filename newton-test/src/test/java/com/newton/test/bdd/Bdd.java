package com.newton.test.bdd;

import static com.newton.test.bdd.Clauses.given;

import com.newton.test.mock.MockCreator;
import com.newton.test.mock.Mocker;

public class Bdd {
	
	public void setUp() {
		Bdd bdd = MockCreator.createMockOf(Bdd.class)
			.andConfigureIt()
			.toReturnOnFirstCall("something")
				.then("foo")
				.then("bar")
				.whenCalling(mock -> mock.doSomething())
			.toReturn("foo").whenCalling(mock -> mock.doSomething())
			.toExecuteRealMethod().whenCalling(mock -> mock.doSomething())
			.toRespondToArgumentsWith(arguments -> "foo").whenCalling(mock -> mock.doSomething())
			.done();
		
		Mocker.configure(bdd)
			.toExecuteRealMethod().whenCalling(mock -> mock.doSomething())
			.done();
	}

	public void simpleChain() {
		given(this::tenAvailableCars)
			.and(this::customerHasEnoughCash)
		.when(() -> buyCarFirstAvailableCar(1000))
		.then(this::nineAvailableCars)
		.test();
	}
	
	private void tenAvailableCars() {}
	private void customerHasEnoughCash() {}
	private void buyCarFirstAvailableCar(int dollars) {}
	private void nineAvailableCars() {}
	
	public String doSomething() {
		return "Hello, world";
	}
}
