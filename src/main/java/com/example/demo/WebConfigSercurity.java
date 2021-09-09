
  package com.example.demo;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import
  org.springframework.context.annotation.Bean; 
  import
  org.springframework.security.authentication.dao.DaoAuthenticationProvider;
  import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; 
  import
  org.springframework.security.config.annotation.authentication.configurers.
  provisioning.InMemoryUserDetailsManagerConfigurer; 
  import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; 
  import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import
  org.springframework.security.core.userdetails.User; 
  import
  org.springframework.security.core.userdetails.UserDetailsService; 
  import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
  import
  org.springframework.security.crypto.password.PasswordEncoder; 
  import
  org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.service.UserService; import
  com.example.service.UserServiceImpl;
  
  @EnableWebSecurity 
  public class WebConfigSercurity extends WebSecurityConfigurerAdapter {
  
	  @Autowired 
	  private UserService userDetailsService;
		
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//		  auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
//	  }
//		
	  @Bean 
	  public PasswordEncoder passwordEncoder() { 
		  return new BCryptPasswordEncoder(); 
	  }
  
	  @Autowired 
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
//		  http.csrf().disable()
//		  .authorizeRequests()
//		  .antMatchers("/admin","/api/v1/user/*").access("hasRole('ROLE_ADMIN')")
//		  .antMatchers("/user").access("hasRole('ROLE_USER')")
//		  .anyRequest().authenticated(); 
		  
		  http.csrf().disable()  
		  .addFilter(new JWAuthentication(authenticationManager()))
		  .addFilter(new JWAuthorize(authenticationManager(), userDetailsService))
		  .authorizeRequests()
		  .antMatchers("/admin","/api/v1/user/*").access("hasRole('ROLE_ADMIN')")
		  .anyRequest().authenticated()
		  .and()
		  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
	  
	
//	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
//	  Exception { auth.authenticationProvider(this.authenticationProvider()); }
//	 

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.addFilter(new JWAuthentication(authenticationManager())).formLogin().and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
	
//	@Bean
//	DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(passwordEncoder());
//		provider.setUserDetailsService(userDetailsService);
//		return provider;
//	}
	
  }
 