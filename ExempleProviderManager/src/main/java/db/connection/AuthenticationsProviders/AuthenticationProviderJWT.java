package db.connection.AuthenticationsProviders;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

public class AuthenticationProviderJWT implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        // Valider le nom d'utilisateur et mot de passe
        if("user".equals(username) && "password".equals(password)){
             // Retourner l'authentification avec sucée et les roles
             List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
             return new UsernamePasswordAuthenticationToken(username, password, authorities);

        }else {
            throw new AuthenticationException("Invalid Credentials") {};
        }

    }


     /**
      * Vérification de la Compatibilité :
      *La méthode reçoit un paramètre de type Class<?>, représentant le type d'authentification qui a été demandé.
      * Elle vérifie si le type d'authentification demandé (par exemple, UsernamePasswordAuthenticationToken) est compatible avec le type pris en charge par ce fournisseur d'authentification.
      * */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

    }
}
