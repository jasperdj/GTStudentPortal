package nl.getthere.helpers;

/**
 * Created by jasper.dejong on 29-9-2016.
 */
import java.util.Properties;

import nl.getthere.model.MyUserDetailsService;
import org.apache.commons.dbcp.BasicDataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
public class AppConfig {

}