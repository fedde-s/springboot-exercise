package nl.thehyve.fedde.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableGlobalMethodSecurity
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private enum ApiRole {
        API_USER;
    }

    /**
     * Define the realm of users to allow.
     *
     * @param auth  builder bean to build the Authentication Manager
     * @param username  the username to accept
     * @param password  the password to accept
     * @throws Exception  if an error occurs when adding the authentication
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
            @Value("${api.username}") String username,
            @Value("${api.username}") String password) throws Exception {
        auth.inMemoryAuthentication().withUser(username).password(password).roles(ApiRole.API_USER.toString());
    }

    // TODO: figure out what to do with inner class black magic

}
