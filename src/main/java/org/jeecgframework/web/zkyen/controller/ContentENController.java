package org.jeecgframework.web.zkyen.controller;

import java.util.Date;

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
import org.jeecgframework.web.zky.util.CommonMethod;
import org.jeecgframework.web.zkyen.pojo.base.ZkContentImgEN;
import org.jeecgframework.web.zkyen.pojo.base.ZkContentInfoEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/zkyencontentController")
public class ContentENController extends BaseController {

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
	public ModelAndView addorupdate(ZkContentInfoEN ent ,HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ent.getId())) {
			ent = systemService.getEntity(ZkContentInfoEN.class, ent.getId());
			req.setAttribute("ent", ent);
		}
        return new ModelAndView("zkyen/content/content");
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
	public AjaxJson save(HttpServletRequest req,ZkContentInfoEN ent) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(ent.getId())) {
			systemService.updateEntitie(ent);
			
			//保存内容图片
			imgOpr(systemService,ent);
			
			message = "内容: " + ent.getTitle() + "更新成功";
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			//取得当前时间
			ent.setCreatTime(DateUtils.getDate());
			ent.setStatus((short)00);
			systemService.save(ent);
			
			//保存内容图片
			imgOpr(systemService,ent);
			
			message = "内容: " + ent.getTitle() + "添加成功";
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
	public void datagrid(ZkContentInfoEN entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(ZkContentInfoEN.class, dataGrid);
        //模糊查询--菜单名称
        if(entity!=null && entity.getTSFunction()!=null && StringUtil.isNotEmpty(entity.getTSFunction().getFunctionName())){
        	cq.like("TSFunction.functionName", "%"+entity.getTSFunction().getFunctionName()+"%");
        	entity.getTSFunction().setFunctionName("");
        	cq.add();
        }
        //内容标题-模糊查询
        if(entity!=null && StringUtil.isNotEmpty(entity.getTitle())){
        	cq.like("title", "%"+entity.getTitle()+"%");
        	entity.setTitle("");
        	cq.add();
        }
        
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
	public AjaxJson del(ZkContentInfoEN ent, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		ent = systemService.getEntity(ZkContentInfoEN.class, ent.getId());
		//删除内容关联的图片
		imgDel(systemService,ent);
//		systemService.executeSql("delete from t_s_document where conId=?", ent.getId());
		//删除内容
		systemService.executeSql("delete from zk_en_content_info where id=?", ent.getId()); 
		message = "内容：" + ent.getTitle() + "删除成功";
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 文件添加跳转
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addFiles")
	public ModelAndView addFiles(HttpServletRequest req) {
		
		String id = (String) req.getParameter("id");
		if(StringUtil.isNotEmpty(id)){
			
		}
		
		req.setAttribute("conId", id);
		return new ModelAndView("zkyen/content/pic");
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
		
		ZkContentInfoEN ent = systemService.getEntity(ZkContentInfoEN.class, id);
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

	/**
	 *内容图片相关 
	 * */
	public static void imgDel(SystemService systemService,ZkContentInfoEN ent){
		
		systemService.executeSql("delete from zk_en_content_img where content_id=?", ent.getId());
		
	}
	
	/**
	 *内容图片相关 
	 * */
	public static void imgOpr(SystemService systemService,ZkContentInfoEN ent){
		
		//先删除再增加
		imgDel(systemService,ent);
//		systemService.executeSql("delete from zk_content_img where content_id=?", ent.getId());
		String imgUrls = ent.getPicSrc();
		if(StringUtil.isNotEmpty(imgUrls)){
			String[] arr = imgUrls.split("\\|");
			if(arr.length>0){
				ZkContentImgEN imgEnt = null;
				short s = 1;
				for(int i =0 ;i<arr.length;i++){
					imgEnt = new ZkContentImgEN();
					imgEnt.setContentId(ent.getId());
					imgEnt.setAddTime(new Date());
					imgEnt.setImgUrl(arr[i]);
					imgEnt.setStatus(s);
					systemService.save(imgEnt);
				}
			}
		}
		
	}
	
}
