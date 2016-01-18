<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<%--   update-start--Author:duanql  Date:20130619 for：操作按钮窗口显示控制--%>
<div id="system_function_functionList" class="easyui-layout" fit="true"><%--   update-end--Author:duanql  Date:20130619 for：操作按钮窗口显示控制--%>
<div region="center" style="padding: 1px;">
    <t:datagrid name="functionList" title="menu.manage"
                actionUrl="menuController.do?functionGrid" idField="id" treegrid="true" pagination="false">
        <t:dgCol title="common.id" field="id" treefield="id" hidden="true"></t:dgCol>
        <t:dgCol title="menu.name" field="functionName" treefield="text"></t:dgCol>
        <t:dgCol title="common.icon" field="TSIcon_iconPath" treefield="code" image="true"></t:dgCol>
        <t:dgCol title="funcType" field="functionType" treefield="functionType" replace="funcType.page_0,funcType.from_1"></t:dgCol>
        <t:dgCol title="menu.url" field="functionUrl" treefield="src"></t:dgCol>
        <t:dgCol title="menu.order" field="functionOrder" treefield="order"></t:dgCol>
<%--         <t:dgCol title="显示位置" field="show_type" replace="仅首部显示_1,仅底部显示_2,普通栏目菜单_3,首底部显示_4"></t:dgCol> --%>
        <t:dgCol title="显示位置" field="show_type" dictionary="show_type" treefield="type"></t:dgCol>
        
<%--          <t:dgCol title="111" field="del_access" treefield="delAccess"></t:dgCol> --%>
        <t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
<%--         <c:if test="{{del_access} == 1 }"> --%>
<!-- 			 -->
	        <t:dgDelOpt exp="delAccess#eq#1" url="menuController.do?del&id={id}" title="common.delete"></t:dgDelOpt>
<%--         </c:if> --%>
        
        <t:dgToolBar title="common.add.param" langArg="common.menu" icon="icon-add" url="menuController.do?addorupdate" funname="addFun"></t:dgToolBar>
        <t:dgToolBar title="common.edit.param" langArg="common.menu" icon="icon-edit" url="menuController.do?addorupdate" funname="update"  height="550"></t:dgToolBar>
    </t:datagrid>
</div>
</div>
<%--   update-start--Author:duanql  Date:20130619 for：操作按钮窗口显示控制--%>
<div data-options="region:'east',
	title:'<t:mutiLang langKey="operate.button.list"/>',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 400px; overflow: hidden;">
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="operationDetailpanel"></div>
</div>
</div>

<script type="text/javascript">
<%--   update-start--Author:anchao  Date:20130415 for：按钮权限控制--%>
$(function() {
	var li_east = 0;
});
//数据规则权数
function  operationData(fucntionId){
	if(li_east == 0){
	   $('#system_function_functionList').layout('expand','east'); 
	}
	$('#operationDetailpanel').panel("refresh", "menuController.do?dataRule&functionId=" +fucntionId);
}
function operationDetail(functionId)
{
	if(li_east == 0){
	   $('#system_function_functionList').layout('expand','east'); 
	}
	$('#operationDetailpanel').panel("refresh", "menuController.do?operation&functionId=" +functionId);
}
<%--   update-end--Author:anchao  Date:20130415 for：按钮权限控制--%>
<%--   update-start--Author:jueyue  Date:20130622 for：菜单录入代入父菜单--%>
function addFun(title,url, id) {
	var rowData = $('#'+id).datagrid('getSelected');
	if (rowData) {
		url += '&TSFunction.id='+rowData.id;
	}
	add(title,url,'functionList','',550);
}
<%--   update-end--Author:jueyue  Date:20130622 for：菜单录入代入父菜单--%>
</script>

