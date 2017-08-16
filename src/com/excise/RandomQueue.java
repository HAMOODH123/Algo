package com.excise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class RandomQueue<T> implements Iterable<T> {
	private int size;
	private T[] data;
	
	@SuppressWarnings("unchecked")
	public RandomQueue() {
		data = (T[])new Object[3];
	}
	
	public void enqueue(T value) {
		if(size() == data.length)
			resize(size() * 2);
		data[size] = value;
		size++;
	}
	
	public T dequeue() {
		if(size() < data.length / 2)
			resize(data.length / 2);
		Random r = new Random();
		int rand = r.nextInt(size);
		T last = data[size - 1];
		data[size - 1] = data[rand];
		data[rand] = last;
		return data[size - 1];
	}
	
	public T sample() {
		Random r = new Random();
		return data[r.nextInt(size)];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newLength) {
		T[] temp = (T[]) new Object[newLength];
		for(int i = 0; i < size(); i++)
			temp[i] = data[i];
		data = temp;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<T>{
		private int count = 0;
		
		QueueIterator() {
			Collections.shuffle(Arrays.asList(data));
		}
		
		@Override
		public boolean hasNext() {
			return count == size;
		}

		@Override
		public T next() {
			return data[count++];
		}

		@Override
		public void remove() {}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
