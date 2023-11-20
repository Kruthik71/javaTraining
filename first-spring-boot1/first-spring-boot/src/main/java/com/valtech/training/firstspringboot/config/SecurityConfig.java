package com.valtech.training.firstspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.components.Airthemetic;
import com.valtech.training.firstspringboot.components.AirthemeticImpl;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.components.SimpleInterestImpl;

@Configuration
public class SecurityConfig {
	
//	@Bean
//	public Airthemetic airthemetic() {
//		return new AirthemeticImpl();
//	}
//	
//	@Bean
//	public SimpleInterest simpleInterest(Airthemetic airthemetic) {
//		return new SimpleInterestImpl(airthemetic);
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		
		.antMatchers("/user","/orders/**","/hello","/changepassword","/employees/**")
		.hasAnyRole("USER","ADMIN")
		
		.antMatchers("/admin")
		.hasRole("ADMIN")
		
		.antMatchers("/anon","/login","/logout","/register")
		.anonymous()
		
		.anyRequest()
		.authenticated();
		
		//Basic authentication of Http
//		http.httpBasic();
		
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello?name=Valtech")
		.failureUrl("/login?error=true");
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		UserDetails kruthik=User.builder().username("Kruthik").password("cooluser").roles("USER").build();
//		UserDetails admin=User.builder().username("Admin").password("cooladmin").roles("ADMIN","USER").build();
//		return new InMemoryUserDetailsManager(kruthik,admin);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}
	
}
