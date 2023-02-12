package com.otpkey.samples.ldapauth.ldapauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .formLogin()
            .defaultSuccessUrl("/", true)
            .failureForwardUrl("/failure")
            .failureUrl("/failure")
        .and()
            .logout()
            .logoutSuccessUrl("/")
            .deleteCookies("JSESSIONID");
        return http.build();
    }


    @Bean
    WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/images/**");
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
            .userSearchFilter("(uid={0})")
            .userSearchBase("dc=otpkey,dc=com")
            .userDnPatterns("uid={0},ou=admin", "uid={0},ou=dev", "uid={0},ou=user")
            .groupSearchFilter("(otpkeyMember={0})")
            .passwordCompare()
            .passwordEncoder(new BCryptPasswordEncoder())
            .passwordAttribute("userPassword")
        .and()
            .contextSource()
            .url("ldap://ldap.otpkey.com:1389/dc=otpkey,dc=com")
            .managerDn("cn=admin,dc=otpkey,dc=com")
            .managerPassword("LdapPassword1!");
    }
}
