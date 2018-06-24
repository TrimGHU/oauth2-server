package com.hugui.oauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuGui
 * @class com.hugui.oauth.controller UserController.java
 * @date 2018年6月24日
 */

@RestController
public class UserController {

	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

}
