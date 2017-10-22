package cn.tedu.ttms.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.entity.Project;
import cn.tedu.ttms.product.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	/**ʹ��@Resourceע��Ϊ����ע��ֵʱ,�Ȱ����ֲ���,�����Ȱ����Ͳ���?====ֻ��setע��,�Ȱ����ֲ���*/
	@Resource
	private ProjectDao projectDao;
	
	/**��ѯ,��ȡ��Ŀ��Ϣ*/
	public List<Project> findObjects() {
		List<Project> list = projectDao.findObjects();
		return list;
	}

}
