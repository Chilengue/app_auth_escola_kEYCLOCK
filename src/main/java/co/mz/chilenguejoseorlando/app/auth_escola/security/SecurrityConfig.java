package co.mz.chilenguejoseorlando.app.auth_escola.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurrityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf(csrf-> csrf.disable())
            .oauth2ResourceServer(
                oauth2 -> oauth2.jwt(jwt-> jwt.jwtAuthenticationConverter(new JWTConverter()))
            );
            // .authorizeHttpRequests()
        return http.build();
    }
}
