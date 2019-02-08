package com.upath.plat.common.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.modules.model.TRmsAlllogs;
import com.upath.plat.common.modules.service.TRmsAlllogsService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.StringUtil;
import com.upath.plat.common.util.SystemConfig;

/**
 * 经过此过滤器的所有 URL 都记录下此次访问的日志记录过程 情况
 * 
 * 目录是直接记录到数据库
 * 
 * 如果有JMS服务，建议把此功能以消息的形式发发到服务端，请服务端来记录此消息
 * 这样的话就可以节约相关资源
 * @author Administrator
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class SystemRequestLogFilter implements Filter {

	
	private final static Logger logger = Logger.getLogger(SystemRequestLogFilter.class);
	
	private TRmsAlllogsService service  = null; 
	
	private ThreadPoolExecutor executor; 
	
	private String workIp = null;
	
	private String worker = null;
	
	private String mac = null;
	/**
	 * 
	 */
	private  static Set<String> excludeURL = Collections.EMPTY_SET;
	
	private final static String COMMA = ",";
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String ctx = request.getContextPath();
		String uri = request.getRequestURI();
			 uri = uri.substring(ctx.length(), uri.length());
			 if(acceptURI(uri) == false && "/".equals(uri) == false){
				 TRmsAlllogs bean = new TRmsAlllogs();
				 //初始化参数
				this.initLogBean(request, bean);
				//成功状态
				int status = 1;
				String message = null;
				try{
					 chain.doFilter(req, res);
					 //如果是Struts2 框架 框架 会把异常信息给捕捉到不进行任何抛出
				}catch(Exception e){
					status = 0;
					message = e.getMessage();
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				
				
				//如果是Struts2 框架 把异常信息放到队列当中
				Object valueStack = null;
				if(( valueStack = req.getAttribute("struts.valueStack") )  != null ){
					if(valueStack instanceof ValueStack){
						ValueStack stack = (ValueStack)valueStack;
						Object ex = stack.findValue("exceptionStack");
						if(ex != null ){
							status = 0;
							message = ex.toString();
						}
					}
				}
				bean.setErrors(message);
				//是否操作成功
				bean.setOpresult(status);
				try{
				//	service.insert(bean);
					Map params = null;
					if(req.getParameterMap() != null){
						params = req.getParameterMap();
					}
					//使用线程起动 记录日志
					executor.execute(new RequestLogThread(bean, service, params));
				}catch(Exception e){
					logger.error(e.getMessage());
					e.printStackTrace();
				}
				
			 }else{
				 chain.doFilter(req, res);
			 }
	}
	
	protected void initLogBean(HttpServletRequest request,TRmsAlllogs bean){
		if(bean != null){
			 IUser user =   (IUser)request.getSession().getAttribute(PlatConstant.SESSION_USER);	
			 String remoteIp = RequestHelper.getRemoteAddr(request);
			 if(user != null){
				 bean.setAccount(user.getUserId());
			 }
			 bean.setLogid(IDGenerator.getDateId());
			 String uri = request.getRequestURI();
			 bean.setSid(request.getSession().getId());
			 bean.setPlatid(SystemConfig.SYSTEM_ID);
			 bean.setCjsj(new Date());
			 bean.setAddr(remoteIp);
			 bean.setWorker(this.worker);
			 bean.setWorkip(this.workIp);
			 bean.setMac(this.mac);
			 bean.setLogtime(new Date());
			 bean.setUrl(uri);
			 bean.setParams(request.getQueryString());
			 //默认没有解释
			 bean.setStatus(0);
		}
		
		
	}

	
	
	public void init(FilterConfig config) throws ServletException {
			service = 	(TRmsAlllogsService) PlatUtil.getApplicationContext().getBean("tRmsAlllogsService");
			executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			try{  
		            InetAddress address = InetAddress.getLocalHost();  
		            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
		            //ni.getInetAddresses().nextElement().getAddress();  
		            byte[] mac = ni.getHardwareAddress();
		            this.worker = address.getHostName();
		            this.workIp = address.getHostAddress();  
		            String sMAC = "";  
		            Formatter formatter = new Formatter();
		            if(mac!=null)
		            for (int i = 0; i < mac.length; i++) {  
		                sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i],  
		                        (i < mac.length - 1) ? "-" : "").toString();  
		  
		            }  
		            this.mac = sMAC;
		        }catch(Exception e){  
		            e.printStackTrace();  
		        } 
			 
				String urls = config.getInitParameter("excludeURL");
				logger.info("需要忽略的访问配置："+urls);
				if(StringUtil.isEmpty(urls) == false){
					String arr[] = urls.split(COMMA);
					excludeURL = new HashSet<String>();
						if(arr != null){
								for(int i = 0 ; i < arr.length ; i++){
									excludeURL.add(arr[i]);
								}
						}
				} 
	}
	
	
	public boolean acceptURI(String uri){
		boolean result = false;
		for(String config : excludeURL){
				if(config.equals(uri) || uri.startsWith(config)){
					result = true;
					break;
				}
		}
		return result;
	}
	
	public void destroy() {
		
	}
}
