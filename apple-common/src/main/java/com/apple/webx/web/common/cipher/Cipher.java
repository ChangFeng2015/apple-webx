package com.apple.webx.web.common.cipher;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 类Cipher.java的实现描述：TODO 注解类，对需要加密的属性进行注解
 * 
 * @author Jndong 2014年3月31日 上午9:28:14
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Cipher {

    /**
     * 属性对应的密文属性字段，如果不指定，则默认为原属性名称+CipherText
     * 
     * @return
     */
    public String value() default "";
}
