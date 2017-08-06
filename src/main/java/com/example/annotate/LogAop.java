package com.example.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//字段注解  ,用于描述方法
@Retention(RetentionPolicy.RUNTIME)//在运行期保留注解信息  
public @interface LogAop {
	String name() default "Log";
}



/*java提供了4种元注解用于注解其他注解，所有的注解都是基于这四种注解来定义的。



@Target注解：用于描述注解的使用范围，超出范围时编译失败。

  取值类型（ElementType）：

    1.CONSTRUCTOR:用于描述构造器

    2.FIELD:用于描述域（成员变量）

    3.LOCAL_VARIABLE:用于描述局部变量

    4.METHOD:用于描述方法

    5.PACKAGE:用于描述包

    6.PARAMETER:用于描述参数

    7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
    
  
 */

/*
 
@Retention：描述注解的生命周期，即注解的生效范围。

取值范围（RetentionPolicy）：

 1.SOURCE：在源文件中生效，仅存在java文件中，class文件将会去除注解。

 2.CLASS：在class文件中生效，仅保留在class文件中，运行时无法获取注解。

 3.RUNTIME:在运行时生效，保留在class文件中且运行时可通过反射机制获取。

*/

















