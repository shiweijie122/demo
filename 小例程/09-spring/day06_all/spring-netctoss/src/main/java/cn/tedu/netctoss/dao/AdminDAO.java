package cn.tedu.netctoss.dao;

import cn.tedu.netctoss.entity.Admin;

/**
 * 持久层接口(数据访问接口)
 *
 */
public interface AdminDAO {
	public Admin findByCode(String code);
	
	
}
