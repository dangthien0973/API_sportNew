/*
 * package API_sportNew.filter;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * public class CustomAuthenticationFilter extends
 * UsernamePasswordAuthenticationFilter { private AuthenticationManager
 * authenticationManager; public
 * CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
 * this.authenticationManager =authenticationManager; }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException {
 * 
 * // TODO Auto-generated method stub return
 * super.attemptAuthentication(request, response);
 * 
 * }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException { // TODO Auto-generated method stub
 * super.successfulAuthentication(request, response, chain, authResult); }
 * 
 * 
 * }
 */