package com.chapter2_1_1;

import com.util.ArrayGenerator;

public class OneOfThree {
	/**
	 * 寻找3个列表中第一个公共的名字
	 * @return
	 */
	public static int search(Node<Integer> l1, Node<Integer> l2, Node<Integer> l3) {
		Node<Integer> sortedList1 = MSWithList.sort(l1);
		Node<Integer> sortedList2 = MSWithList.sort(l2);
		Node<Integer> sortedList3 = MSWithList.sort(l3);
		MSWithList.print(sortedList1);
		MSWithList.print(sortedList2);
		MSWithList.print(sortedList3);
		return merge(sortedList1, sortedList2, sortedList3);
	}
	
	public static Integer merge(Node<Integer> l1, Node<Integer> l2, Node<Integer> l3) {
		if(l1 == null || l2 == null ||l3 ==null) return null;
		Node<Integer> result = new Node<>();
		while(l1 != null || l2 != null ||l3 !=null) {
			if((l1.data == l2.data) && (l1.data == l3.data)) return l1.data;
			if(min(l1, l2, l3) == l1) {
				result.next = l1;
				result = l1;
				l1 = l1.next;
			} else if(min(l1, l2, l3) == l2){
				result.next = l2;
				result = l2;
				l2 = l2.next;
			} else {
				result.next = l3;
				result = l3;
				l3 = l3.next;
			}
		}
		return null;
	}
	
//	public static int max(int a, int b, int c) {
//		
//	}
	
	public static Node<Integer> min(Node<Integer> l1, Node<Integer> l2, Node<Integer> l3) {
		Node<Integer> min = l1;
		if(l2.data < min.data)
			min = l2;;
		if(l3.data < min.data)
			min = l3;
		return min;
	}
	
	public static boolean equal(int a, int b, int c) {
		return (a == b) && (a == c);
	}

	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.generateInteger(20, 25);
		Integer[] b = ArrayGenerator.generateInteger(15, 35);
		Integer[] c = ArrayGenerator.generateInteger(25, 30);
		
		Node<Integer> l1 = MSWithList.getList(a);
		
		Node<Integer> l2 = MSWithList.getList(b);
		
		Node<Integer> l3 = MSWithList.getList(c);
		
		System.out.println(search(l1, l2, l3));
	}
}


