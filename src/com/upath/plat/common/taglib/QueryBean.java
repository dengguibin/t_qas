package com.upath.plat.common.taglib;

import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.components.template.Template;
import org.apache.struts2.components.template.TemplateEngine;
import org.apache.struts2.components.template.TemplateRenderingContext;
import org.apache.struts2.views.freemarker.FreemarkerManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.ValueStack;
import com.upath.plat.common.cache.ISqlTemplate;
import com.upath.plat.common.util.RequestHelper;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
@SuppressWarnings({ "rawtypes", "unused" })
public class QueryBean extends UIBean {

	protected FreemarkerManager freemarkerManager;

	private final static String TEMPLATE = "empty";
	
	protected ISqlTemplate iSqlTemplate;
	
	public QueryBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
			super(stack, request, response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Inject
	public void setFreemarkerManager(FreemarkerManager mgr) {
		this.freemarkerManager = mgr;
	}

	public FreemarkerManager getFreemarkerManager() {
		return this.freemarkerManager;
	}
	
	  protected void mergeTemplate(Writer writer, Template template) throws Exception {
	        final TemplateEngine engine = templateEngineManager.getTemplateEngine(template, templateSuffix);
	        final TemplateRenderingContext context = new TemplateRenderingContext(template, writer, getStack(), getParameters(), this);
	        renderTemplate(context);
	    }
	
	 public void renderTemplate(TemplateRenderingContext templateContext) throws Exception {
	        ValueStack stack = templateContext.getStack();
	        Map context = stack.getContext();
	        ServletContext servletContext = (ServletContext) context.get(ServletActionContext.SERVLET_CONTEXT);
	        HttpServletRequest req = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
	        HttpServletResponse res = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
	        Enumeration<String> paramNames =   req.getParameterNames();
	      /**
	       * 把请求参数 放入 Action Stack当中 。
	       * 如果 直接 使用Parameter['key'] 直接 判定数据存在一定的不方便性
	       * 最大的不方便处就是 此方法将返回数据的数组 不方便数据的判定
	       */
	        Map<String, String> params = new HashMap<String, String>();
	        while(paramNames.hasMoreElements() == true){
	        String param =	paramNames.nextElement();
	        	String val = 	req.getParameter(param);
	        	params.put(param, val);
	        }
	        /**
	         * 所有讲求参数传入上下文件当中 
	         */
	        stack.set("params", params);
	        /**
	         * 当前用户信息传入上下文件当中 
	         */
	       
	        stack.set("user", RequestHelper.getInstance().getLoginUser());
	        Configuration config = freemarkerManager.getConfiguration(servletContext);
	        StringReader  reader = new StringReader(iSqlTemplate.getScripts());
	        freemarker.template.Template template = new freemarker.template.Template(iSqlTemplate.getId(),reader,config);;
	        ActionInvocation ai = ActionContext.getContext().getActionInvocation();
	        Object action = (ai == null) ? null : ai.getAction();
	        SimpleHash model = freemarkerManager.buildTemplateModel(stack, action, servletContext, req, res, config.getObjectWrapper());
	        model.put("tag", templateContext.getTag());
	       

	        // the BodyContent JSP writer doesn't like it when FM flushes automatically --
	        // so let's just not do it (it will be flushed eventually anyway)
	        Writer writer = templateContext.getWriter();
	        final Writer wrapped = writer;
	        writer = new Writer() {
	            public void write(char cbuf[], int off, int len) throws IOException {
	                wrapped.write(cbuf, off, len);
	            }

	            public void flush() throws IOException {
	            }

	            public void close() throws IOException {
	                wrapped.close();
	            }
	        };

	        try {
	            stack.push(templateContext.getTag());
	            template.process(model, writer);
	        } finally {
	            stack.pop();
	        }
	    }

	public ISqlTemplate getISqlTemplate() {
		return iSqlTemplate;
	}

	public void setISqlTemplate(ISqlTemplate sqlTemplate) {
		iSqlTemplate = sqlTemplate;
	}
}
