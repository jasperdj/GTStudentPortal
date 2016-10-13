package nl.getthere.security.social;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by jasper.dejong on 13-10-2016.
 */
public class SignInUtils {

    /**
     * Programmatically signs in the user with the given the user ID.
     */
    public static void signin(String userId) {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, null));
    }

}
