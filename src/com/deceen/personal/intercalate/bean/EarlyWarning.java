package com.deceen.personal.intercalate.bean;

/**
 * 对应表userIndicatorEarlywarning
 * @return 
 * @author dengguibin
 */
public class EarlyWarning {
	
	private String indicatorID;//指标ID
	private String userID;//用户ID
	private String warningValueCeiling;//预警值上界
	private String  warningValueFloor;//预警值下界
	private Integer beMonitored;//是否被监视（1被监视）
	
	public Integer getBeMonitored() {
		return beMonitored;
	}
	public void setBeMonitored(Integer beMonitored) {
		this.beMonitored = beMonitored;
	}
	public String getWarningValueCeiling() {
		return warningValueCeiling;
	}
	public void setWarningValueCeiling(String warningValueCeiling) {
		this.warningValueCeiling = warningValueCeiling;
	}
	public String getWarningValueFloor() {
		return warningValueFloor;
	}
	public void setWarningValueFloor(String warningValueFloor) {
		this.warningValueFloor = warningValueFloor;
	}
	
	
	public String getIndicatorID() {
		return indicatorID;
	}
	public void setIndicatorID(String indicatorID) {
		this.indicatorID = indicatorID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
