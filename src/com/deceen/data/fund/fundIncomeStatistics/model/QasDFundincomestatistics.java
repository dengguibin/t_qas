package	com.deceen.data.fund.fundIncomeStatistics.model;

import java.io.Serializable;
import java.util.*;

import com.upath.plat.common.page.Pagination;
/**
* 
* @ClassName: QasDFundincomestatistics.java   序号
* @Description: qas_d_fundincomestatistics   
* @author upaths@gmail.com  
* @date 2017-11-23 12:15:54
* @version V1.0   
*/
	
@SuppressWarnings("serial")
public class QasDFundincomestatistics extends Pagination implements Serializable{ 	
	
	 //序号 @PrimaryKey
	private String id;
	 //学校总收入（万元） 
	private Integer schoolincome;
	 //其中<-->学费收入<-->合计（万元） 
	private Integer tuitiontotal;
	 //其中<-->财政经常性补助收入<-->合计（万元） 
	private Integer financialaidtotal;
	 //其中<-->中央、地方财政专项投入<-->合计（万元） 
	private Integer specialinvestmenttotal;
	 //其中<-->社会捐赠金额（万元） 
	private Integer socialdonation;
	 //其中<-->其他收入总额（万元） 
	private Integer others;
	 //贷款金额（万元） 
	private Integer loanamount;
	 //贷款余额（万元） 
	private Integer loanbalance;
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
	
	//学校总收入(表中无此字段，只是为了条件选择新增的)
	private String schoolincomeScope;

		 public void setId(String id){
			this.id = id;
		}
	  
		 public String getId(){
			 return this.id;
		 }
		public String getSchoolincomeScope() {
			return schoolincomeScope;
		}

		public void setSchoolincomeScope(String schoolincomeScope) {
			this.schoolincomeScope = schoolincomeScope;
		}

		 public void setSchoolincome(Integer schoolincome){
			this.schoolincome = schoolincome;
		}
	  
		public Integer getSchoolincome(){
			return this.schoolincome;
		}
		 public void setTuitiontotal(Integer tuitiontotal){
			this.tuitiontotal = tuitiontotal;
		}
	  
		public Integer getTuitiontotal(){
			return this.tuitiontotal;
		}
		 public void setFinancialaidtotal(Integer financialaidtotal){
			this.financialaidtotal = financialaidtotal;
		}
	  
		public Integer getFinancialaidtotal(){
			return this.financialaidtotal;
		}
		 public void setSpecialinvestmenttotal(Integer specialinvestmenttotal){
			this.specialinvestmenttotal = specialinvestmenttotal;
		}
	  
		public Integer getSpecialinvestmenttotal(){
			return this.specialinvestmenttotal;
		}
		 public void setSocialdonation(Integer socialdonation){
			this.socialdonation = socialdonation;
		}
	  
		public Integer getSocialdonation(){
			return this.socialdonation;
		}
		 public void setOthers(Integer others){
			this.others = others;
		}
	  
		public Integer getOthers(){
			return this.others;
		}
		 public void setLoanamount(Integer loanamount){
			this.loanamount = loanamount;
		}
	  
		public Integer getLoanamount(){
			return this.loanamount;
		}
		 public void setLoanbalance(Integer loanbalance){
			this.loanbalance = loanbalance;
		}
	  
		public Integer getLoanbalance(){
			return this.loanbalance;
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
