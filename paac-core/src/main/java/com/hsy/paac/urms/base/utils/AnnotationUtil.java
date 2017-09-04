package com.hsy.paac.urms.base.utils;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;
/**
 * @path paac-core/com.codelibrary.javaee.util.AnnotationUtil.java
 * @description <p>登陆</p>
 * @author heshiyuan
 * @email sy.he@jiankangyun.com.cn
 * @date 2016年11月8日 下午2:51:41
 * @price ￥：5元
 * @copyright	此文件版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
 * @callnumber 15003828090
 */
public class AnnotationUtil {
	/**
	 * 
	 * @description <p>请在这里输入方法的作用</p>
	 * @param clazz
	 * @param method
	 * @param name
	 * @param value
	 * @returnType void
	 * 方法名:updateAnnotation
	 * 类名:AnnotationUtil
	 * @author heshiyuan
	 * @email sy.he@jiankangyun.com.cn
	 * @date 2016年11月8日 下午5:23:03
	 * @price ￥:三毛三
	 * @copyright	此方法版权归本人所有，复制或者剪切请通知本人或者捐赠 通知方式：shiyuan4work@sina.com
	 * @callnumber 15003828090
	 */
	public static void updateAnnotation(Class<?> clazz, String method, String name, String value) {
		try {
			ClassPool pool = ClassPool.getDefault();
			pool.appendClassPath(new ClassClassPath(AnnotationUtil.class));
			pool.importPackage("com.codelibrary.javaee.annotation");
			// 获取需要修改的类
			CtClass ct = pool.get(clazz.getName());

			ct.defrost();
			// 获取类里的所有方法
			CtMethod cms = ct.getDeclaredMethod(method);
			MethodInfo minInfo = cms.getMethodInfo();
			ConstPool cp = minInfo.getConstPool();
			// 获取注解信息
			AnnotationsAttribute attribute2 = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
			Annotation annotation = new Annotation("com.codelibrary.javaee.annotation.MethodException", cp);

			annotation.addMemberValue(name, new StringMemberValue(value, cp));
			attribute2.setAnnotation(annotation);
			minInfo.addAttribute(attribute2);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String readAnnotation(Class<?> clazz, String method, String name) {
		String value = "";
		try {
			ClassPool pool = ClassPool.getDefault();
			pool.appendClassPath(new ClassClassPath(AnnotationUtil.class));
			pool.importPackage("com.codelibrary.javaee.annotation");
			// 获取要修改的类的所有信息
			CtClass ct = pool.get(clazz.getName());
			ct.defrost();
			// 获取类中的方法
			CtMethod cms = ct.getDeclaredMethod(method);
			MethodInfo minInfo = cms.getMethodInfo();
			// 获取注解属性
			AnnotationsAttribute attribute = (AnnotationsAttribute) minInfo
					.getAttribute(AnnotationsAttribute.visibleTag);
			// 获取注解
			Annotation annotation = attribute.getAnnotation("com.codelibrary.javaee.annotation.MethodException");
			// 获取注解的值
			if (annotation.getMemberValue(name) != null)
				value = ((StringMemberValue) annotation.getMemberValue(name)).getValue();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}
}
