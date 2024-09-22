package db.connection;

import db.connection.AuthenticationsProviders.AuthenticationProviderJWT;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Création d'une liste d'AuthenticationProvider
        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(new AuthenticationProviderJWT());

        // Création d'un ProviderManager avec la liste de providers
        ProviderManager authenticationManager = new ProviderManager(providers);

        // Créer une requête d'authentification
        Authentication authenticationRequest = new UsernamePasswordAuthenticationToken("user", "password");

        try {
            // Essayer d'authentifier
            Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);
            System.out.println("Authentification réussie : " + authenticationResult.isAuthenticated());
            System.out.println("Nom d'utilisateur : " + authenticationResult.getName());
            System.out.println("Rôles : " + authenticationResult.getAuthorities());
        } catch (AuthenticationException e) {
            System.out.println("Authentification échouée : " + e.getMessage());
        }
    }
}