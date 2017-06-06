package com.test.sample;

import java.util.HashMap;
import java.util.Map;

public class LRUImpl<K, V> implements LRUI<K, V> {

	private Map<K, Node<K, V>> cache = new HashMap<>();
	private Node<K, V> head, end;
	private int maxCapacity = 10;

	class Node<T, U> {
		Node<T, U> prev;
		Node<T, U> next;
		T key;
		U value;

		public Node(T key, U value) {
			this.key = key;
			this.value = value;
		}

	}

	@Override
	public V get(K key) {//O(1)
		if (cache.containsKey(key)) {
			Node<K, V> n = cache.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {//O(1)
		if (cache.containsKey(key)) {
			Node<K, V> node = cache.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		}else{
			Node<K,V> n = new Node<K,V>(key,value);
			if(cache.size() >= maxCapacity){
				cache.remove(end.key);
				remove(end);
				setHead(n);
			}else{
				setHead(n);
			}
			cache.put(key,n);
		}
	}

	private void remove(Node<K, V> node) {//O(1)
		//set the prev and next pointers as the node is being removed
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}
	}

	private void setHead(Node<K, V> node) {
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (end == null) {
			end = head;
		}
	}

	@Override
	public int getSize() {
		return this.cache.size();
	}

	@Override
	public void clear() {
		this.cache.clear();
	}

}
