/*
 * package API_sportNew.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * import API_sportNew.service.UserService; import
 * API_sportNew.service.UserServiceImpl;
 * 
 * public class SecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * @Autowired private UserDetailsService userDetailsService; private
 * BCryptPasswordEncoder bCryptPasswordEncoder;
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { // TODO Auto-generated method stub
 * auth.userDetailsService(userDetailsService).passwordEncoder(
 * bCryptPasswordEncoder);
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { //
 * TODO Auto-generated method stub http.csrf().disable();
 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
 * STATELESS); http.authorizeHttpRequests().anyRequest().permitAll();
 * http.addFilter(null);
 * 
 * }
 * 
 * 
 * }
 */