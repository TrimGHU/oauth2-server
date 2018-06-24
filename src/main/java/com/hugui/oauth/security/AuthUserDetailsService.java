package com.hugui.oauth.security;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hugui.oauth.entity.SysUser;
import com.hugui.oauth.service.ISysUserRoleService;
import com.hugui.oauth.service.ISysUserService;

/**
 * @author HuGui
 * @class com.hugui.oauth.security AuthUserDetailsService.java
 * @date 2018年6月24日
 */

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@SuppressWarnings("rawtypes")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String lowcaseUsername = username.toLowerCase();
		SysUser sysUser = sysUserService
				.selectOne(new EntityWrapper<SysUser>(SysUser.builder().username(lowcaseUsername).build()));

		if (sysUser == null) {
			throw new UsernameNotFoundException("用户" + lowcaseUsername + "不存在!");
		}

		// 根据用户信息查询所包含权限（redis缓存支持）
		List<Map> authorityList = sysUserRoleService.findAuthoritiesByUserId(sysUser.getId());

		if (authorityList == null || authorityList.isEmpty()) {
			return new User(sysUser.getUsername(), sysUser.getPassword(), null);
		}

		Set<GrantedAuthority> userAuthotities = new HashSet<>();
		for (Map authMap : authorityList) {
			userAuthotities.add(new SimpleGrantedAuthority(String.valueOf(authMap.get("authName"))));
		}

		return new User(sysUser.getUsername(), sysUser.getPassword(), userAuthotities);
	}

}
