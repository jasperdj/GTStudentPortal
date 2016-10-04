package nl.getthere.security;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * Created by jasper.dejong on 29-9-2016.
 */
public class CurrentUser {
    private String email;
    private String role;

    public CurrentUser(String name, String role) {
        this.email = name;
        this.role = role;
    }

    public static CurrentUser getCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (name == null) return null;
        Collection list = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String role= "no-role";
        for(Object authority : list) {
            role = authority.toString();
        }
        return new CurrentUser(name, role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}