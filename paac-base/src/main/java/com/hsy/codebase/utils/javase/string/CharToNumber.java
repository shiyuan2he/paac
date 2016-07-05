package com.hsy.codebase.utils.javase.string;
/**
 * 
 * @description 
 *     <p>打印出26个字母对应的char位置</p>
 * @time 2016年4月4日 下午4:44:43
 */
public class CharToNumber {
	public static void main(String[] args) {
		for(char c=0;c<128;c++){
			if(c == 'a' || c == 'z'){
				System.out.println((int)c);   // 97	122
			}
			if(c == 'A' || c == 'Z'){
				System.out.println((int)c);   // 65 90
			}
			if(c > 90 && c < 97){
				//System.out.println("************************");   // 65 90
				System.out.print(c + " ");   // 65 90
			}
		}
	}
}
