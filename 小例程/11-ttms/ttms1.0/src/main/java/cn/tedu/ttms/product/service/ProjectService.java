package cn.tedu.ttms.product.service;

import java.util.List;

import cn.tedu.ttms.product.entity.Project;

/**
 * ��Ŀ����ģ���ҵ������:
 * ���������Ŀ��Ϣ��ҵ����
 */
public interface ProjectService {
	/**���������Ŀ��Ϣ*/
	List<Project> findObjects();
}
