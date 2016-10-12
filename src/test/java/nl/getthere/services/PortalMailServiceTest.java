package nl.getthere.services;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.mail.internet.MimeMessage;

import nl.getthere.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalMailServiceTest {

	@Mock
	private JavaMailSender jMailSender;
	
	@Mock MimeMessage mockMsg;
	
	@Autowired
	private PortalMailService pms;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		pms.setjMailSender(jMailSender);
	}
	
	@Test
	public void sendWelcomeMailTest(){
		//mock the call in pms.sendWelcomeMail where jMailSender returns a MimeMessage.
		when(jMailSender.createMimeMessage()).thenReturn(mockMsg);
		
		//Test user with valid data.
		User user = new User();
		user.setEmail("test@test.net");
		user.setFirstName("Test");
		
		//execute method
		pms.sendWelcomeMail(user);
		
		//verify send method of jMailSender
		verify(jMailSender).send(any());
	}
}
