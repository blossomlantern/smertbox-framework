package com.smertbox.api.attachment.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smertbox.api.attachment.mapper.CmAttachmentMapper;
import com.smertbox.api.attachment.model.CmAttachment;
import com.smertbox.util.properties.PropertiesUitl;

@Service
public class AttachmentService {

	@Autowired
	CmAttachmentMapper cmAttachmentMapper;
	
	public CmAttachment findById(String attachmentId){
		return cmAttachmentMapper.selectByPrimaryKey(attachmentId);
	}
	
	public CmAttachment findByPrimaryKey(String attachmentId){
		return cmAttachmentMapper.selectByPrimaryKey(attachmentId);
	}
	
	public void insert(CmAttachment cmAttachment){
		cmAttachmentMapper.insertSelective(cmAttachment);
	}
	
	public void update(CmAttachment cmAttachment){
		cmAttachmentMapper.updateByPrimaryKeySelective(cmAttachment);
	}
	
	public void deleteByPrimaryKey(String attachmentId){
		cmAttachmentMapper.deleteByPrimaryKey(attachmentId);
	}
	
	public List<CmAttachment> selectPage(CmAttachment attachment) {
		return cmAttachmentMapper.selectPage(attachment);
	}

	public int selectPageSize(CmAttachment attachment) {
		return cmAttachmentMapper.selectPageSize(attachment);
	}

	public CmAttachment selectByPrimaryKey(String attachmentId) {
		return cmAttachmentMapper.selectByPrimaryKey(attachmentId);
	}
	
	/**
	 * 检查传入的附件对象的物理状态
	 * @param list
	 * @return
	 */
	public List<CmAttachment> checkPhysicalState(List<CmAttachment> list){
		if(list != null && list.size() > 0){
			String dir = PropertiesUitl.getInstance().getSystemProperty("attachment.upload.dir");
			for (int i = 0; i < list.size(); i++) {
				CmAttachment attachment = list.get(i);
				if(attachment != null){
					File file = new File(dir + attachment.getRelativeAddr());
					if(file.exists()){
						list.get(i).setPhysicalState((short) 1);
					}else{
						list.get(i).setPhysicalState((short) 0);
					}
				}
			}
		}
		return list;
	}
}
