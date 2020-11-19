package com.codegym.config;

import com.codegym.service.securirtyFurama.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
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
                .loginPage("/loginHome/login")
                // login successful
//                .defaultSuccessUrl("/")
                // login failed
                .failureUrl("/loginHome/login?error=true")
                // setting username, password
                .usernameParameter("username")
                .passwordParameter("password")
                // logout
                .and().logout().logoutUrl("/loginHome/logout")
                // logout successful
                .logoutSuccessUrl("/");

//        guest
        http.authorizeRequests().antMatchers("/","/logout","/register").permitAll();
//        user
       http.authorizeRequests().antMatchers("/customerHome/customerList","/contract/contractList",
               "/contractDetail/contractDetailList","/employee/listEmployee",
               "/service/serviceList").hasAnyRole("ADMIN","USER");

//       admin
        http.authorizeRequests().antMatchers("/customerHome/createCustomer","/customerHome/updateCustomer",
                "/customerHome/delete","/contract/createContract","/contractDetail/WebSecurityConfig","/employee/deleteEmployee",
                "/employee/createEmployee","/employee/updateEmployee","/service/createService",
                "/service/updateService","/service/deleteService").hasRole("ADMIN");
//        no permission
        http.exceptionHandling().accessDeniedPage("/403");
//        remember me
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMe")
                .tokenValiditySeconds(15);
    }


}
