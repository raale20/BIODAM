package com.example.BIODAM.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomSuccessHandler customSuccessHandler;
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // @formatter:off

        http
                .authorizeRequests()
                    .antMatchers("/css/**", "/img/**", "/formularioRegistro", "/listadoProductos", "/detallesProducto").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")//Establecemos el permiso ADMIN
                    .antMatchers("/user/**").hasRole("USER")//Establecemos el permiso USER
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/index")
                    .loginProcessingUrl("/login") //Esto reconducirá al usuario que quiera entrar en una dirección sin ese permiso
                    .successHandler(customSuccessHandler)
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll()
                    .and()
        		.exceptionHandling()
                    .accessDeniedPage("/acceso-denegado");

        //Para enviar correos leer https://www.thymeleaf.org/doc/articles/springmail.html

        // Añadimos esto para poder seguir accediendo a la consola de H2 con Spring Security habilitado.
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // @formatter:o

    }
}
