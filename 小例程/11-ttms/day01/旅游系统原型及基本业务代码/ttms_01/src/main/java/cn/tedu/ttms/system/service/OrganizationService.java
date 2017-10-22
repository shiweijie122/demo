package cn.tedu.ttms.system.service;

import java.util.Map;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.system.entity.Organization;

public interface OrganizationService {
	/**
	 * 分页获得组织机构信息
	 * @param orgInfo
	 * @param pageObj
	 * @return
	 */
	Map<String,Object> findObjects(Organization orgInfo, PageObject pageObj);

    /**
     * 禁用，启用组织结构信息
     * @param id
     * @param valid
     * @param user
     */
    void validById(Integer id,Integer valid,String user);
    /**
     * 保存组织机构信息
     * @param projectInfo
     */
    void saveObject(Organization orgInfo);
    /**
     * 根据id查找组织结构
     * @param orgId
     * @return
     */
    Map<String,Object>findById(String orgId);
    /**
     *更新组织机构信息
     * @param orgInfo
     */
    void updateObject(Organization info);

}
