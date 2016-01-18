package org.jeecgframework.web.zky.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ReflectHelper;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDocument;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vedioController")
public class VedioController extends BaseController {

	private SystemService systemService;
	private UserService userService;
	private String message = null;
	
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 新闻法规文件列表
	 */
	@RequestMapping(params = "documentList")
	public void documentList(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSDocument.class, dataGrid);
		String typecode = oConvertUtils.getString(request.getParameter("typecode"));
		
		String documentTitle = oConvertUtils.getString(request.getParameter("documentTitle"));
		if(StringUtil.isNotEmpty(documentTitle)){
//			cq.eq("documentTitle", documentTitle);
			cq.like("documentTitle", "%"+documentTitle+"%");
		}
	
		cq.createAlias("TSType", "TSType");
		cq.eq("TSType.typecode", typecode);
		
		//类别--类别 1.pdf文件 2.图片 3.视频
		cq.eq("category", (short)3);
		
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
	public ModelAndView addFiles(HttpServletRequest req) {
		return new ModelAndView("zky/vedio/vedio");
	}
	
	/**
	 * 删除文档
	 * 
	 * @param document
	 * @return
	 */
	@RequestMapping(params = "delDocument")
	@ResponseBody
	public AjaxJson delDocument(TSDocument document, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		document = systemService.getEntity(TSDocument.class, document.getId());
		message = "" + document.getDocumentTitle() + "被删除成功";
		userService.delete(document);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 附件预览页面打开链接
	 * 
	 * @return
	 */
	@RequestMapping(params = "openViewFile")
	public ModelAndView openViewFile(HttpServletRequest request) {
		String fileid = request.getParameter("fileid");
		String subclassname = oConvertUtils.getString(request.getParameter("subclassname"), "org.jeecgframework.web.system.pojo.base.TSAttachment");
		String contentfield = oConvertUtils.getString(request.getParameter("contentfield"));
		Class fileClass = MyClassLoader.getClassByScn(subclassname);// 附件的实际类
		Object fileobj = systemService.getEntity(fileClass, fileid);
		ReflectHelper reflectHelper = new ReflectHelper(fileobj);
		String extend = oConvertUtils.getString(reflectHelper.getMethodValue("extend"));
		if ("dwg".equals(extend)) {
			String realpath = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
			request.setAttribute("realpath", realpath);
			return new ModelAndView("common/upload/dwgView");
		} else if (FileUtils.isPicture(extend)) {
			String realpath = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
			request.setAttribute("realpath", realpath);
			request.setAttribute("fileid", fileid);
			request.setAttribute("subclassname", subclassname);
			request.setAttribute("contentfield", contentfield);
			return new ModelAndView("common/upload/imageView");
		} else {
			String swfpath = oConvertUtils.getString(reflectHelper.getMethodValue("swfpath"));
			request.setAttribute("swfpath", swfpath);
			return new ModelAndView("common/upload/swfView");
		}

	}
	
	/**
	 * 保存文件
	 * 
	 * @param document
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSDocument document) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		TSTypegroup tsTypegroup=systemService.getTypeGroup("fieltype","文档分类");
		TSType tsType = systemService.getType("files","附件", tsTypegroup);
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		String documentTitle = oConvertUtils.getString(request.getParameter("documentTitle"));// 文件标题
		if (StringUtil.isNotEmpty(fileKey)) {
			document.setId(fileKey);
			document = systemService.getEntity(TSDocument.class, fileKey);
			document.setDocumentTitle(documentTitle);

		}
		
		//类别--类别 1.pdf文件 2.图片 3.视频
		document.setCategory((short)3);
		
		document.setSubclassname(MyClassLoader.getPackPath(document));
		document.setCreatedate(DateUtils.gettimestamp());
		document.setTSType(tsType);
		UploadFile uploadFile = new UploadFile(request, document);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		document = systemService.uploadFile(uploadFile);
		attributes.put("url", document.getRealpath());
		attributes.put("fileKey", document.getId());
		attributes.put("name", document.getAttachmenttitle());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + document.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + document.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);
		return j;
	}
	
	/**
	 * 附件预览读取
	 * 
	 * @return
	 */
	@RequestMapping(params = "viewFile")
	public void viewFile(HttpServletRequest request, HttpServletResponse response) {
		String fileid =oConvertUtils.getString(request.getParameter("fileid"));
		String subclassname = oConvertUtils.getString(request.getParameter("subclassname"), "com.jeecg.base.pojo.TSAttachment");
		Class fileClass = MyClassLoader.getClassByScn(subclassname);// 附件的实际类
		Object fileobj = systemService.getEntity(fileClass, fileid);
		ReflectHelper reflectHelper = new ReflectHelper(fileobj);
		UploadFile uploadFile = new UploadFile(request, response);
		String contentfield = oConvertUtils.getString(request.getParameter("contentfield"), uploadFile.getByteField());
		byte[] content = (byte[]) reflectHelper.getMethodValue(contentfield);
		String path = oConvertUtils.getString(reflectHelper.getMethodValue("realpath"));
		String extend = oConvertUtils.getString(reflectHelper.getMethodValue("extend"));
		String attachmenttitle = oConvertUtils.getString(reflectHelper.getMethodValue("attachmenttitle"));
		uploadFile.setExtend(extend);
		uploadFile.setTitleField(attachmenttitle);
		uploadFile.setRealPath(path);
		uploadFile.setContent(content);
		//uploadFile.setView(true);
		systemService.viewOrDownloadFile(uploadFile);
	}
	
}
