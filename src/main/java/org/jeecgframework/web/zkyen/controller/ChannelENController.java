package org.jeecgframework.web.zkyen.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/zkyenchannelController")
public class ChannelENController extends BaseController {

	private SystemService systemService;
	
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
		return new ModelAndView("zkyen/channel/channelList");
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
	public ModelAndView addorupdate(TSUser user, HttpServletRequest req) {

        return new ModelAndView("zkyen/channel/channel");
	}
	
	/**
	 * 用户录入
	 * 
	 * @param user
	 * @param req
	 * @return
	 */

	@RequestMapping(params = "saveChannel")
	@ResponseBody
	public AjaxJson saveUser(HttpServletRequest req, TSUser user) {
		AjaxJson j = new AjaxJson();
		// 得到用户的角色
//		String roleid = oConvertUtils.getString(req.getParameter("roleid"));
//		String password = oConvertUtils.getString(req.getParameter("password"));
//		if (StringUtil.isNotEmpty(user.getId())) {
//			TSUser users = systemService.getEntity(TSUser.class, user.getId());
//			users.setEmail(user.getEmail());
//			users.setOfficePhone(user.getOfficePhone());
//			users.setMobilePhone(user.getMobilePhone());
//            systemService.executeSql("delete from t_s_user_org where user_id=?", user.getId());
//            saveUserOrgList(req, user);
////            users.setTSDepart(user.getTSDepart());
//			users.setRealName(user.getRealName());
//			users.setStatus(Globals.User_Normal);
//			users.setActivitiSync(user.getActivitiSync());
//			systemService.updateEntitie(users);
//			List<TSRoleUser> ru = systemService.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
//			systemService.deleteAllEntitie(ru);
//			message = "用户: " + users.getUserName() + "更新成功";
//			if (StringUtil.isNotEmpty(roleid)) {
//				saveRoleUser(users, roleid);
//			}
//			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
//		} else {
//			TSUser users = systemService.findUniqueByProperty(TSUser.class, "userName",user.getUserName());
//			if (users != null) {
//				message = "用户: " + users.getUserName() + "已经存在";
//			} else {
//				user.setPassword(PasswordUtil.encrypt(user.getUserName(), password, PasswordUtil.getStaticSalt()));
////				if (user.getTSDepart().equals("")) {
////					user.setTSDepart(null);
////				}
//				user.setStatus(Globals.User_Normal);
//				systemService.save(user);
//                // todo zhanggm 保存多个组织机构
//                saveUserOrgList(req, user);
//				message = "用户: " + user.getUserName() + "添加成功";
//				if (StringUtil.isNotEmpty(roleid)) {
//					saveRoleUser(user, roleid);
//				}
//				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
//			}
//
//		}
//		j.setMsg(message);

		return j;
	}
	
	/**
	 * easyuiAJAX用户列表请求数据 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(TSUser user,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//        CriteriaQuery cq = new CriteriaQuery(TSUser.class, dataGrid);
//        //查询条件组装器
//        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, user);
//
//        Short[] userstate = new Short[]{Globals.User_Normal, Globals.User_ADMIN, Globals.User_Forbidden};
//        cq.in("status", userstate);
//        String orgIds = request.getParameter("orgIds");
//        List<String> orgIdList = extractIdListByComma(orgIds);
//        // 获取 当前组织机构的用户信息
//        if (!CollectionUtils.isEmpty(orgIdList)) {
//            CriteriaQuery subCq = new CriteriaQuery(TSUserOrg.class);
//            subCq.setProjection(Property.forName("tsUser.id"));
//            subCq.in("tsDepart.id", orgIdList.toArray());
//            subCq.add();
//
//            cq.add(Property.forName("id").in(subCq.getDetachedCriteria()));
//        }

//        cq.add();
//        this.systemService.getDataGridReturn(cq, true);
//        List<TSUser> cfeList = new ArrayList<TSUser>();
//        for (Object o : dataGrid.getResults()) {
//            if (o instanceof TSUser) {
//                TSUser cfe = (TSUser) o;
//                if (cfe.getId() != null && !"".equals(cfe.getId())) {
//                    List<TSRoleUser> roleUser = systemService.findByProperty(TSRoleUser.class, "TSUser.id", cfe.getId());
//                    if (roleUser.size() > 0) {
//                        String roleName = "";
//                        for (TSRoleUser ru : roleUser) {
//                            roleName += ru.getTSRole().getRoleName() + ",";
//                        }
//                        roleName = roleName.substring(0, roleName.length() - 1);
//                        cfe.setUserKey(roleName);
//                    }
//                }
//                cfeList.add(cfe);
//            }
//        }
        TagUtil.datagrid(response, dataGrid);
    }
	
}
