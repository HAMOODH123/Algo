package com.excise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Integer>();
        list = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if(value != null) {
            list.remove(new Integer(key));
            list.addFirst(key);
        } else value = -1;
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            list.remove(new Integer(key));
        }
        if(list.size() >= capacity) {
            int lastKey = list.removeLast();
            map.remove(lastKey);
        } 
        list.addFirst(key);
        map.put(key, value);
    }
}