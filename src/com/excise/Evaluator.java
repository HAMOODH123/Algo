package com.excise;

import java.util.*;
import edu.princeton.cs.algs4.Stack;
import static com.util.Print.*;

public class Evaluator {
	private Stack<String> operator = new Stack<>();
	private Stack<Double> operand = new Stack<>();
	
	public double caculate(String s) {
		String seq = s.trim();
		Scanner in = new Scanner(seq);
		while(in.hasNext()) {
			String temp = in.next();
			if(temp.equals("("))
				;
			else if(temp.equals("sqrt(")) {
				operator.push("sqrt(");
			}
			else if(temp.equals(")")) {
				String operatorChar = operator.pop();
				if(!operatorChar.equals("sqrt(")) {
					double rightOperand = operand.pop();
					double leftOperand = operand.pop();
					operand.push(compute(operatorChar, leftOperand, rightOperand));
				} else{
					double singleOperand = operand.pop();
					operand.push(compute(operatorChar, singleOperand));
				}
			}
			else if(temp.matches("\\+|-|\\*|/")) {
				operator.push(temp);
			}
			else {
				operand.push(Double.parseDouble(temp));
			}
		}
		in.close();
		return operand.pop();
	}
	
	private double compute(String s, double leftOperand, double rightOperand) {
		double result = 0.0;
		switch(s) {
		case "+" : result = leftOperand + rightOperand;break;
		case "-" : result = leftOperand - rightOperand;break;
		case "*" : result = leftOperand * rightOperand;break;
		case "/" : result = leftOperand / rightOperand;break;
		default: throw new UnsupportedOperationException();
		}
		return result;
	}
	
	private double compute(String s, double singleOperand) {
		if(s.equals("sqrt("))
			return Math.sqrt(singleOperand);
		else 
			throw new UnsupportedOperationException();
	}
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s = in.nextLine();
//		in.close();
//		Evaluator eva = new Evaluator();
//		println(eva.caculate(s));
		String ss = "sjhgksjg\r\njbsjbj\r\nskhgjdsnbj\r\n";
		String[] sss = ss.split("\r\n");
		println(ss);
		println(Arrays.toString(sss));
	}
}
