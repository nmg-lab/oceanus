/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yunke.entity.equipment;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基础信息Entity
 * @author 张健
 * @version 2018-02-12
 */
public class YunkeEquipment extends DataEntity<YunkeEquipment> {
	
	private static final long serialVersionUID = 1L;
	private String factory;		// 维保厂商
	private String position;		// 物理位置
	private String type;		// 设备类型
	private String model;		// 设备型号
	private Date outtime;		// 出场日期
	private String sequencenumber;		// 序列号
	private Integer sum;		// 存储总容量
	private Integer cardnumber;		// 插槽数量
	private String power;		// 权属
	private String people;		// 负责人
	private String monitor;		// 监控
	private String run;		// 运行
	
	public YunkeEquipment() {
		super();
	}

	public YunkeEquipment(String id){
		super(id);
	}

	@Length(min=0, max=128, message="维保厂商长度必须介于 0 和 128 之间")
	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}
	
	@Length(min=0, max=32, message="物理位置长度必须介于 0 和 32 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Length(min=0, max=255, message="设备类型长度必须介于 0 和 255 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=128, message="设备型号长度必须介于 0 和 128 之间")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	
	@Length(min=0, max=255, message="序列号长度必须介于 0 和 255 之间")
	public String getSequencenumber() {
		return sequencenumber;
	}

	public void setSequencenumber(String sequencenumber) {
		this.sequencenumber = sequencenumber;
	}
	
	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	public Integer getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(Integer cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	@Length(min=0, max=32, message="权属长度必须介于 0 和 32 之间")
	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
	@Length(min=0, max=32, message="负责人长度必须介于 0 和 32 之间")
	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
	
	@Length(min=0, max=255, message="监控长度必须介于 0 和 255 之间")
	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	
	@Length(min=0, max=255, message="运行长度必须介于 0 和 255 之间")
	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}
	
}