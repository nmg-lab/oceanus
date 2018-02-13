/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yunke.dao.equipment;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.yunke.entity.equipment.YunkeEquipment;

/**
 * 基础信息DAO接口
 * @author 张健
 * @version 2018-02-12
 */
@MyBatisDao
public interface YunkeEquipmentDao extends CrudDao<YunkeEquipment> {
	
}