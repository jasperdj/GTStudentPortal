package nl.getthere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class PortalMailService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendWelcomeMail(String email){
		
		try{
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(email);
			msg.setFrom("gtsptest@gmail.com");
			msg.setSubject("Welkom op de Get There Studenten Portal!");
			msg.setText("<h1>Welkom enzo.</h1> Groetjes.");
			mailSender.send(msg);
			System.out.println("Mail sent! Check "+email);
		}catch(Exception e){
			System.out.println("Error while trying to send mail!");
			e.printStackTrace();
		}
		
	}
}
