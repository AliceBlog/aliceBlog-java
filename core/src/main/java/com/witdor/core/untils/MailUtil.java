package com.witdor.core.untils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/9/5 11:00
 * @Description: 发送邮件
 * @Copyright(©) 2016 by xiaomo.
 **/
public class MailUtil {
    private static final String HOST = "smtp.xiaomo.info";
    private static final String PROTOCOL = "smtp";
    private static final int PORT = 25;
    private static final String FROM = "admin@xiaomo.info";//发件人的email
    private static final String PWD = "Xiaomo123";//发件人密码

    /**
     * 获取Session
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol", PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.user", FROM);
        props.put("mail.password", PWD);
        props.put("mail.smtp.auth", true);

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }

        };
        return Session.getDefaultInstance(props, authenticator);
    }

    public static void send(String toEmail, String content) {
        Session session = getSession();
        try {
            System.out.println("--send--" + toEmail);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("账号激活邮件");
            msg.setSentDate(new Date());
            msg.setContent(content, "text/html;charset=utf-8");
            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
