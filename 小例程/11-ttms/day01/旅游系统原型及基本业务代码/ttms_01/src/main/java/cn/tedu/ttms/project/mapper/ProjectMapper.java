package cn.tedu.ttms.project.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.mapper.BaseMapper;
import cn.tedu.ttms.project.entity.Project;

public interface ProjectMapper extends BaseMapper<Project>{

	List<Integer> findPrjIdsByName(@Param("prjName")String prjName);

}
