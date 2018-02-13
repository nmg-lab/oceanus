/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.yunke.web.equipment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.yunke.entity.equipment.YunkeEquipment;
import com.thinkgem.jeesite.modules.yunke.service.equipment.YunkeEquipmentService;

/**
 * 基础信息Controller
 * @author 张健
 * @version 2018-02-12
 */
@Controller
@RequestMapping(value = "${adminPath}/yunke/equipment/yunkeEquipment")
public class YunkeEquipmentController extends BaseController {

	@Autowired
	private YunkeEquipmentService yunkeEquipmentService;
	
	@ModelAttribute
	public YunkeEquipment get(@RequestParam(required=false) String id) {
		YunkeEquipment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = yunkeEquipmentService.get(id);
		}
		if (entity == null){
			entity = new YunkeEquipment();
		}
		return entity;
	}
	
	@RequiresPermissions("yunke:equipment:yunkeEquipment:view")
	@RequestMapping(value = {"list", ""})
	public String list(YunkeEquipment yunkeEquipment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YunkeEquipment> page = yunkeEquipmentService.findPage(new Page<YunkeEquipment>(request, response), yunkeEquipment); 
		model.addAttribute("page", page);
		return "modules/yunke/equipment/yunkeEquipmentList";
	}

	@RequiresPermissions("yunke:equipment:yunkeEquipment:view")
	@RequestMapping(value = "form")
	public String form(YunkeEquipment yunkeEquipment, Model model) {
		model.addAttribute("yunkeEquipment", yunkeEquipment);
		return "modules/yunke/equipment/yunkeEquipmentForm";
	}

	@RequiresPermissions("yunke:equipment:yunkeEquipment:edit")
	@RequestMapping(value = "save")
	public String save(YunkeEquipment yunkeEquipment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, yunkeEquipment)){
			return form(yunkeEquipment, model);
		}
		yunkeEquipmentService.save(yunkeEquipment);
		addMessage(redirectAttributes, "保存基础信息成功");
		return "redirect:"+Global.getAdminPath()+"/yunke/equipment/yunkeEquipment/?repage";
	}
	
	@RequiresPermissions("yunke:equipment:yunkeEquipment:edit")
	@RequestMapping(value = "delete")
	public String delete(YunkeEquipment yunkeEquipment, RedirectAttributes redirectAttributes) {
		yunkeEquipmentService.delete(yunkeEquipment);
		addMessage(redirectAttributes, "删除基础信息成功");
		return "redirect:"+Global.getAdminPath()+"/yunke/equipment/yunkeEquipment/?repage";
	}

}