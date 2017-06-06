package com.test.sample;

public interface LRUI<K,V> {

	public V get(K key);
	
	public void put(K key, V value);
	
	public int getSize();
	
	public void clear();
	
}
