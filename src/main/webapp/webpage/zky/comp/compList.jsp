<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="compList" title="common.operation" actionUrl="compController.do?datagrid" 
    fit="true" fitColumns="true" idField="id">
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="comp.addr" sortable="false" field="addr"></t:dgCol>
	<t:dgCol title="comp.tele" sortable="false" field="tele"></t:dgCol>
	<t:dgCol title="comp.fax" field="fax" sortable="false"></t:dgCol>
	<t:dgCol title="comp.email" field="email" sortable="false"></t:dgCol>
	<t:dgCol title="common.createtime" field="creatTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
<%-- 	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol> --%>
<%-- 	<t:dgDelOpt title="common.delete" url="compController.do?del&id={id}" /> --%>
	
<%-- 	<t:dgToolBar title="common.add.param"  langArg="comp.info" icon="icon-add" url="compController.do?addorupdate" funname="add" width="900" height="550"></t:dgToolBar> --%>
	<t:dgToolBar title="common.edit.param" langArg="comp.info" icon="icon-edit" url="compController.do?addorupdate" funname="update" width="900" height="550"></t:dgToolBar>
</t:datagrid>