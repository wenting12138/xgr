package com.wen.xgr.domian;


import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.io.Serializable;
import java.util.Date;

@XmlHead("datalist")
public class PowerOffData implements Serializable {
	/**
	 * 台区标识
	 */
	@XmlField("tgId")
	private String tgId;
	/**
	 * 台区名称
	 */
	@XmlField("tgName")
	private String tgName;
	/**
	 * 变电站名称
	 */
	@XmlField("stationName")
	private String stationName;
	/**
	 * 线路名称
	 */
	@XmlField("lineName")
	private String lineName;
	/**
	 * 线路id
	 */
	@XmlField("lineId")
	private String lineId;

	@Override
	public String toString() {
		return "PowerOffData{" +
				"tgId='" + tgId + '\'' +
				", tgName='" + tgName + '\'' +
				", stationName='" + stationName + '\'' +
				", lineName='" + lineName + '\'' +
				", lineId='" + lineId + '\'' +
				'}';
	}

	public String getTgId() {
		return tgId;
	}

	public void setTgId(String tgId) {
		this.tgId = tgId;
	}

	public String getTgName() {
		return tgName;
	}

	public void setTgName(String tgName) {
		this.tgName = tgName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
}
