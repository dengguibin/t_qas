package com.upath.plat.common.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
/**
 * 
 * @author Administrator
 *实现 sqlSessionFactory 通配置配置的实现
 *
 *typeAliasesPackage
 */
public class PackageSqlSessionFactoryBeanNew extends SqlSessionFactoryBean {

	private static final Logger log = Logger.getLogger(PackageSqlSessionFactoryBeanNew.class);
	
	static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";    
    
    @Override    
    public void setTypeAliasesPackage(String typeAliasesPackage) {    
        ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver();    
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);    
        String[] typeAliasesPackages = typeAliasesPackage.split(","); 
        List<String> result = new ArrayList<String>(); 
        try {    
	        for (String packages : typeAliasesPackages) {
	        	packages = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +    
	        			ClassUtils.convertClassNameToResourcePath(packages.trim()) + "/" + DEFAULT_RESOURCE_PATTERN;    
	        	
	        	//将加载多个绝对匹配的所有Resource    
	        	//将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分    
	        	//然后进行遍历模式匹配    
        		Resource[] resources =  resolver.getResources(packages);    
        		if(resources != null && resources.length > 0){    
        			MetadataReader metadataReader = null;    
        			for(Resource resource : resources){    
        				if(resource.isReadable()){    
        					metadataReader =  metadataReaderFactory.getMetadataReader(resource);    
        					try {    
        						result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());    
        					} catch (ClassNotFoundException e) {    
        						e.printStackTrace();    
        					}    
        				}    
        			}    
        		}    
        		if(result.size() > 0) { 
        		}else{    
        			log.warn("参数typeAliasesPackage:"+typeAliasesPackage+"，未找到任何包");    
        		}    
			}
	        //去重复
	        Set<String> set = new  HashSet<String>(); 
	        set.addAll(result);
	        super.setTypeAliasesPackage(StringUtils.join(set.toArray(), ","));    
            //logger.info("d");    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
    }    
}
