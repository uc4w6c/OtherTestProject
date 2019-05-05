package com.string.format;

public class FormatTest {
	public static void main(String[] args) {
		System.out.println(String.format("[%s]: %s", "1", "aaa", "bbb"));
		System.out.println(String.format("[%s]: %s %s", "1", "aaa", "bbb"));
	}
}
