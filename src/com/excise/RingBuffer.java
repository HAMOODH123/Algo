package com.excise;

import static com.util.Print.*;

public class RingBuffer<T> {
	private static final int SIZE = 5;
	
	private T[] data;
	private int count;
	private int in;       //生产者指针
	private int out;      //消费者指针
	
	@SuppressWarnings("unchecked")
	public RingBuffer() {
		data = (T[])new Object[SIZE];
		in = out = count = 0;
	}
	
	private boolean isEmpty() {
		return count == 0;
	}
	
	private boolean isFull() {
		return count == data.length;
	}
	
	public void receive(T value) {
		while(isFull()) ;
		count++;
		data[in] = value;
		in = ++in % data.length;
	}
	
	public T send() {
		while(isEmpty()) ;
		count--;
		T result = data[out];
		out = ++out % data.length;
		return result;
	}

	public static void main(String[] args) {
		RingBuffer<Integer> rb = new RingBuffer<>();
		Thread producer = new Thread(new Producer(rb));
		Thread consumer = new Thread(new Consumer(rb));
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {
	private RingBuffer<Integer> rb;
	
	public Producer(RingBuffer<Integer> rb) {
		this.rb = rb;
	}

	@Override
	public void run() {
		while(true) {
			rb.receive(1);
			println("prducer");
		}		
	}	
}

class Consumer implements Runnable {
	private RingBuffer<Integer> rb;
	
	public Consumer(RingBuffer<Integer> rb) {
		this.rb = rb;
	}

	@Override
	public void run() {
		while(true) {
			rb.send();
			println("comsumer");
		}		
	}	
}
