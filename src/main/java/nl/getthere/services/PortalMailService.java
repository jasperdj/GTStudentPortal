package nl.getthere.services;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class PortalMailService {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender jMailSender;
		
	public void sendWelcomeMail(String email){
		try{
			MimeMessage message = jMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			helper.setSubject("Welkom op de Get There Student Portal!");
			helper.setText("<h3>Welkom!</h3><p>Leuk dat je je hebt aangemeld op de Get There Student Portal! Hier komt nog meer tekst...</p><p>Groeten, Get There</p><img src='cid:gt_logo'>", true);
			FileSystemResource res = new FileSystemResource(new File("D:/projects/academy/GTStudentPortal/src/main/webapp/resources/img/logo_header.png"));
			helper.addInline("gt_logo", res);
			jMailSender.send(message);
		}catch(Exception e){
			System.out.println("Error while trying to send mail!");
			e.printStackTrace();
		}
	}
}
