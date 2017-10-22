package cn.tedu.ttms.guide.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.guide.entity.GuidesInfo;

public interface GuidesInfoMapper {

	List<Map<String, Object>> findGuides(@Param("guidesInfo")GuidesInfo guidesInfo, @Param("pageObj")PageObject pageObj);

	int getGuidesRowCounts(@Param("guidesInfo")GuidesInfo guidesInfo);
}
