package org.jeecgframework.web.zkyen.controller;


import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/SkipENController" )
public class SkipENController extends BaseController {
	
	/**
	 * 首页菜单跳转
	 * */
	@RequestMapping(params = "menu")
	public ModelAndView menu() {
		return new ModelAndView("zkyen/function/functionList");
	}
	
	/**
	 * 招聘跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "recruit")
	public ModelAndView recruit(HttpServletRequest request) {
		// 给部门查询条件中的下拉框准备数据
//		List<TSDepart> departList = systemService.getList(TSDepart.class);
//		request.setAttribute("departsReplace", RoletoJson.listToReplaceStr(departList, "departname", "id"));
		return new ModelAndView("zkyen/recruit/recruitList");
	}
	
	/**
	 * 招聘增加跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "recruitAddTransfer")
	public ModelAndView recruitAddTransfer() {
		return new ModelAndView("zkyen/recruit/recruitAdd");
	}
	
	/**
	 * 招聘增加处理
	 * 
	 * @return
	 */
	@RequestMapping(params = "recruitAdd")
	public ModelAndView recruitAdd() {
		//TOOD 逻辑处理 
		
		return new ModelAndView("zkyen/recruit/recruitList");
	}
	
	/**
	 * 栏目跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "channel")
	public ModelAndView channel() {
		return new ModelAndView("zkyen/channel/channelList");
	}
	
	/**
	 * 内容跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "content")
	public ModelAndView content() {
		return new ModelAndView("zkyen/content/contentList");
	}
	
	/**
	 * 内容跳转--首页模块
	 * 
	 * @return
	 */
	@RequestMapping(params = "module")
	public ModelAndView module() {
		return new ModelAndView("zkyen/module/contentList");
	}
	
	/**
	 * 图片跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "pic")
	public ModelAndView pic(HttpServletRequest req) {
		
		String conId = req.getParameter("id");
		
		if(StringUtil.isNotEmpty(conId)){
			req.setAttribute("conId", conId);
		}
		return new ModelAndView("zkyen/pic/picList");
	}
	
	/**
	 * 电子刊物跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "elc")
	public ModelAndView elc() {
		return new ModelAndView("zkyen/elc/elcList");
	}
	
	/**
	 * 视频跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "vedio")
	public ModelAndView vedio() {
		return new ModelAndView("zkyen/vedio/vedioList");
	}
	
	/**
	 * 链接跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "link")
	public ModelAndView link() {
		return new ModelAndView("zkyen/link/linkList");
	}
	
	/**
	 * 公司信息跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "comp")
	public ModelAndView comp() {
		return new ModelAndView("zkyen/comp/compList");
	}
	
	/**
	 * LOGO跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "logo")
	public ModelAndView logo() {
		return new ModelAndView("zkyen/logo/logoList");
	}
	
}
