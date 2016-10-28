package com.codelibrary.javaee.utils;

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

public class AnnotationUtil {
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
