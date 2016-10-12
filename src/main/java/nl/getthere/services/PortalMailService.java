package nl.getthere.services;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import nl.getthere.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
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

	public void sendWelcomeMail(User user) {
		try {
			// Setup head
			MimeMessage message = jMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getEmail());
			helper.setSubject("Welkom op de Get There Student Portal!");
			helper.setText("<h3>Welkom " + user.getFirstName() + "!</h3><p>Leuk dat je je hebt aangemeld op de Get There Student Portal! Hier komt nog meer tekst...</p><p>Groeten, Get There</p><img src='cid:gt_logo'>",
					true);

			// Get resource location and set image.
			Resource resource = new ClassPathResource("/application.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String root = props.getProperty("resources");
			FileSystemResource res = new FileSystemResource(new File(root + "img/logo_header.png"));
			helper.addInline("gt_logo", res);

			// Send mail
			jMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setjMailSender(JavaMailSender jMailSender) {
		this.jMailSender = jMailSender;
	}
	
	
}
