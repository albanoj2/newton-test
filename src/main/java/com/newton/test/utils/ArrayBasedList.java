package com.newton.test.utils;

import java.util.Arrays;
import java.util.List;

public class ArrayBasedList<T> {

	private final List<T> elements;
	
	@SafeVarargs
	public ArrayBasedList(T... initialValues) {
		this.elements = Arrays.asList(initialValues);
	}
	
	public ArrayBasedList(List<T> initialValues) {
		this.elements = initialValues;
	}
	
	public void add(T element) {
		elements.add(element);
	}
	
	public List<T> asList() {
		return elements;
	}
	
	public T getFirst() {
		return elements.get(0);
	}
	
	public boolean hasOneElement() {
		return elements.size() == 1;
	}

	@SuppressWarnings("unchecked")
	public T[] getAfterFirstAsArray() {
		List<T> remainingReturnValues = elements.subList(0, elements.size());
		return (T[]) remainingReturnValues.toArray();
	}
	
	@SuppressWarnings("unchecked")
	public T[] asArray() {
		return (T[]) elements.toArray();
	}
}
