package com.esn.adapters.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults())
                .authenticationProvider(daoAuthenticationProvider(userDetailsService()))
                .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/swagger-ui/**","/api-docs/**").permitAll()
                .requestMatchers("/v1/beneficiario/**","/v1/documento/**").hasRole("USER").anyRequest().authenticated());

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withUsername("antliabnp")
                .password("{noop}antliabnp")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}