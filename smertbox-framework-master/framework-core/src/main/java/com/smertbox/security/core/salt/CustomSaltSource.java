package com.smertbox.security.core.salt;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

import com.smertbox.util.properties.PropertiesUitl;

public class CustomSaltSource implements SaltSource{

	@Override
	public Object getSalt(UserDetails user) {
		
		return user.getUsername()+PropertiesUitl.getInstance().getProperty("spring-security/security.properties", "security.passwordencoder.salt");
	}

}
