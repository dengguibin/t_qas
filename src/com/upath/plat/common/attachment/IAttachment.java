package com.upath.plat.common.attachment;

import java.io.File;

public interface IAttachment {

	//附件的ID
	String getAttachmentId();
	
	//文件名称
	String getName();
	
	//获取文件信息
	File getFile();
	
	//相对路径信息
	String getFileOsPath();
	
	//获取业务ID
	String getBusinessid();
	
	//文件名称的后缀
	String getSubfix();
	
}
