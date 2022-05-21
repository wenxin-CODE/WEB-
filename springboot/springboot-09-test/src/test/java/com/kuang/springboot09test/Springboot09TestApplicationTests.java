package com.kuang.springboot09test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot09ApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;


    //简单的邮件
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("表白");
        mailMessage.setText("i love you");
        mailMessage.setTo("1989117813@qq.com");
        mailMessage.setFrom("2011429436@qq.com");
        mailSender.send(mailMessage);
    }

    //复杂的邮件
    @Test
    void contextLoads2() throws MessagingException, MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        //正文
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
        messageHelper.setSubject("12");
        //true 支持html
        messageHelper.setText("<p>123</p>",true);
        //附件
        messageHelper.addAttachment("1.jpg",new File("D:\\java\\SpringBoot\\SpringBoot-09\\src\\main\\resources\\images\\1.jpg"));
        messageHelper.setTo("1989117813@qq.com");
        messageHelper.setFrom("2011429436@qq.com");
        mailSender.send(mimeMessage);
    }


}

