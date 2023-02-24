package com.example.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//consulter tous les produits
		http.authorizeRequests().antMatchers("/api/**").hasAnyAuthority("ADMIN","USER");
		//http.authorizeRequests().antMatchers("/airline/**").hasAnyAuthority("ADMIN","USER");
		http.authorizeRequests().antMatchers("/api/currentuser/**").permitAll();
		http.authorizeRequests().antMatchers("/currentuser").permitAll();
		http.authorizeRequests().antMatchers("/api/**").permitAll();
		http.authorizeRequests().antMatchers("/api/jobapi/**").permitAll();
		http.authorizeRequests().antMatchers("/jobapi/**").permitAll();
		http.authorizeRequests().antMatchers("/jobByPrix/**").permitAll();
		http.authorizeRequests().antMatchers("/getUsercv/**").permitAll();
		http.authorizeRequests().antMatchers("/cv/**").permitAll();
		http.authorizeRequests().antMatchers("/postuler/**").permitAll();
		http.authorizeRequests().antMatchers("/api/profilcvview/**").permitAll();
		http.authorizeRequests().antMatchers("/favorit/**").permitAll();
		
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("ADMIN","USER");
		
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADMIN");
	
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN");
		
		http.authorizeRequests().antMatchers("/login").permitAll();
		
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
		
	}
}