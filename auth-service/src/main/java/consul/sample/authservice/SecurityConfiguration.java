package consul.sample.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by admin1 on 22/6/17.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authenticationProvider;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder authBuilder)
            throws Exception {
        authBuilder.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .httpBasic().disable()

                .exceptionHandling()
                .accessDeniedPage("/403")

                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/logout/**", "/health/**", "/")
                .permitAll()
                .anyRequest()
                .authenticated()

                .and()


                .formLogin()
                .usernameParameter("username")
                .loginProcessingUrl("/loginProcessing")
                .and()
        ;
    }
}
