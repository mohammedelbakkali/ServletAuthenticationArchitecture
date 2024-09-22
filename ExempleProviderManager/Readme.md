# 🔑 **ProviderManager et AuthenticationManager**
![providerManager.png](images%2FproviderManager.png)

## Processus d'authentification

Lorsqu'une demande d'authentification est reçue, un filtre de Spring Security invoque l'instance de `AuthenticationManager`. Ce dernier gère la logique d'authentification en se basant sur l'implémentation fournie.

## Renvoi de l'Authentication

Une fois que l'authentification est réussie, l'objet `Authentication` retourné est stocké dans le `SecurityContextHolder`. Cela permet à d'autres parties de l'application de connaître l'utilisateur actuellement authentifié.

## Utilisation directe

Si vous ne travaillez pas avec les filtres de Spring Security, vous pouvez interagir directement avec le `SecurityContextHolder` sans passer par un `AuthenticationManager`.

## Fonctionnement du ProviderManager

`ProviderManager` peut déléguer l'authentification à plusieurs instances de `AuthenticationProvider`. Chaque `AuthenticationProvider` est responsable d'un type particulier d'authentification, comme :

- Nom d'utilisateur/mot de passe
- Jeton JWT
- Authentification OAuth

Si un `AuthenticationProvider` parvient à authentifier l'utilisateur, il renvoie un objet `Authentication` complètement renseigné, avec des informations comme le nom d'utilisateur et les rôles attribués.

## Processus :
![processus.png](images%2Fprocessus.png)