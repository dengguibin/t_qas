package com.upath.plat.common.attachment;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TCommonDocument;
import com.upath.plat.common.modules.service.TCommonDocumentService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.SystemConfig;

/**
 * 系统文档的管理接口 管理类
 * 
 * @author Administrator
 *
 */
public class AttachmentsManager {

	private static final Logger log = Logger
			.getLogger(AttachmentsManager.class);

	private TCommonDocumentService service;

	public AttachmentsManager() {

	}

	public static AttachmentsManager getInstance() {
		AttachmentsManager manager = (AttachmentsManager) PlatUtil
				.getApplicationContext().getBean("attachmentsManager");
		return manager;
	}

	public boolean acceptAttachments(String fileName) {
		if (fileName != null && "".equals(fileName.trim()) == false) {
			int index = fileName.lastIndexOf('.');
			if (index > -1) {
				String hz = fileName.substring(fileName.lastIndexOf('.') + 1,
						fileName.length());
				String uString = SystemConfig.ATTACHMENT_SUFFIX_TYPE
						.toUpperCase();
				String uHz = hz.toUpperCase();
				if (uString.indexOf(uHz) > -1) {
					return true;
				}
			}
		}
		return false;
	}

	public IAttachment uploadAttachments(String fileName, File uploadFile,
			String modulName, String businessId) {
		String fileNames[] = new String[] { fileName };
		File uploadFiles[] = new File[] { uploadFile };
		return uploadAttachments(fileNames, uploadFiles, modulName, businessId)[0];
	}

	/**
	 * 
	 * @param fileNames
	 *            文件的真实名称，数组格式
	 * @param uploadFiles
	 *            真实需要上传的文件，数组格式，请保证文件的存在
	 * @param modulName
	 *            模块功能名称，自己定义，方法会以此名称来生成一个 目录信息保存文件
	 * @param businessId
	 *            调用 的业务模块的 业务组件 ID，此组件ID是需要在后面查询中使用的，确保此ID是保存到数据当中的业务主键ID
	 * @return 生成到数据库的附件信息
	 */
	public IAttachment[] uploadAttachments(String[] fileNames,
			File[] uploadFiles, String modulName, String businessId) {
		if (modulName == null || "".equals(modulName.trim()) == true) {
			throw new PlatformException("附件上传模块名称不能为空");
		}

		if (businessId == null || "".equals(businessId.trim()) == true) {
			throw new PlatformException("附件上传业务ID不能为空");
		}

		if (fileNames == null || uploadFiles == null || fileNames.length == 0
				|| uploadFiles.length == 0) {
			throw new PlatformException("上传的附件信息不为空");
		}

		if (fileNames.length != uploadFiles.length) {
			throw new PlatformException("上传的附件名称和文件个数不相等");
		}

		IAttachment[] attachments = new IAttachment[uploadFiles.length];
		for (int i = 0; i < fileNames.length; i++) {
			String fileName = fileNames[i];
			File file = uploadFiles[i];
			if (file.exists() == false) {
				throw new PlatformException("上传的附件:" + fileName + "不存在，请检查文件。");
			}
			if (acceptAttachments(fileName) == false) {
				throw new PlatformException("系统不允许上传的文件类型：" + fileName
						+ ",文件后缀必须以以下结尾：" + SystemConfig.ATTACHMENT_SUFFIX_TYPE);
			}
			attachments[i] = renderStore(file, fileName, null, modulName,
					businessId);
		}
		for (int i = 0; i < attachments.length; i++) {
			service.insert((TCommonDocument) attachments[i]);
		}
		return attachments;
	}

