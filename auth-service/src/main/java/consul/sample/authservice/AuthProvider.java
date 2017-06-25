package consul.sample.authservice;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by admin1 on 22/6/17.
 */

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UsernamePasswordAuthenticationToken authenticationToken = null;
        if("jogireddy".equalsIgnoreCase(username)) {
            authenticationToken = new UsernamePasswordAuthenticationToken(username, authentication.getCredentials(), getAuthorities(Role.ROLE_ADMIN));
        } else {
            authenticationToken = new UsernamePasswordAuthenticationToken(username, authentication.getCredentials(), getAuthorities(Role.ROLE_USER));
        }
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(role != null)
        {

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            authorities.add(authority);

        }
        return authorities;
    }

    private enum Role {
        ROLE_ADMIN, ROLE_USER;
    }
}
