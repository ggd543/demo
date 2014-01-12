package com.uc.jldap.demo.pojo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能描述：
 * <p>
 * 版权所有：优视科技
 * <p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0 create on: 2013年10月15
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Attribute {
    String[] value();
}
