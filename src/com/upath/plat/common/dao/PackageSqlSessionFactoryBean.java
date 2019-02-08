package com.upath.plat.common.dao;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;
/**
 * 
 * @author Administrator
 *实现 sqlSessionFactory 通配置配置的实现
 *
 *typeAliasesPackage
 */
public class PackageSqlSessionFactoryBean extends SqlSessionFactoryBean {

	private static final Logger log = Logger.getLogger(PackageSqlSessionFactoryBean.class);
	
	private static String PRE_FLAG = "jar!";
	
	public void setTypeAliasesPackage(String typeAliasesPackage) {
		if(typeAliasesPackage != null){
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			String configs[] = typeAliasesPackage.split(",");
			StringBuffer buffer = new StringBuffer();
			if(configs != null){
				for(int i = 0 ; i < configs.length ; i++){
					String matcher  = configs[i];
					try {
						Resource res[] =  resolver.getResources(matcher.trim().replace(".", "/"));
						if(res != null){
							for(int j = 0 ; j < res.length ; j++){
								if(buffer.length() != 0){
									buffer.append(",");
								}
								String path = "";
								URL url = res[j].getURL();
								if(ResourceUtils.isJarURL(url)){
									String str = url.toString();
									int index = str.indexOf(PRE_FLAG);
									path = str.substring(index +PRE_FLAG.length() + 1);
								}else{
									path = url.toString();
								}
								if(path.endsWith("/") || path.endsWith(".")){
									path = path.substring(0,path.length() - 1);
								}
								buffer.append(path.replace("/", "."));
							}
						}else{
							log.warn("无法扫描到通配符:"+matcher);
						}
					} catch (IOException e) {
						log.warn("资源无法定位:"+matcher.trim());
					}
					
				}
			}
			log.info("MyBatis Aliases 扫描配置："+buffer.toString());
			super.setTypeAliasesPackage(buffer.toString());
			return;
			
		}
		super.setTypeAliasesPackage(typeAliasesPackage);
	}
	

}
