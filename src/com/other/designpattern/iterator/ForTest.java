package com.other.designpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iteratorを試す
 * @author ysaito
 *
 */
public class ForTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		Iterator<String> it = list.iterator();
		String result = "";
		while (it.hasNext()) {
			result += it.next();
			if (it.hasNext()) {
				result += ",";
			}
		}
		System.out.println(result);
	}
}
