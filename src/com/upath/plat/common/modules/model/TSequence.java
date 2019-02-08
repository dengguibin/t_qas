package com.upath.plat.common.modules.model;

@SuppressWarnings("serial")
public class TSequence extends TCommonSeq {
	
	//预警类型 @PrimaryKey
	private String seqtype;
	//应用ID 
	private String tid;
	//序列当前使用值 
	private Integer cvalue;
	//存取次数 
	private Integer nums;
	
	//回滚标识(实现ID回滚) 
	private Integer flag;
	
	public String getSeqtype() {
		return seqtype;
	}
	public void setSeqtype(String seqtype) {
		this.seqtype = seqtype;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public Integer getCvalue() {
		return cvalue;
	}
	public void setCvalue(Integer cvalue) {
		this.cvalue = cvalue;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
