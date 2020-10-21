package com.example.BIODAM.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // @formatter:off

        http
                .authorizeRequests()
                    .antMatchers("/public/css/**", "/js/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")//Establecemos el permiso ADMIN
                    .antMatchers("/user/**").hasRole("USER")//Establecemos el permiso USER
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/formulario")
                    .loginProcessingUrl("/login") //Esto reconducirá al usuario que quiera entrar en una dirección sin ese permiso
                    //.defaultSuccessUrl("/admin/", true)
                    //.successHandler()
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll();

        //Para enviar correos leer https://www.thymeleaf.org/doc/articles/springmail.html
        // Añadimos esto para poder seguir accediendo a la consola de H2
        // con Spring Security habilitado.
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // @formatter:o



    }
}
