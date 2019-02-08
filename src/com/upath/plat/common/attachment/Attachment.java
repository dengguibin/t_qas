package com.upath.plat.common.attachment;

import java.io.File;
import java.io.Serializable;

import com.upath.plat.common.modules.model.TCommonDocument;
import com.upath.plat.common.util.SystemConfig;

@SuppressWarnings("serial")
public class Attachment extends TCommonDocument implements IAttachment,Serializable {

	public String getAttachmentId() {
		return getDocid();
	}

	public File getFile() {
		return new File(SystemConfig.ATTACHMENT_SAVE_DIR+getPath());
	}

	public String getFileOsPath() {
		return getPath();
	}

}
