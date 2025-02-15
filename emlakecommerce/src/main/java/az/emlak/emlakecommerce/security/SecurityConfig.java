package az.emlak.emlakecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(c -> c.disable())
                .authorizeHttpRequests(
                        c -> c
                                .anyRequest().permitAll()
                )
                .formLogin(f -> f
                        .defaultSuccessUrl("/" ,true)
                        .loginPage("/auth/login")
                        .failureUrl("/auth/login?error=true")
                )
                .exceptionHandling(e -> e
                        .accessDeniedPage("/login")
                );
        return httpSecurity.build();
    }
}

