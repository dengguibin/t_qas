package	com.deceen.data.major.directionStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDDirectionstatistics.java   唯一标示
* @Description: qas_d_directionstatistics   
* @author upaths@gmail.com  
* @date 2017-11-23 16:05:48
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDDirectionstatistics extends Pagination implements Serializable{ 	
	
	 //唯一标示 @PrimaryKey
	private String id;
	 //专业方向 
	private String directionid;
	 //在校生数（人）<-->总人数 
	private Integer numofstudent;
	 //在校生数（人）<-->一年级 
	private Integer numofgradeone;
	 //在校生数（人）<-->二年级 
	private Integer numofgradetwo;
	 //在校生数（人）<-->三年级 
	private Integer numofgradethree;
	 //生源类型（人）<-->普通高中起点 
	private Integer hightpfsstunum;
	 //生源类型（人）<-->中职起点<-->合计 
	private Integer middlepfsstunum;
	 //生源类型（人）<-->五年制后二年 
	private Integer middleschtwoyearbehandnum;
	 //生源类型（人）<-->其他 
	private Integer othernum;
	 //重点专业 
	private String coremajor;
	 //特色专业 
	private String characteristicmajor;
	 //是否国际合作专业 
	private String isinternationalmajor;
	 //班级总数（个） 
	private Integer gradecount;
	 //订单(定向)培养 
	private Integer ordertrain;
	 //是否有上届毕业生 
	private String isgradutionbefore;
	 //当年是否招生（含方向） 
	private String iscurrentenroll;
	 //全日制在校生中去境外交流学生人数 
	private Integer exchangeabroad;
	 //接收境外交流学生数量	 
	private Integer receivingoverseas;
	 //去其他学校交流学生人数 
	private Integer exchangestudents;
	 //状态 
	private Integer status;
	 //创建人 
	private String createdby;
	 //创建时间 
	private Date createdtime;
	 //修改人 
	private String updatedby;
	 //修改时间 
	private Date updatedtime;
	 //租户 
	private String tenantid;
	 //入库时间（接口传输，导入） 
	private Date storagetime;

		 public void setId(String id){
			this.id = id;
		}
	  
		public String getId(){
			return this.id;
		}
		 public void setDirectionid(String directionid){
			this.directionid = directionid;
		}
	  
		public String getDirectionid(){
			return this.directionid;
		}
		 public void setNumofstudent(Integer numofstudent){
			this.numofstudent = numofstudent;
		}
	  
		public Integer getNumofstudent(){
			return this.numofstudent;
		}
		 public void setNumofgradeone(Integer numofgradeone){
			this.numofgradeone = numofgradeone;
		}
	  
		public Integer getNumofgradeone(){
			return this.numofgradeone;
		}
		 public void setNumofgradetwo(Integer numofgradetwo){
			this.numofgradetwo = numofgradetwo;
		}
	  
		public Integer getNumofgradetwo(){
			return this.numofgradetwo;
		}
		 public void setNumofgradethree(Integer numofgradethree){
			this.numofgradethree = numofgradethree;
		}
	  
		public Integer getNumofgradethree(){
			return this.numofgradethree;
		}
		 public void setHightpfsstunum(Integer hightpfsstunum){
			this.hightpfsstunum = hightpfsstunum;
		}
	  
		public Integer getHightpfsstunum(){
			return this.hightpfsstunum;
		}
		 public void setMiddlepfsstunum(Integer middlepfsstunum){
			this.middlepfsstunum = middlepfsstunum;
		}
	  
		public Integer getMiddlepfsstunum(){
			return this.middlepfsstunum;
		}
		 public void setMiddleschtwoyearbehandnum(Integer middleschtwoyearbehandnum){
			this.middleschtwoyearbehandnum = middleschtwoyearbehandnum;
		}
	  
		public Integer getMiddleschtwoyearbehandnum(){
			return this.middleschtwoyearbehandnum;
		}
		 public void setOthernum(Integer othernum){
			this.othernum = othernum;
		}
	  
		public Integer getOthernum(){
			return this.othernum;
		}
		 public void setCoremajor(String coremajor){
			this.coremajor = coremajor;
		}
	  
		public String getCoremajor(){
			return this.coremajor;
		}
		 public void setCharacteristicmajor(String characteristicmajor){
			this.characteristicmajor = characteristicmajor;
		}
	  
		public String getCharacteristicmajor(){
			return this.characteristicmajor;
		}
		 public void setIsinternationalmajor(String isinternationalmajor){
			this.isinternationalmajor = isinternationalmajor;
		}
	  
		public String getIsinternationalmajor(){
			return this.isinternationalmajor;
		}
		 public void setGradecount(Integer gradecount){
			this.gradecount = gradecount;
		}
	  
		public Integer getGradecount(){
			return this.gradecount;
		}
		 public void setOrdertrain(Integer ordertrain){
			this.ordertrain = ordertrain;
		}
	  
		public Integer getOrdertrain(){
			return this.ordertrain;
		}
		 public void setIsgradutionbefore(String isgradutionbefore){
			this.isgradutionbefore = isgradutionbefore;
		}
	  
		public String getIsgradutionbefore(){
			return this.isgradutionbefore;
		}
		 public void setIscurrentenroll(String iscurrentenroll){
			this.iscurrentenroll = iscurrentenroll;
		}
	  
		public String getIscurrentenroll(){
			return this.iscurrentenroll;
		}
		 public void setExchangeabroad(Integer exchangeabroad){
			this.exchangeabroad = exchangeabroad;
		}
	  
		public Integer getExchangeabroad(){
			return this.exchangeabroad;
		}
		 public void setReceivingoverseas(Integer receivingoverseas){
			this.receivingoverseas = receivingoverseas;
		}
	  
		public Integer getReceivingoverseas(){
			return this.receivingoverseas;
		}
		 public void setExchangestudents(Integer exchangestudents){
			this.exchangestudents = exchangestudents;
		}
	  
		public Integer getExchangestudents(){
			return this.exchangestudents;
		}
		 public void setStatus(Integer status){
			this.status = status;
		}
	  
		public Integer getStatus(){
			return this.status;
		}
		 public void setCreatedby(String createdby){
			this.createdby = createdby;
		}
	  
		public String getCreatedby(){
			return this.createdby;
		}
		 public void setCreatedtime(Date createdtime){
			this.createdtime = createdtime;
		}
	  
		public Date getCreatedtime(){
			return this.createdtime;
		}
		 public void setUpdatedby(String updatedby){
			this.updatedby = updatedby;
		}
	  
		public String getUpdatedby(){
			return this.updatedby;
		}
		 public void setUpdatedtime(Date updatedtime){
			this.updatedtime = updatedtime;
		}
	  
		public Date getUpdatedtime(){
			return this.updatedtime;
		}
		 public void setTenantid(String tenantid){
			this.tenantid = tenantid;
		}
	  
		public String getTenantid(){
			return this.tenantid;
		}
		 public void setStoragetime(Date storagetime){
			this.storagetime = storagetime;
		}
	  
		public Date getStoragetime(){
			return this.storagetime;
		}
}
