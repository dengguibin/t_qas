package com.upath.plat.common.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;


/**
 * @author upaths
 * version 1.0.0
 * create date :2012-9-22 
 * modify time
 * 系统缓存标签，主要包括一些字典等系统常用缓存变量，在页面中进行数据展示使用
 */
@SuppressWarnings({"serial", "unchecked" })
public class CacheTag extends BaseTage{

	//字典主科目
	private String subject;
	//保存范围 pageScope requestScope  sessionScope applicationScope
	
	private String key;
	
	// true  false 是否输出 option 选项
	private boolean option;
	
	//在OPTION 输出中指定默认选中值 
	private String selected;

	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException {
		if(StringUtils.isEmpty(subject) == false){
		List<ICacheCode> codes = CacheManager.getInstance().getCodes(subject);
		if(codes != null){
			ICacheCode code = null;	
			if(StringUtils.isEmpty(key) == false){
					for(ICacheCode c : codes){
						if(key.equals(c.getSubcode()) == true){
							code = c;
							break;
						}
					}
					
				}
			//如果是要构建 HTML OPTION 项
			if(option == true){
				StringBuffer buffer = null;
				if( StringUtils.isEmpty(key) == false && code != null){
					List<ICacheCode> result = new ArrayList<ICacheCode>();
					result.add(code);
					buffer = builderOptions(result);
				}else{
					buffer = builderOptions(codes);
				}
				//如果变量不为空，则通过指定的上下文 放入变量中
				if(var != null){
					bindScopeData(var,buffer);
				}else{
					try {
						//直接输出
						this.pageContext.getOut().print(buffer);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else{
				//如果变量不为空，则通过指定的上下文 放入变量中
				if(var != null){
					if( StringUtils.isEmpty(key) == false && code != null){
						bindScopeData(var,code);
					}else{
						bindScopeData(var,codes);
					}
				}else{
					if(code != null){
						try {
							//直接输出
							this.pageContext.getOut().print(code.getCname());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			}
			
		}
		
	
		return this.SKIP_BODY;
	}

	
	
	StringBuffer builderOptions(List<ICacheCode> codes){
		StringBuffer buffer = new StringBuffer();
		for(ICacheCode c : codes){
				if(c.getSubcode().equals(selected) == true){
					buffer.append("<option value=\""+c.getSubcode()+"\"  selected=\"selected\">"+c.getCname()+"</option>\r\n");
				}else{
					buffer.append("<option value=\""+c.getSubcode()+"\">"+c.getCname()+"</option>\r\n");
				}
		}
		return buffer;
	}
	
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}
	
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isOption() {
		return option;
	}

	public void setOption(boolean option) {
		this.option = option;
	}
	

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
}
