package com.codegym.config;

import com.codegym.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf
        http.csrf().disable();

        // login
        http.formLogin()
                .loginProcessingUrl("/checkLogin")
                .loginPage("/")
                // login successful
                .defaultSuccessUrl("/blog/home")
                // login failed
                .failureUrl("/?error=true")
                // setting username, password
                .usernameParameter("username")
                .passwordParameter("password")
                // logout
                .and().logout().logoutUrl("/logout")
                // logout successful
                .logoutSuccessUrl("/");

        //guest
        http.authorizeRequests().antMatchers("/","/logout","/register").permitAll();
        //user
//        http.authorizeRequests().antMatchers("blog/detail","blog/home").hasRole("USER");
        http.authorizeRequests().antMatchers("/blog/detail","/blog/home").hasRole("USER");

       //admin
        http.authorizeRequests().antMatchers("/blog/create","/blog/delete","/blog/update/*","/blog/detail").hasRole("ADMIN");
        //no permission
        http.exceptionHandling().accessDeniedPage("/403");
        //remember me
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("remember")
                .tokenValiditySeconds(60);
    }


}
