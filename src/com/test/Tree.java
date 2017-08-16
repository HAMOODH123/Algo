package com.test;

import edu.princeton.cs.algs4.Stack;

public class Tree {
	public static void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        
        while(temp != null) {
            TreeNode t = temp.left;
            temp.left = null;
            if(temp.right != null) s.push(temp.right);
            temp.right = t;
            temp = temp.right;
            if(temp == null && !s.isEmpty()) temp = s.pop();
        }
    }
	
	public static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		flatten(root);
	}
}
