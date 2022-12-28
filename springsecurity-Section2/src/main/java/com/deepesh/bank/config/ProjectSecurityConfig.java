package com.deepesh.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests().anyRequest().authenticated(); // To authenticate All the Requests
		http.authorizeHttpRequests()
				.requestMatchers("/myAccount","/myLoan","/myCard","/myBalance").authenticated()
						.requestMatchers("/myContact","/myNotice").permitAll();
		http.formLogin();
		http.httpBasic();
		return (SecurityFilterChain) http.build();

		/**
		 *  Configuration to deny all the requests
		 */
        /*http.authorizeHttpRequests().anyRequest().denyAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();*/

		/**
		 *  Configuration to permit all the requests
		 */
		/*http.authorizeHttpRequests().anyRequest().permitAll();
		http.formLogin();
		http.httpBasic();
		return http.build();*/
	}

}
