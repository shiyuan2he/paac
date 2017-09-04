package com.hsy.paac.urms.base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
/**
 * @author heshiyuan @date 2016年10月31日 上午10:26:02
 * @description <p>进行实体进行后台验证，在实体上配置正则表达式</p>
 * @copyright 此代码版权归heshiyuan所有，如有粘贴复制请通知本人  邮箱：shiyaun4work@sina.com
 * @github https://www.github.com/shiyuan2he
 * @email	sy.he@jiankangyun.com.cn
 *
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface VerifyColumn {   
	String value();  
}  

