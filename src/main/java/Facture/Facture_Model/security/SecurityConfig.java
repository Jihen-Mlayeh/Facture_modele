package Facture.Facture_Model.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() { // Crée un User avec un username , password et role
        UserDetails user= User.withUsername("user")
                .password("{noop}password") // mot de passe est clair
                .roles("USER").build();
    return new InMemoryUserDetailsManager(user);}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http .csrf(csrf->csrf.disable()) // desactive la protection crsf pour tester tous methodes post/delete/put
                            // toutes les requetes http sont authentifiées
                                .authorizeHttpRequests(auth->auth.anyRequest()
                        .authenticated()).httpBasic(Customizer.withDefaults()); // authentification http basic (just mot de passe et username
        return http.build();

    }
}
