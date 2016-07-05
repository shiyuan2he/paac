package com.codelibrary.javaee.utils;

import java.util.Comparator;

public class ComparatorUtil implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
//		if(o1 instanceof WtInterveneQuestionDic){
//			return (int) (((WtInterveneQuestionDic) o1).getSortId() - ((WtInterveneQuestionDic) o2).getSortId());
//		}else{
//			return Integer.parseInt(o1.toString().split("_")[0]) - Integer.parseInt(o2.toString().split("_")[0]);
//		}
	}

}
