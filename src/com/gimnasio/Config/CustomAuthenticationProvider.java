package com.gimnasio.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomUserDetailsService customUserDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//Datos del formulario de login
		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();
		
		User user = (User) customUserDetailService.loadUserByUsername(principal);
		
		if(user != null)
		{
			if(passwordEncoder.matches(credentials, user.getPassword()))
			{
				System.out.println("Login correcto");
				return new UsernamePasswordAuthenticationToken(principal, credentials, user.getAuthorities());
			}
			else
			{
				System.out.println("Error de login: " + principal);
				throw new BadCredentialsException("Error de login. CONTRASEÑA INCORRECTA");
			}
		}
		else
		{
			System.out.println("Error de login: " + principal);
			throw new BadCredentialsException("Error de login. EMAIL INCORRECTO");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
