package com.salesianostriana.dam.karting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/karts/**", "/pilotos/**", "/sesiones/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage("/errorAcceso")
                .and().formLogin().loginPage("/").loginProcessingUrl("/login").failureUrl("/login-error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and().headers().frameOptions().disable();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        usuarioRepository.getUsuarios()
                .stream()
                .map(u -> {
                    return User
                            .withUsername(u.getUsername())
                            .password("{noop}"+ u.getPassword())
                            .roles(u.getRole())
                            .build();

                })
                .forEach(userDetailsManager::createUser);


        return userDetailsManager;


    }

}
