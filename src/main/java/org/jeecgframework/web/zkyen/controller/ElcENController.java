package org.jeecgframework.web.zkyen.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.zky.util.CommonMethod;
import org.jeecgframework.web.zkyen.pojo.base.ElcPubInfoEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zkyenelcController")
public class ElcENController extends BaseController {

	private SystemService systemService;
	private String message = null;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
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
	public AjaxJson save(HttpServletRequest req,ElcPubInfoEN ent) {
		AjaxJson j = new AjaxJson();
//		if(StringUtil.isNotEmpty(ent.getFileSrc())){
//			//文件大小及类型处理
//			Map<String,Object> map = CommonMethod.getFile(ent.getFileSrc());
//			if(map!=null){
//				ent.setFileSize(String.valueOf(map.get("fileSize")));
//				ent.setFilsType(String.valueOf(map.get("fileType")));
//			}
//		}
		
		if (StringUtil.isNotEmpty(ent.getId())) {
			systemService.updateEntitie(ent);
			message = "附件: " + ent.getTitle1() + "更新成功";
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			ent.setCreatDate(new Date());
			systemService.save(ent);
			message = "附件: " + ent.getTitle1() + "添加成功";
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
	public void datagrid(ElcPubInfoEN entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(ElcPubInfoEN.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entity);
        cq.add();
        this.systemService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }
	
	/**
	 * 文件添加跳转
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addFiles")
	public ModelAndView addFiles(ElcPubInfoEN ent ,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ent.getId())) {
			ent = systemService.getEntity(ElcPubInfoEN.class, ent.getId());
			req.setAttribute("ent", ent);
		}
		return new ModelAndView("zkyen/elc/elc");
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
	public AjaxJson del(ElcPubInfoEN ent, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		ent = systemService.getEntity(ElcPubInfoEN.class, ent.getId());
		//删除内容
		systemService.executeSql("delete from zk_en_attachment where id=?", ent.getId()); 
		message = "附件：" + ent.getTitle1() + "删除成功";
		j.setMsg(message);
		return j;
	}
	
}
