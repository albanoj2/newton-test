package com.newton.test.mock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.newton.test.Value;

public final class Arguments {

	private final List<Value> arguments;
	
	public static Arguments from(Object[] arguments) {
		return new Arguments(arguments);
	}
	
	private Arguments(Object[] arguments) {
		this.arguments = Arrays.asList(arguments)
			.stream()
			.map((Object arg) -> new Value(arg))
			.collect(Collectors.toList());
	}
	
	public final Value at(int index) {
		return arguments.get(index);
	}
}
