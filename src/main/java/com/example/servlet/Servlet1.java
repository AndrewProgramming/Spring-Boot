package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 	通过代码注册Servlet
 * 
 * 	1、创建Servlet1.java 继承 HttpServlet 实现 doPost() , doGet()方法
 * 	2、在SpringbootHelloApplication.java文件中添加
 * 
 * 	@Bean
 *  public ServletRegistrationBean servletRegistrationBean() {
 *     return new ServletRegistrationBean(new Servlet1(),"/servlet/*");// ServletName默认值为首字母小写，即servlet
 *  }
 * 
 * 
 * @author LingDu
 */
public class Servlet1 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet初始化");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----------> doGet()");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----------> doPost()");
		resp.setContentType("text/html");  
		String id = req.getParameter("id");
		if(id != null && !id.equals("")){
			resp.getWriter().append("-----------> doPost()  id=" + id);
			return;
		}
        resp.getWriter().append("-----------> doPost()");
	}
}
