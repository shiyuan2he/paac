package com.hsy.codebase.utils.javase.string;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月18日 下午11:34:30
 */
public class MutableString {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Hello ");
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		// 追加"Java"
		str.append("Java");
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		// 追加", crazyit.org"
		str.append(", crazyit.org");
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
	}
}
