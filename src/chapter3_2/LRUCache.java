package chapter3_2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.util.ArrayGenerator;

public class LRUCache {
	@SuppressWarnings("unused")
	private int capacity;
	private LinkedHashMap<Integer, Integer> map;
	
	@SuppressWarnings("serial")
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}
	
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}
	
	public void put(int key, int value) {
		map.put(key, value);
	}
	
	public String toString() {
		return map.toString();
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		int[] a = ArrayGenerator.generateInt(10, 15);
		System.out.println(Arrays.toString(a));
		for(int i = 0; i < 5; i++)
			lru.put(i, a[i]);
		System.out.println(lru);
		System.out.println(lru.get(2));
		System.out.println(lru);
		lru.put(6, a[6]);
		System.out.println(lru);
		System.out.println(lru.get(1));
		System.out.println(lru);
		lru.put(7, a[7]);
		System.out.println(lru);
		System.out.println(lru.get(3));
	}
}
