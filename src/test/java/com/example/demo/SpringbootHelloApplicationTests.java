package com.example.demo;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;

import com.example.email.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHelloApplicationTests {

	@Autowired
    private EmailService emailService;

	/*@Autowired
	private TemplateEngine templateEngine;*/
	 
    @Test
    public void sendSimpleMail() throws Exception {
    	emailService.sendSimpleEmail("821300801@qq.com","主题：这是简单的邮件"," hello LingDu");
    }
    
    @Test
    public void sendHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        emailService.sendHtmlEmail("821300801@qq.com","主题：这是HTML邮件",content);
    }
    
    @Test
    public void sendAttachmentsMail() {
        String filePath="f:\\pikaqiu.png";
        emailService.sendAttachmentsEmail("821300801@qq.com", "主题：带附件的邮件", "收到附件，请查收！", filePath);
    }
    
    
    @Test
    public void sendInlineResourceMail() {
        String rscId = "001";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "f:\\pikaqiu.png";

        emailService.sendInlineResourceEmail("821300801@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
    
    /**
     * 发送模版邮件
     * 
     * 这里使用thymeleaf作为模版引擎，注意一定要在pom文件中导入thymeleaf支持
     */
    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        /*Context context = new Context();
        context.setVariable("username", "LingDu");
        String emailContent = templateEngine.process("email", context);
        emailService.sendHtmlEmail("821300801@qq.com","主题：这是模板邮件",emailContent);*/
    }
}
