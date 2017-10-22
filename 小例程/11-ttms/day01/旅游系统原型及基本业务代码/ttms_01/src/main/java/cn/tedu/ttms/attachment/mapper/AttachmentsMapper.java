package cn.tedu.ttms.attachment.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.attachment.entity.Attachement;


public interface AttachmentsMapper {

	List<Map<String,Object>> findAttachmentsListByProdId(@Param("prodId")Integer prodId);

	int saveProductAttachment(@Param("attachment")Attachement attachement);

	Integer isExistFile(@Param("digest")String digest, @Param("belongId")Integer belongId);

	int changeAttachmentState(@Param("attachmentId")Integer attachmentId, @Param("valid")int valid, @Param("userName")String userName);

	Map<String, Object> findFilePathById(@Param("attachmentId")Integer attachmentId);
}
