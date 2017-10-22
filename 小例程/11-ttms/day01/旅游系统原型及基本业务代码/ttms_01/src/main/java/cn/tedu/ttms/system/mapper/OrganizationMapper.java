package cn.tedu.ttms.system.mapper;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.base.mapper.BaseMapper;
import cn.tedu.ttms.system.entity.Organization;

public interface OrganizationMapper extends BaseMapper<Organization>{
	List<Integer> findObjectsByParentID(Integer id);
	List<Map<String,Object>> findObjectsByCode(String code);
}
