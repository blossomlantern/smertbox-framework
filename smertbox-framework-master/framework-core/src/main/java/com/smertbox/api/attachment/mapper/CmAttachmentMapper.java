package com.smertbox.api.attachment.mapper;

import com.smertbox.api.attachment.model.CmAttachment;
import com.smertbox.api.attachment.model.CmAttachmentExample;
import com.smertbox.util.mapper.MyBatisRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface CmAttachmentMapper {
    int countByExample(CmAttachmentExample example);

    int deleteByExample(CmAttachmentExample example);

    int deleteByPrimaryKey(String attachmentId);

    int insert(CmAttachment record);

    int insertSelective(CmAttachment record);

    List<CmAttachment> selectByExample(CmAttachmentExample example);

    CmAttachment selectByPrimaryKey(String attachmentId);

    int updateByExampleSelective(@Param("record") CmAttachment record, @Param("example") CmAttachmentExample example);

    int updateByExample(@Param("record") CmAttachment record, @Param("example") CmAttachmentExample example);

    int updateByPrimaryKeySelective(CmAttachment record);

    int updateByPrimaryKey(CmAttachment record);

	List<CmAttachment> selectPage(CmAttachment attachment);

	int selectPageSize(CmAttachment attachment);
}