<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="compList" title="common.operation" actionUrl="zkyenzKLogoController.do?datagrid" 
    fit="true" fitColumns="true" idField="id">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="Logo" sortable="false" image="true" field="picSrc" imageSize="120,60"></t:dgCol>
	<t:dgCol title="common.createtime" field="creatDate" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgToolBar title="Logo编辑" langArg="comp.info" icon="icon-edit" url="zkyenzKLogoController.do?add" funname="update" width="800" height="550"></t:dgToolBar>
</t:datagrid>