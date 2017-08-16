package com.util;

import static com.util.Print.*;

public class Rational {
	private long numerator;     //·Ö×Ó
	private long denominator;   //·ÖÄ¸
	
	public Rational(long numerator2, long denominator2) {
		long number = gcd(numerator2, denominator2);
		this.numerator = numerator2 / number;
		this.denominator = denominator2 / number;
	}
	
	public Rational plus(Rational b) {
		long numerator = this.numerator*b.denominator + this.denominator*b.numerator;
		long denominator = this.denominator * b.denominator;
		return new Rational(numerator, denominator);
	}
	
	public Rational minus(Rational b) {
		long numerator = this.numerator*b.denominator - this.denominator*b.numerator;
		long denominator = this.denominator * b.denominator;
		return new Rational(numerator, denominator);
	}

	public Rational times(Rational b) {
		long numerator = this.numerator * b.numerator;
		long denominator = this.denominator * b.denominator;
		return new Rational(numerator, denominator);
	}

	public Rational divides(Rational b) {
		long numerator = this.numerator * b.denominator;
		long denominator = this.denominator * b.numerator;
		return new Rational(numerator, denominator);
	}
	
	public boolean equals(Rational that) {
		return this.numerator * that.denominator == this.denominator * that.numerator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public long gcd(long numerator2, long denominator2) {
		long p1 = Math.abs(numerator2);
		long q1 = Math.abs(denominator2);
		if(q1 == 0)
			return p1;
		long r = p1 % q1;
		return gcd(q1, r);
	}

	public static void main(String[] args) {
		Rational r1 = new Rational(-1, 20000000);
		Rational r2 = new Rational(1, 256);
		Rational r3 = new Rational(10, 2);
		println(r1);
		println(r2);
		println(r3);
		println(r1.minus(r2));
		println(r1.divides(r2));
		println(r1.times(r2));
		println(r1.plus(r2));
		println(r1.equals(r3));
		println(r1.equals(r2));
	}
}
