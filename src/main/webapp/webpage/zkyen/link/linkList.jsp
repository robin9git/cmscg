<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="linkList" title="common.operation" actionUrl="zkyenlinkController.do?datagrid" 
    fit="true" fitColumns="true" idField="id" queryMode="group" sortName="creatTime" sortOrder="desc" >
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="link.category" query="true" sortable="true" field="category" replace="link.gavern_2,link.coppe_3,link.socia_4" ></t:dgCol>
	<t:dgCol title="link.name" sortable="false" field="name"></t:dgCol>
	<t:dgCol title="link.url" field="url" sortable="false"></t:dgCol>
	<t:dgCol title="common.createtime" field="creatTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="common.delete" url="zkyenlinkController.do?del&id={id}" />
	
	<t:dgToolBar title="common.add.param" langArg="common.link" icon="icon-add" url="zkyenlinkController.do?addorupdate" funname="add" width="900" height="550"></t:dgToolBar>
	<t:dgToolBar title="common.edit.param" langArg="common.link" icon="icon-edit" url="zkyenlinkController.do?addorupdate" funname="update" width="900" height="550"></t:dgToolBar>
</t:datagrid>