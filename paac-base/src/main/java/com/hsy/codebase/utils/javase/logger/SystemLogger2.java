package com.hsy.codebase.utils.javase.logger;
/**
 * @see 系统日志输出
 * @Date 2015.08.12
 * @author 何世远
 *
 */
public class SystemLogger2 {
	/**
	 * @see 传入一个参数
	 * @param msg 要输出的信息
	 */
	public static void log(String msg){
		System.out.println(msg) ;
	}
	/**
	 * @see 传入两个参数
	 * @param msg，msg2要输出的信息
	 */
	public static void log(String msg,String msg2){
		System.out.println(msg + msg2) ;
	}
	/**
	 * @see 传入三个参数
	 * @param msg，msg2， msg3要输出的信息
	 */
	public static void log(String msg,String msg2,String msg3){
		System.out.println(msg + msg2 + msg3) ;
	}
}
