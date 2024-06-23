package co.mz.chilenguejoseorlando.app.auth_escola.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.*;


// pegat tokenque usario esta convertendo as roles o profixo que spring security entende
public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Map<String, Collection<String>> realAccess = jwt.getClaim("realm_acess");
        Collection<String> roles = realAccess.get("roles");
        var grants = roles.stream()
        .map(role ->new SimpleGrantedAuthority("ROLE_" + role)).toList();

        return new JwtAuthenticationToken(jwt, grants);
    }

}
