package co.edu.unal.sam;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.unal.sam.aspect.handler.AuthenticationHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    private AuthenticationHandler authenticationHandler;

    @Inject
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(
                new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/enum/ **")
        .authenticated().antMatchers("/administrator/ **").authenticated()
        .antMatchers("/physicalactivity/classification").authenticated()
        .antMatchers("/physicalactivity/classificationdetail").authenticated().and()
                .formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
                .csrf().disable();
        http.formLogin().successHandler(this.authenticationHandler);
    }
}
