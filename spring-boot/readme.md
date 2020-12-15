## 1.1基本依懒
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
        </dependency>

## 1.2模块介绍
    从上图可以看到spring-boot 是基于spring实现的,应用spring-boot 一般要制作starter,下面分析组成的几个模块

    1.spring-boot-starter
    该模块主要其它几个模块依赖组合在一起，实现就是一个pom文件，是没有源码
    2.spring-boot
    核心模块，完全基于spring实现
    3.spring-boot-autoconfigure
    自动配模块，基于spring-boot，预设一些常用框架的配置信息；基于依赖条件是否满足，如依赖条件满足则启用该框加配置；如mybatis,spring-aop这些框架；当然我们要自动配置这个框架首先基于spring-boot去制相应的starter
    4.spring-core
    这个不用说了
## EnableAutoConfiguration 注解
    spring.factories
        