package nl.getthere.security.social;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;



/**
 * Created by jasper.dejong on 13-10-2016.
 */
public class socialSetup {

    @Bean
    public ProviderSignInController providerSignInController(
            ConnectionFactoryLocator connectionFactoryLocator,
            UsersConnectionRepository usersConnectionRepository) {
        return new ProviderSignInController(
                connectionFactoryLocator,
                usersConnectionRepository,
                new SimpleSignInAdapter(new HttpSessionRequestCache()));
    }
}
