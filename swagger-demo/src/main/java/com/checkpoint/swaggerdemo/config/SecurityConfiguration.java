package com.checkpoint.swaggerdemo.config;

import com.checkpoint.swaggerdemo.rest.BasicAuthFilter;
import com.checkpoint.swaggerdemo.rest.CustomAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomAuthEntryPoint customAuthEntryPoint;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("{noop}linux").roles("USER", "ADMIN").and()
                .withUser("test").password("{noop}test123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
 http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/demo-app/products/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/demo-app/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/demo-app/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/demo-app/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/demo-app/products/**").hasRole("ADMIN")
                .and().exceptionHandling().authenticationEntryPoint(customAuthEntryPoint)
                .and().httpBasic()
                .and().csrf().disable();



  http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/demo-app/products/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/demo-app/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/demo-app/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/demo-app/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/demo-app/products/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(customAuthEntryPoint)
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and().csrf().disable();

        http.addFilterAfter(new BasicAuthFilter("/**"), UsernamePasswordAuthenticationFilter.class);
*/

    }
}
