package nl.getthere;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class GtStudentPortalApplication {

	@Autowired
	private PlatformTransactionManager transactionManager;

	public static void main(String[] args) {
		SpringApplication.run(GtStudentPortalApplication.class, args);
	}
}
