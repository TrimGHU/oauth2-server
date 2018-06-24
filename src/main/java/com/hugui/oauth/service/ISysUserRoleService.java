package com.hugui.oauth.service;

import com.hugui.oauth.entity.SysUserRole;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hugui123
 * @since 2018-06-24
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

	@SuppressWarnings("rawtypes")
	List<Map> findAuthoritiesByUserId(@Param("id") Long id);
	
}
