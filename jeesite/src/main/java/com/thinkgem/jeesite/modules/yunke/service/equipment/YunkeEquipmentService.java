/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yunke.service.equipment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.yunke.entity.equipment.YunkeEquipment;
import com.thinkgem.jeesite.modules.yunke.dao.equipment.YunkeEquipmentDao;

/**
 * 基础信息Service
 * @author 张健
 * @version 2018-02-12
 */
@Service
@Transactional(readOnly = true)
public class YunkeEquipmentService extends CrudService<YunkeEquipmentDao, YunkeEquipment> {

	public YunkeEquipment get(String id) {
		return super.get(id);
	}
	
	public List<YunkeEquipment> findList(YunkeEquipment yunkeEquipment) {
		return super.findList(yunkeEquipment);
	}
	
	public Page<YunkeEquipment> findPage(Page<YunkeEquipment> page, YunkeEquipment yunkeEquipment) {
		return super.findPage(page, yunkeEquipment);
	}
	
	@Transactional(readOnly = false)
	public void save(YunkeEquipment yunkeEquipment) {
		super.save(yunkeEquipment);
	}
	
	@Transactional(readOnly = false)
	public void delete(YunkeEquipment yunkeEquipment) {
		super.delete(yunkeEquipment);
	}
	
}