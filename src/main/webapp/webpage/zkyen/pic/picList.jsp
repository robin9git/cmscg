<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
<t:datagrid name="fList" title="文件下载" actionUrl="zkyenpicController.do?documentList&typecode=files&conId=${conId}" idField="id" fit="true">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
<%-- 	<t:dgCol title="标题" field="conName" width="20"></t:dgCol> --%>
	
	<t:dgCol title="标题" field="attachmenttitle" width="20" query="true"></t:dgCol>
	<t:dgCol title="类型" field="extend" width="20"></t:dgCol>
	
	<t:dgCol title="创建时间" field="createdate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgCol title="类名" field="subclassname" hidden="true"></t:dgCol>
	<t:dgCol title="操作" field="opt"></t:dgCol>
	<t:dgDefOpt url="zkyencommonController.do?viewFile&fileid={id}&subclassname={subclassname}" title="下载"></t:dgDefOpt>
	<t:dgOpenOpt width="800" height="700" url="zkyenpicController.do?openViewFile&fileid={id}&subclassname={subclassname}" title="预览"></t:dgOpenOpt>
	<t:dgDelOpt url="zkyenpicController.do?delDocument&id={id}" title="删除"></t:dgDelOpt>
	<t:dgToolBar title="图片录入" icon="icon-add" funname="add" url="zkyenpicController.do?addFiles&conId=${conId}"></t:dgToolBar>
</t:datagrid></div>
</div>