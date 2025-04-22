package application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import application.service.AppUserDataService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService TokenService;
    @Autowired
    private AppUserDataService userDataService;

    private String getToken(HttpServletRequest request){
        String AuthHeader = request.getHeader("Authorization");
        if(AuthHeader != null){
            return AuthHeader.replace("Bearer", "");
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
}