	Attachment renderStore(File item, String name, String type,
			String modulName, String businessId) {
		Attachment store = new Attachment();
		try {
			store.setDocid(IDGenerator.getId());
			store.setModuleid(modulName);
			store.setBusinessid(businessId);
			// 此时文件应该在系统的临时文件件中。
			store.setSize(FileUtils.byteCountToDisplaySize(item.length()));
			store.setName(name);
			String hz = name
					.substring(name.lastIndexOf('.') + 1, name.length());
			store.setSubfix(hz);
			// store.(item.getContentType());
			try {
				IUser user = RequestHelper.getInstance().getLoginUser();
				if (user != null) {
					store.setCjr(user.getUserId());
					if (store.getAuthor() == null) {
						store.setAuthor(user.getUserId());
					}
				}
			} catch (Exception e) {
				// 在非WEB环境上下文的情况 下面会找不到当前的的用户
				log.warn(e.getMessage());
			}

			store.setContent(type);
			store.setType(0);
			store.setState(1);
			store.setCjsj(new Date());

			String realpath = SystemConfig.ATTACHMENT_SAVE_DIR;
			;
			String location = File.separatorChar + "系统附件" + File.separatorChar
					+ store.getModuleid() + File.separatorChar;
			// 文档的相对路径地址
			// store.setWdms(location+store.getWdbt());

			String filePath = realpath + location;
			File savePath = new File(filePath);
			if (!savePath.exists()) {
				savePath.mkdir();
			}
			store.setPath(location + store.getDocid() + "." + store.getSubfix());
			File ft = new File(realpath, store.getPath());
			FileUtils.copyFile(item, ft);
		} catch (Exception e) {
			log.error(e);
		}
		return store;

	}

	/**
	 * 
	 * 此功能目前是以单条的形式来查询数据库信息 考虑后面的性能问题可以进行调整此功能的查询方式
	 * 
	 * @param attachmentIds
	 *            返回的附件主键信息
	 * @param businessId
	 *            业务模块的ID值
	 * @return
	 */
	public IAttachment[] getAttachments(String[] attachmentIds,
			String businessId) {
		if (businessId == null || "".equals(businessId.trim()) == true) {
			throw new PlatformException("附件上传业务ID不能为空");
		}
		if (attachmentIds == null || attachmentIds.length == 0) {
			throw new PlatformException("需要查询的附件ID信息不能为空");
		}
		IAttachment[] ats = new IAttachment[attachmentIds.length];
		TCommonDocument params = new TCommonDocument();
		params.setBusinessid(businessId);
		ConvertUtils.register(new DateConverter(null), java.util.Date.class); 
		for (int i = 0; i < attachmentIds.length; i++) {
			String docId = attachmentIds[i];
			params.setDocid(docId);
			TCommonDocument dsDoc = service.select(params);
			if (dsDoc != null) {
				IAttachment attrm = new Attachment();
				try {
					BeanUtils.copyProperties(attrm, dsDoc);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				ats[i] = attrm;
			} else {
				ats[i] = null;
			}
		}

		return ats;
	}

	public boolean[] removeAttachments(String[] attachmentIds, String businessId) {
		if (businessId == null || "".equals(businessId.trim()) == true) {
			throw new PlatformException("附件上传业务ID不能为空");
		}
		if (attachmentIds == null || attachmentIds.length == 0) {
			throw new PlatformException("需要查询的附件ID信息不能为空");
		}
		boolean results[] = new boolean[attachmentIds.length];
		IAttachment[] attachments = getAttachments(attachmentIds, businessId);
		if (attachments != null) {
			for (int i = 0; i < attachments.length; i++) {
				IAttachment attachment = attachments[i];
				if (attachment != null) {
					service.delete((TCommonDocument) attachment);
					// 保证文件不在这里进行删除 此功能不进行实现,考虑会后面使用调度器每周运行一次来清除信息
					// attachment.getFile().renameTo("");
					results[i] = true;
				}
			}
		}
		return results;
	}

	public boolean removeAttachments(String attachmentId, String businessId) {
		String[] attachmentIds = new String[] { attachmentId };
		return removeAttachments(attachmentIds, businessId)[0];
	}

	public IAttachment getAttachments(String attachmentId, String businessId) {
		String[] attachmentIds = new String[] { attachmentId };
		return getAttachments(attachmentIds, businessId)[0];
	}

	public TCommonDocumentService getService() {
		return service;
	}

	public void setService(TCommonDocumentService service) {
		this.service = service;
	}

}
