package com.hugui.oauth.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author HuGui
 * @class com.hugui.oauth.configuration ResourceServerConfig.java
 * @date 2018年6月24日
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
    .and()
        .authorizeRequests()
        .anyRequest().authenticated()
    .and()
        .httpBasic();
	}
	
}
