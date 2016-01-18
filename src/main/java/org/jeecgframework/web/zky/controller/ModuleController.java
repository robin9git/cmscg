package org.jeecgframework.web.zky.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSFunction;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.zky.pojo.base.ZkBanner;
import org.jeecgframework.web.zky.pojo.base.ZkContentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moduleController")
public class ModuleController extends BaseController {

	private SystemService systemService;
	private String message = null;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	/**
	 * easyuiAJAX请求数据： 用户选择角色列表
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(ZkBanner ent ,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ent.getId())) {
			ent = systemService.getEntity(ZkBanner.class, ent.getId());
			req.setAttribute("ent", ent);
			
			TSFunction function = systemService.getEntity(TSFunction.class, ent.getTSFunction().getId());
			req.setAttribute("function", function);
		}
        return new ModelAndView("zky/module/content");
	}
	
	
	/**
	 * 录入
	 * 
	 * @param user
	 * @param req
	 * @return
	 */

	@RequestMapping(params = "saveContent")
	@ResponseBody
	public AjaxJson save(HttpServletRequest req,ZkBanner ent) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(ent.getId())) {
			ZkBanner ent_old = systemService.getEntity(ZkBanner.class, ent.getId());
			ent_old.setTSFunction(ent.getTSFunction());
			ent_old.setTitleEN(ent.getTitleEN());
			ent_old.setIsshow(ent.getIsshow());
			ent_old.setFunctionOrder(ent.getFunctionOrder());
			ent_old.setPicSrc(ent.getPicSrc());
			systemService.updateEntitie(ent_old);
			message = "Banner: " + ent.getTitleEN() + "更新成功";
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			ent.setCreatTime(new Date());
			systemService.save(ent);
			message = "Banner: " + ent.getTitleEN() + "添加成功";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);

		return j;
	}
	
	/**
	 * easyuiAJAX列表请求数据 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(ZkBanner entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(ZkBanner.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entity);
//        Object[] isshow = {Short.parseShort("1"),Short.parseShort("2")};//搜寻显示或是不显示的内容
//        cq.in("isshow", isshow);
        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }
	
	/**
	 * 信息删除
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(ZkBanner ent, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		ent = systemService.getEntity(ZkBanner.class, ent.getId());
		//删除内容关联的图片
//		systemService.executeSql("delete from t_s_document where conId=?", ent.getId());
		//删除内容
		systemService.executeSql("delete from zk_banner where id=?", ent.getId()); 
		message = "Banner：" + ent.getTitleEN() + "删除成功";
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 修正内容审核状态
	 * 
	 * @author pu.chen
	 */
	@RequestMapping(params = "changeStatus")
	@ResponseBody
	public AjaxJson changeStatus(String id, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		
		ZkContentInfo ent = systemService.getEntity(ZkContentInfo.class, id);
		short s = ent.getStatus();
		//如果未审核，则点击一次审核通过； 如果审核通过，点击一次，则审核不通过； 之后在通过与不通过中间切换
		if(s==0){
			s = 1;
		}else if(s==2){
			s = 1;
		}else{
			s = 2;
		}
		ent.setStatus(s);
		try{
			systemService.updateEntitie(ent);
			if(s==1){
				message = "审核通过!";
			}else{
				message = "审核不通过!";
			}
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			message = "操作失败!";
		}
		j.setMsg(message);
		return j;
	}

}
