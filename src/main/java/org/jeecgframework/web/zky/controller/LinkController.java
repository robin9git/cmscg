package org.jeecgframework.web.zky.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.zky.pojo.base.ZkLinkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/linkController")
public class LinkController extends BaseController {

	private SystemService systemService;
	private String message = null;
	private String TITAL = "链接： ";
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	/**
	 * 增加跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "add")
	public ModelAndView add() {
		return new ModelAndView("zky/link/linkList");
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
	public ModelAndView addorupdate(ZkLinkInfo ent ,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ent.getId())) {
			ent = systemService.getEntity(ZkLinkInfo.class, ent.getId());
			req.setAttribute("ent", ent);
		}
        return new ModelAndView("zky/link/link");
	}
	
	/**
	 * 录入
	 * 
	 * @param user
	 * @param req
	 * @return
	 */

	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HttpServletRequest req,ZkLinkInfo ent) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(ent.getId())) {
			ZkLinkInfo ents = systemService.getEntity(ZkLinkInfo.class, ent.getId());
			ents.setCategory(ent.getCategory());
			ents.setName(ent.getName());
			ents.setUrl(ent.getUrl());
			ents.setCreatTime(DateUtils.getDate());
			ents.setConOrder(ent.getConOrder());
			systemService.updateEntitie(ents);
			message = TITAL + ent.getName() + "更新成功";
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			
			//取得当前时间
			ent.setCreatTime(DateUtils.getDate());
			systemService.save(ent);
			message = TITAL + ent.getName() + "添加成功";
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
	public void datagrid(ZkLinkInfo entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(ZkLinkInfo.class, dataGrid);
        
//        //实现模糊查询--HQL
//        if(StringUtil.isNotEmpty(rInfo.getCategory())){
//        	Criterion criterion2=Restrictions.like("category","%"+rInfo.getCategory()+"%");
//        	//清空原等值查询条件
//        	rInfo.setCategory("");
//            cq.add(criterion2);
//        }
//        if(StringUtil.isNotEmpty(rInfo.getJobTitle())){
//        	Criterion criterion2=Restrictions.like("jobTitle","%"+rInfo.getJobTitle()+"%");
//        	//清空原等值查询条件
//       	 	rInfo.setJobTitle("");
//       	 	cq.add(criterion2);
//        }
        
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entity);
        
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
	public AjaxJson del(ZkLinkInfo ent, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		ent = systemService.getEntity(ZkLinkInfo.class, ent.getId());
		//删除
		systemService.executeSql("delete from zk_link_info where id=?", ent.getId());
		message = TITAL + ent.getName() + "删除成功";
		j.setMsg(message);
		return j;
	}

}
