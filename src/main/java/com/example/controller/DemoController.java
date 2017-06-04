package com.example.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring Boot  教程
 * Controller
 * 如何响应JSP页面
 * 
 * 1：pom加配置，并且把 <packaging>jar</packaging> 改成  <packaging>war</packaging>
 * 2：application.properties配置文件加入JSP支持
 * 3：src/main  下创建 webapp/WEN-INF/page/ 文件夹
 * 4: 写controller层，具体跟SpringMVC一样
 * 
 * 参考：http://blog.csdn.net/catoop/article/details/50501676
 * 
 * @author LingDu
 *
 */
@Controller
public class DemoController {
	//从application.properties中读取配置，如取不到默认值为Hello World!
	@Value("${application.hello:Hello World!}")
	private String hello = "Hello World!";
	
	
	/**
	 * 默认页<br />
	 * @RequestMapping("/") 和 @RequestMapping是有区别的
	 * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
	 * 如果加了参数“/”，则只认为是根页面。
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/","/index"})
	public String index(Map<String, Object> model){
		//返回字符串的形式响应jsp页面
		model.put("time", new Date());
		model.put("message", this.hello);
		return "index";		
	}
	
	/**
	 * 视图绑定
	 * @return
	 */
	@RequestMapping("/page1")
	public ModelAndView page1(){
		ModelAndView mav = new ModelAndView("page1");
		mav.addObject("content", "1：通过返回ModelAndView对象，将属性值传递给jsp页面");
		return mav;		
	}
	
	/**
	 * 接收Model对象
	 * 设置属性值
	 * 返回String字符串（页面的路径）
	 * @param model
	 * @return
	 */
	@RequestMapping("/page2")
	public String page2(Model model){
		model.addAttribute("content", "2：通过接收Model对象，设置属性的方式传递给jsp页面");
		return "page1";	
	}
}
