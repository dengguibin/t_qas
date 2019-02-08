package com.upath.plat.common.service;

import java.util.Date;

import org.apache.log4j.Logger;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.mapper.TCommonSeqvalueMapper;
import com.upath.plat.common.modules.model.TSequence;
import com.upath.plat.common.util.IDGenerator;

/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-2 
 * modify time
 */
public class PlatSequence implements ISequence{

	private TCommonSeqvalueMapper mapper;
	
	public static String DEFAULT_SEQ_NAME = ISequence.DEFAULT_SEQ_NAME; 
	
	public static String DEFAULT_SEQ_TYPE = ISequence.DEFAULT_SEQ_TYPE;

	private static final Logger logger = Logger.getLogger(PlatSequence.class);
	
	public int getNextId(){
		return getNextId(DEFAULT_SEQ_NAME);
	}

	public int getNextId(String seqName){
		return getNextId(seqName, DEFAULT_SEQ_TYPE);
	}

	public int getNextDeaultId(String seqType){
		return getNextId(DEFAULT_SEQ_NAME, seqType);
	}
	
	public int[] getNextDeaultId(String seqType, int nums) {
		return getNextId(DEFAULT_SEQ_NAME, seqType, nums);
	}
	
	public int[] getNextId(String seqName, int nums){
		return getNextId(seqName, DEFAULT_SEQ_TYPE, nums);
	}

	public int getNextId(String seqName, String seqType){
		return getNextId(seqName, seqType, 1)[0];
	}

	public int[] getNextId(String seqName, String seqType, int nums){
		if(nums <= 1){
			nums = 1;
		}
		TSequence seq = new TSequence();
		seq.setName(seqName);
		seq.setSeqtype(seqType);
		TSequence sequence = mapper.selectSequnce(seq);
			if(sequence == null){
				throw new PlatformException("无法在数据库序列定义中找到【"+seqName+"】的配置");
			}
		
					String tid = sequence.getTid();
					boolean isNew = false;
						if(tid == null){
							/**
							 * 此时需要对序列进行初始化
							 */
							isNew = true;
							sequence.setTid(IDGenerator.getDateId());
							sequence.setSeqtype(seqType);
							sequence.setCvalue(sequence.getMinval() - sequence.getSteps());
							sequence.setCjsj(new Date());
							sequence.setNums(1);
						}
						int arr[] = new int[nums];
						for(int i = 0 ; i < nums ; i++){
							arr[i] = sequence.getCvalue() + sequence.getSteps();
							sequence.setCvalue(arr[i]);
						}
							if(isNew == true){
								mapper.insertSequnce(sequence);
								logger.info("平台按照配置生成新的序列号数据:序列定义名称：【"+seqName+"】子序列名称：【"+seqType+"】");
							}else{
								Integer iNums = sequence.getNums();
									if(iNums == null){
										iNums = 0;
									}
								sequence.setNums(iNums+1);
								sequence.setXgsj(new Date());
								mapper.updateSequnce(sequence);
							}
						return arr;
			
	} 
	
	public boolean freeSeq(String seqName, String seqType, int seq){
		return false;
	}

	public boolean freeSeq(String seqName, String seqType, int[] seq){
		return false;
	}

	public TCommonSeqvalueMapper getMapper() {
		return mapper;
	}

	public void setMapper(TCommonSeqvalueMapper mapper) {
		this.mapper = mapper;
	}

	

}
