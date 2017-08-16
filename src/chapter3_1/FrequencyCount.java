package chapter3_1;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class FrequencyCount {
	private static final int MIN_LENGTH = 10;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
//		BinarySearchST<String, Integer> st = new BinarySearchST<>();
//		BRBST<String, Integer> st = new BRBST<>();
//		BST<String, Integer> st = new BST<>();
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
		Scanner in = new Scanner(new FileInputStream(new File(args[0])));
		while(in.hasNext()) {
			String key = in.next();
			if(key.length() < MIN_LENGTH) continue;
			if(!st.contains(key)) {
				st.put(key, 1);
			} else {
				st.put(key, st.get(key) + 1);
			}
		}
		in.close();
		String max = " ";
		st.put(max, 0);
		for(String key : st.keys()) {
			if(st.get(key) > st.get(max)) {
				max = key;
			}	
		}
		long end = System.currentTimeMillis();
		System.out.println(max + " " + st.get(max));
		System.out.println(end - start);
		Map<String, String> map = new ConcurrentHashMap<String, String>();
	}
}
