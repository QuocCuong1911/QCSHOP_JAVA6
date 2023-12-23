package com.jv6.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jv6.repository.AccountsRepository;
import com.jv6.service.AccountService;
import com.jv6.service.UserDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor

public class SecurityConfig {
	private final AccountsRepository accRepo;

//	private final AccountService accService;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailService(accRepo);
	}

	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		String staticResources = "/static/**";

		http.authorizeHttpRequests((authorize) -> 
			authorize.requestMatchers("/product/**").authenticated()
			.requestMatchers("/order/**").authenticated()
//			.requestMatchers("/qcshop/signup/newaccount").permitAll()
//			.requestMatchers(staticResources).permitAll()
			.anyRequest().permitAll())
			.csrf(csrf -> csrf.disable())
			.formLogin((login) -> 
			login.loginPage("/qcshop/login")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/qcshop/login/success", false)
			.failureUrl("/qcshop/login/error"))
			.logout((logout) ->
			logout.logoutUrl("/qcshop/logout")
			.logoutSuccessUrl("/qcshop/login")
			.permitAll());

//		http.formLogin((log) -> 
//		log.loginPage("/qcshop/login")
//		.loginProcessingUrl("/security/login")
//		.defaultSuccessUrl("/qcshop/login/success", false)
//		.failureUrl("/qcshop/login/error")
//		);
		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auProvider = new DaoAuthenticationProvider();
		auProvider.setUserDetailsService(userDetailsService());
		auProvider.setPasswordEncoder(passEncoder());
		return auProvider;
	}
}
