//package API_sportNew.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//import API_sportNew.service.UserServiceImpl;
//import antlr.StringUtils;
//
//public class AuthenticationFilter  extends OncePerRequestFilter {
//	 @Autowired
//
//	 private Jwt jwtUtils;
//	    @Autowired
//	    private UserServiceImpl userDetailsService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            String token = getTokenFromRequest(request);
//            if (token != null && jwtUtils.validatevaJwtToken(token)) {
//                String username = jwtUtils.getUserNameFromJwtToken(token);
//                UserDetails userDetails = userDetailsService.loadUserByUserName(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (Exception e) {
//            logger.error("Cannot set user authentication: {}", e);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String getTokenFromRequest(HttpServletRequest request) {
//        String token = request.getHeader("Authorization");
//
//        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
//            return token.substring(7, token.length());
//        }
//
//        return null;
//    }
//}
