package com;


import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * Spring Boot 教程一
 * Spring Boot 入门
 * @author LingDu
 */
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}) 启动时不使用数据库
@SpringBootApplication
@ServletComponentScan //使用注解的方式注册servlet需要在SpringbootHelloApplication.java中添加@ServletComponentScan注解
@ComponentScan
@MapperScan("com.example.mapper")//扫描com.example.mapper包下的类
@EnableScheduling	//开启定时器
public class SpringbootHelloApplication {
	@Autowired
	private MultipartConfigElement multipartConfigElement;
	
	/**
     * 修改DispatcherServlet默认配置
     *
     * @param dispatcherServlet
     * @author LingDu
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        //这里需要将附件配置设置进去，否则请求不过来 报异常：Required request part 'file' is not present
        registration.setMultipartConfig(multipartConfigElement); 
        registration.addUrlMappings("*.action"); //只有*.action 的请求能通过
        return registration;
    }
	
    
    /**
     * Servlet支持
     * @return
     */
	/*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new Servlet1(),"/servlet/*");// ServletName默认值为首字母小写，即servlet
    }*/
	
	
	
    
    //DataSource配置
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
 
    //提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
 
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
 
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
 
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));//映射文件是resource/mybatis/目录下所有.xml文件
 
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloApplication.class, args);
	}
}
