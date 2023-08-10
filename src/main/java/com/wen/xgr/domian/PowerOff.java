package com.wen.xgr.domian;


import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlHead("data")
public class PowerOff implements Serializable {
	/**
	 *  消息id
	 */
	@XmlField("msgId")
	private String msgId;
	/**
	 *  PMS或供服系统停电通知单编号
	 */
	@XmlField("poweroffId")
	private String poweroffId;
	/**
	 *  营销停电信息编号
	 */
	@XmlField("cmsid")
	private String cmsid;
	/**
	 *  停电开始时间
	 */
	@XmlField("startTime")
	private Date startTime;
	/**
	 *  停电结束时间
	 */
	@XmlField("stopDate")
	private Date stopDate;
	/**
	 *  供电单位编码
	 */
	@XmlField("orgNo")
	private String orgNo;
	/**
	 *  停电类型:
	 *    02电网故障停限电
	 *    07临时日前停电，修改为临时停电
	 *    08超电网供电能力停限电
	 *    99 其他停电
	 *    06有序用电
	 *    10 表箱停电
	 */
	@XmlField("typeCode")
	private String typeCode;
	/**
	 *  停电原因
	 */
	@XmlField("poweroffReason")
	private String poweroffReason;
	/**
	 *  现场送电类型: 01 全部、02 部分、03 未送电
	 */
	@XmlField("powerType")
	private String powerType;
	/**
	 *  影响重要用户说明
	 */
	@XmlField("importantConsComm")
	private String importantConsComm;
	/**
	 *  变更类型: 01 撤消、02 计划变更、03 现场变更、00新增
	 */
	@XmlField("chgTypeCode")
	private String chgTypeCode;
	/**
	 * 变更原因
	 */
	@XmlField("changedCause")
	private String changedCause;

	/**
	 *  停电填报人
	 */
	@XmlField("empNo")
	private String empNo;
	/**
	 *  停电信息填报时间
	 */
	@XmlField("collTime")
	private Date collTime;
	/**
	 *  发布渠道: 填写停电信息的发布时间，发布的载体，例如某报纸、某电视台等
	 */
	@XmlField("issueChannel")
	private String issueChannel;
	/**
	 *  停电范围描述
	 */
	@XmlField("areaDesc")
	private String areaDesc;
	/**
	 *  停电区域
	 */
	@XmlField("powerOffArea")
	private String powerOffArea;
	/**
	 *  电压等级: 当电压等级为低压时此字段为必填，值为380V
	 */
	@XmlField("voltCode")
	private String voltCode;
	/**
	 *  是否昼停夜送: 标准代码，1为是，0为否
	 */
	@XmlField("dayNightFlag")
	private String dayNightFlag;
	/**
	 *  昼停开始时间: HH24:MI:SS
	 */
	@XmlField("dayStop")
	private String dayStop;

	/**
	 *  夜送开始时间: HH24:MI:SS
	 */
	@XmlField("nightSend")
	private String nightSend;

	@XmlField("datalists")
	private List<PowerOffData> powerOffDataList;

	@Override
	public String toString() {
		return "PowerOff{" +
				"msgId='" + msgId + '\'' +
				", poweroffId='" + poweroffId + '\'' +
				", cmsid='" + cmsid + '\'' +
				", startTime=" + startTime +
				", stopDate=" + stopDate +
				", orgNo='" + orgNo + '\'' +
				", typeCode='" + typeCode + '\'' +
				", poweroffReason='" + poweroffReason + '\'' +
				", powerType='" + powerType + '\'' +
				", importantConsComm='" + importantConsComm + '\'' +
				", chgTypeCode='" + chgTypeCode + '\'' +
				", changedCause='" + changedCause + '\'' +
				", empNo='" + empNo + '\'' +
				", collTime=" + collTime +
				", issueChannel='" + issueChannel + '\'' +
				", areaDesc='" + areaDesc + '\'' +
				", powerOffArea='" + powerOffArea + '\'' +
				", voltCode='" + voltCode + '\'' +
				", dayNightFlag='" + dayNightFlag + '\'' +
				", dayStop='" + dayStop + '\'' +
				", nightSend='" + nightSend + '\'' +
				", powerOffDataList=" + powerOffDataList +
				'}';
	}

	public List<PowerOffData> getPowerOffDataList() {
		return powerOffDataList;
	}

	public void setPowerOffDataList(List<PowerOffData> powerOffDataList) {
		this.powerOffDataList = powerOffDataList;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getPoweroffId() {
		return poweroffId;
	}

	public void setPoweroffId(String poweroffId) {
		this.poweroffId = poweroffId;
	}

	public String getCmsid() {
		return cmsid;
	}

	public void setCmsid(String cmsid) {
		this.cmsid = cmsid;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getPoweroffReason() {
		return poweroffReason;
	}

	public void setPoweroffReason(String poweroffReason) {
		this.poweroffReason = poweroffReason;
	}

	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	public String getImportantConsComm() {
		return importantConsComm;
	}

	public void setImportantConsComm(String importantConsComm) {
		this.importantConsComm = importantConsComm;
	}

	public String getChgTypeCode() {
		return chgTypeCode;
	}

	public void setChgTypeCode(String chgTypeCode) {
		this.chgTypeCode = chgTypeCode;
	}

	public String getChangedCause() {
		return changedCause;
	}

	public void setChangedCause(String changedCause) {
		this.changedCause = changedCause;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public Date getCollTime() {
		return collTime;
	}

	public void setCollTime(Date collTime) {
		this.collTime = collTime;
	}

	public String getIssueChannel() {
		return issueChannel;
	}

	public void setIssueChannel(String issueChannel) {
		this.issueChannel = issueChannel;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	public String getPowerOffArea() {
		return powerOffArea;
	}

	public void setPowerOffArea(String powerOffArea) {
		this.powerOffArea = powerOffArea;
	}

	public String getVoltCode() {
		return voltCode;
	}

	public void setVoltCode(String voltCode) {
		this.voltCode = voltCode;
	}

	public String getDayNightFlag() {
		return dayNightFlag;
	}

	public void setDayNightFlag(String dayNightFlag) {
		this.dayNightFlag = dayNightFlag;
	}

	public String getDayStop() {
		return dayStop;
	}

	public void setDayStop(String dayStop) {
		this.dayStop = dayStop;
	}

	public String getNightSend() {
		return nightSend;
	}

	public void setNightSend(String nightSend) {
		this.nightSend = nightSend;
	}

}
