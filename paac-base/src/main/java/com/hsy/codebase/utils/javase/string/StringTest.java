package com.hsy.codebase.utils.javase.string;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月18日 下午11:40:21
 */
public class StringTest {
	public static void main(String[] args) {
		// str1的值是字符串直接量，
		// 因此str1指向字符串缓存池中"Hello Java"字符串
		String str1 = "Hello Java";
		// str2也指向字符串缓存池中"Hello Java"字符串
		String str2 = "Hello Java";
		// 下面程序将输出true
		System.out.println(str1 == str2);
	}
}
