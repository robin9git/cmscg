package org.jeecgframework.web.zkyen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.zkyen.pojo.base.RecruitInfoEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zkyenrecruitController")
public class RecruitENController extends BaseController {

	private SystemService systemService;
	private String message = null;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	/**
	 * 招聘增加跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "add")
	public ModelAndView add() {
		
		
		System.out.println("add method....");
//		return new ModelAndView("system/function/functionList");
		return new ModelAndView("zkyen/recruit/recruitList");
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
	public ModelAndView addorupdate(RecruitInfoEN rInfo ,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(rInfo.getId())) {
			rInfo = systemService.getEntity(RecruitInfoEN.class, rInfo.getId());
			req.setAttribute("rInfo", rInfo);
		}
        return new ModelAndView("zkyen/recruit/recruit");
	}
	
	/**
	 * 录入
	 * 
	 * @param user
	 * @param req
	 * @return
	 */

	@RequestMapping(params = "saveRecruit")
	@ResponseBody
	public AjaxJson save(HttpServletRequest req,RecruitInfoEN rInfo) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(rInfo.getId())) {
			RecruitInfoEN rInfos = systemService.getEntity(RecruitInfoEN.class, rInfo.getId());
			rInfos.setCategory(rInfo.getCategory());
			rInfos.setJobTitle(rInfo.getJobTitle());
			rInfos.setRecNum(rInfo.getRecNum());
			rInfos.setRequired(rInfo.getRequired());
			rInfos.setSpecOrentation(rInfo.getSpecOrentation());
			rInfos.setCreateDate(DateUtils.getDate());
			systemService.updateEntitie(rInfos);
			message = "招聘: " + rInfos.getJobTitle() + "更新成功";
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			//取得当前时间
			rInfo.setCreateDate(DateUtils.getDate());
			systemService.save(rInfo);
			message = "招聘: " + rInfo.getJobTitle() + "添加成功";
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
	public void datagrid(RecruitInfoEN rInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(RecruitInfoEN.class, dataGrid);
        
        //实现模糊查询--HQL
        if(StringUtil.isNotEmpty(rInfo.getCategory())){
        	Criterion criterion2=Restrictions.like("category","%"+rInfo.getCategory()+"%");
        	//清空原等值查询条件
        	rInfo.setCategory("");
            cq.add(criterion2);
        }
        if(StringUtil.isNotEmpty(rInfo.getJobTitle())){
        	Criterion criterion2=Restrictions.like("jobTitle","%"+rInfo.getJobTitle()+"%");
        	//清空原等值查询条件
       	 	rInfo.setJobTitle("");
       	 	cq.add(criterion2);
        }
        
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, rInfo);
        
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
	public AjaxJson del(RecruitInfoEN rInfo, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		rInfo = systemService.getEntity(RecruitInfoEN.class, rInfo.getId());
		systemService.executeSql("delete from zk_en_recruit_info where id=?", rInfo.getId()); // 删除 用户-机构 数据
		message = "招聘：" + rInfo.getJobTitle() + "删除成功";
		j.setMsg(message);
		return j;
	}
	
	
}
