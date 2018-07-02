package com.newton.test;

import java.util.List;
import java.util.Map;

public final class Value {

	private final Object value;
	
	public Value(Object value) {
		this.value = value;
	}
	
	public byte asByte() {
		return (byte) value;
	}
	
	public char asChar() {
		return (char) value;
	}
	
	public short asShort() {
		return (short) value;
	}
	
	public int asInt() {
		return (int) value;
	}
	
	public long asLong() {
		return (long) value;
	}
	
	public float asFloat() {
		return (float) value;
	}
	
	public double asDouble() {
		return (double) value;
	}
	
	public boolean asBoolean() {
		return (boolean) value;
	}
	
	public byte[] asByteArray() {
		return (byte[]) value;
	}
	
	public char[] asCharArray() {
		return (char[]) value;
	}
	
	public short[] asShortArray() {
		return (short[]) value;
	}
	
	public int[] asIntArray() {
		return (int[]) value;
	}
	
	public long[] asLongArray() {
		return (long[]) value;
	}
	
	public float[] asFloatArray() {
		return (float[]) value;
	}
	
	public double[] asDoubleArray() {
		return (double[]) value;
	}
	
	public boolean[] asBooleanArray() {
		return (boolean[]) value;
	}
	
	public byte asBoxedByte() {
		return (byte) value;
	}
	
	public Character asBoxedChar() {
		return (Character) value;
	}
	
	public Short asBoxedShort() {
		return (Short) value;
	}
	
	public Integer asBoxedInt() {
		return (Integer) value;
	}
	
	public Long asBoxedLong() {
		return (Long) value;
	}
	
	public Float asBoxedFloat() {
		return (Float) value;
	}
	
	public Double asBoxedDouble() {
		return (Double) value;
	}
	
	public Boolean asBoxedBoolean() {
		return (Boolean) value;
	}
	
	public byte[] asBoxedByteArray() {
		return (byte[]) value;
	}
	
	public Character[] asBoxedCharArray() {
		return (Character[]) value;
	}
	
	public Short[] asBoxedShortArray() {
		return (Short[]) value;
	}
	
	public Integer[] asBoxedIntArray() {
		return (Integer[]) value;
	}
	
	public Long[] asBoxedLongArray() {
		return (Long[]) value;
	}
	
	public Float[] asBoxedFloatArray() {
		return (Float[]) value;
	}
	
	public Double[] asBoxedDoubleArray() {
		return (Double[]) value;
	}
	
	public Boolean[] asBoxedBooleanArray() {
		return (Boolean[]) value;
	}
	
	public String asString() {
		return (String) value;
	}
	
	public String[] asStringArray() {
		return (String[]) value;
	}
	
	public Object asObject() {
		return value;
	}
	
	public Object[] asObjectArray() {
		return (Object[]) value;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T as(Class<T> type) {
		return (T) value;
	}
	
	@SuppressWarnings("unchecked")
	public <V> List<V> asList() {
		return (List<V>) value;
	}
	
	@SuppressWarnings("unchecked")
	public <V> List<V> asList(Class<V> valueType) {
		return (List<V>) value;
	}
	
	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> asMap() {
		return (Map<K, V>) value;
	}
	
	@SuppressWarnings("unchecked")
	public <K, V> Map<K, V> asMap(Class<K> keyType, Class<V> valueType) {
		return (Map<K, V>) value;
	}
}
