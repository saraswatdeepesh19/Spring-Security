package com.deepesh.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests().anyRequest().authenticated(); // To authenticate All the Requests
		http
				.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/myAccount", "/myLoan", "/myCard", "/myBalance")
				.authenticated().requestMatchers("/myContact", "/myNotice", "/register").permitAll();
		http.formLogin();
		http.httpBasic();
		return http.build();

	}

	/*** Approach 1 where we use withDefaultPasswordEncoder() method
	 * while creating the user details
	 *//*

	 *//*@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.authorities("admin")
				.build();
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.authorities("read")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}*//*

	 */

	/***
	 * Approach 2 where we use NoOpPasswordEncoder Bean
	 * 		while creating the user details*
	 *//*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager(){
		UserDetails admin =User.withUsername("admin")
				.password("admin")
				.authorities("admin")
				.build();
		UserDetails user =User.withUsername("user")
				.password("user")
				.authorities("read")
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}*/
	/*@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}*/

	/**
	 * NoOpPasswordEncoder is not recommended for production usage.
	 * Use only for non-prod.
	 *
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
