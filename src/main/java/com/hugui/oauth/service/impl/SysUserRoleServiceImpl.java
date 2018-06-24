package com.hugui.oauth.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hugui.oauth.entity.SysUserRole;
import com.hugui.oauth.mapper.SysUserRoleMapper;
import com.hugui.oauth.service.ISysUserRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hugui123
 * @since 2018-06-24
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

	@Autowired
	private SysUserRoleMapper mapper;
	
	@SuppressWarnings("rawtypes")
	public List<Map> findAuthoritiesByUserId(@Param("id") Long id){
		return mapper.findAuthoritiesByUserId(id);
	}
}
