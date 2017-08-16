package com.chapter2_1_1;

import com.chapter2_1.Sort;
import com.util.ArrayGenerator;

public class MSWithList extends Sort {
	
	public static <T extends Comparable<? super T>> Node<T> sort(Node<T> list) {
		if(list == null || list.next == null) return list;
		Turple<Node<T>, Node<T>> t = getTwoLists(list);
		Node<T> l = sort(t.e1);
		Node<T> r = sort(t.e2);
		return merge(l, r);
	}
	
	public static <T extends Comparable<? super T>> Node<T> merge(Node<T> left, Node<T> right) {
		if(left == null && right == null) return null;
		Node<T> result = new Node<>();
		Node<T> temp = result;
		while(left != null && right!= null) {
			if(less(left.data, right.data)) {
				result.next = left;
				result = left;
				left = left.next;
			} else {
				result.next = right;
				result = right;
				right = right.next;
			}
		}
		if(left == null) result.next = right;
		if(right == null) result.next = left;
		result = temp.next;
		temp = null;
		return result;
	}
	
	public static <T extends Comparable<? super T>> Node<T> merge1(Node<T> left, Node<T> right) {
		if(left == null) return right;
		if(right == null) return left;
		if(less(right.data, left.data)) {
			Node<T> temp = left;
			left = right;
			right = temp;
		}
		Node<T> lf = left;
		Node<T> rg = right;
		Node<T> temp = null;
		while(lf.next != null) {
			if(less(right.data, lf.next.data)) {
				while(rg.next != null && less(rg.next.data, lf.next.data)) {
					rg = rg.next;
				}
				temp = right;
				right = rg.next;
				rg.next = lf.next;
				lf.next = temp;
				if(right == null) break;
			}
			lf = lf.next;
		}
		if(lf.next == null) {
			lf.next = right;
		}
		return left;
	}
	
	public static <T extends Comparable<? super T>> Turple<Node<T>, Node<T>> getTwoLists(Node<T> list) {
		if(list.next == null) throw new ArrayIndexOutOfBoundsException();
		Node<T> p1 = list;
		Node<T> p2 = list;
		Node<T> temp = null;
		
		while(p2.next != null) {
			p2 = p2.next;
			if(p2.next != null) {
				p2 = p2.next;
			}
			temp = p1;
			p1 = p1.next;
		}
		temp.next = null;
		return new Turple<Node<T>, Node<T>>(list, p1);
	}
	
	public static <T extends Comparable<? super T>> Node<T> getList(T[] arr) {
		Node<T> result = new Node<>();
		Node<T> temp = result;
		for(int i = 0; i < arr.length; i++) {
			temp.data = arr[i];
			if(i == arr.length - 1) break;
			temp.next = new Node<>();
			temp = temp.next;
		}
		return result;
	}
	
	public static <T extends Comparable<? super T>> void print(Node<T> list) {
		StringBuilder sb = new StringBuilder();
		if(list == null) sb.append("[]");
		sb.append("[" + list.data);
		Node<T> temp = list.next;
        while(temp != null) {
        	sb.append(", " + temp.data);
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb);
	}

	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.generateInteger(100, 25);
//		Arrays.sort(a);
		Node<Integer> ls = getList(a);
		print(ls);
		print(sort(ls));
//		Integer[] b = ArrayGenerator.generateInteger(10, 15);
//		Arrays.sort(b);
//		Node<Integer> ls1 = getList(b);
//		print(ls1);
//		print(merge1(ls, ls1));
	}
}


class Node<T> {
	 public T data;
     public Node<T> next;
     
     public Node() {}

     public Node(T data) {
         this.data = data;
         next = null;
     }
     
     public String toString() {
 		StringBuilder sb = new StringBuilder();
 		sb.append("[" + this.data);
 		Node<T> temp = this.next;
         while(temp != null) {
         	sb.append(", " + temp.data);
             temp = temp.next;
         }
         return sb.append("]").toString();
 	}
}

class Turple<v1, v2> {
	v1 e1;
	v2 e2;
	
	Turple(v1 e1, v2 e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
}

