package com.ecommerce.ShoppingApp.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.entity.Roles;
import com.ecommerce.ShoppingApp.repository.UserRepository;

@Component
public class UserPasswordAuthentication implements AuthenticationProvider{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String email = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Person person = userRepository.findByPersonEmail(email);
		System.out.println(person+" "+email+" "+pwd);
		if(person!=null && pwd.equals(person.getPersonPassword()))
		{
			return new UsernamePasswordAuthenticationToken(
                    email, pwd, getGrantedAuthorities(person.getRole()));
		}
		 throw new BadCredentialsException("Invalid credentials!");
	}

	private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
