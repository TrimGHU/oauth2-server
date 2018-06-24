package com.hugui.oauth.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hugui.oauth.entity.SysUserRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hugui123
 * @since 2018-06-24
 */

@CacheConfig(cacheNames = "userauth")
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	@SuppressWarnings("rawtypes")
	@Cacheable(key = "'auths_' + #p0")
	List<Map> findAuthoritiesByUserId(@Param("id") Long id);
	
}
