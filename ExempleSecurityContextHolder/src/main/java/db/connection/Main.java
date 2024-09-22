package db.connection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Main {
    public static void main(String[] args) {


        Authentication authentication = new UsernamePasswordAuthenticationToken("test_name","test_password");
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);


        // Display
        SecurityContext retrivedContext = SecurityContextHolder.getContext();
        Authentication retrivedAuthentication = retrivedContext.getAuthentication();
        System.out.println("name : "+retrivedAuthentication.getName());
        System.out.println("password : "+retrivedAuthentication.getCredentials());

    }
}