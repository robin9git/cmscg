<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="recruitList" title="common.operation" actionUrl="recruitController.do?datagrid" 
    fit="true" fitColumns="true" idField="id" queryMode="group" sortName="createDate" sortOrder="desc">
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="common.recruitCategory" sortable="false" field="category" query="true"></t:dgCol>
    <%--update-start--Author:zhangguoming  Date:20140827 for：通过用户对象的关联属性值获取组织机构名称（多对多关联）--%>
	<%--<t:dgCol title="common.department" field="TSDepart_id" query="true" replace="${departsReplace}"></t:dgCol>--%>
	<t:dgCol title="common.jboTitle" sortable="false" field="jobTitle" query="true"></t:dgCol>
	<t:dgCol title="common.recNum" sortable="false" field="recNum"></t:dgCol>
    <%--update-end--Author:zhangguoming  Date:20140827 for：通过用户对象的关联属性值获取组织机构名称（多对多关联）--%>
	<t:dgCol title="common.specOrentation" field="specOrentation" sortable="false" width="300" style="table-layout:fixed;word-break:break-all;word-wrap:break-word;"></t:dgCol>
	<t:dgCol title="common.required" field="required" sortable="false" width="300"></t:dgCol>
	
<%-- 	<t:dgCol title="common.createby" field="createBy" hidden="true"></t:dgCol> --%>
	<t:dgCol title="common.createtime" field="createDate" formatter="yyyy-MM-dd hh:mm:ss" sortable="true"></t:dgCol>
<%-- 	<t:dgCol title="common.updateby" field="updateBy" hidden="true"></t:dgCol> --%>
<%-- 	<t:dgCol title="common.updatetime" field="updateDate" formatter="yyyy-MM-dd" hidden="true"></t:dgCol> --%>
<%-- 	<t:dgCol title="common.status" sortable="true" field="status" replace="common.active_1,common.inactive_0,super.admin_-1" ></t:dgCol> --%>
	<t:dgCol title="common.operation" field="opt"></t:dgCol>
	<t:dgDelOpt title="common.delete" url="recruitController.do?del&id={id}" />
	<t:dgToolBar title="common.add.param" langArg="common.recruit" icon="icon-add" url="recruitController.do?addorupdate" funname="add" width="900" height="850"></t:dgToolBar>
	<t:dgToolBar title="common.edit.param" langArg="common.recruit" icon="icon-edit" url="recruitController.do?addorupdate" funname="update" width="900" height="850"></t:dgToolBar>
<%-- 	<t:dgToolBar title="common.password.reset" icon="icon-edit" url="userController.do?changepasswordforuser" funname="update"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="common.lock.user" icon="icon-edit" url="userController.do?lock&lockvalue=0" funname="lockObj"></t:dgToolBar> --%>
<%-- 	<t:dgToolBar title="common.unlock.user" icon="icon-edit" url="userController.do?lock&lockvalue=1" funname="unlockObj"></t:dgToolBar> --%>
	
</t:datagrid>
<script type="text/javascript">

function lockObj(title,url, id) {

	gridname=id;
	var rowsData = $('#'+id).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('<t:mutiLang langKey="common.please.select.edit.item"/>');
		return;
	}
		url += '&id='+rowsData[0].id;

	$.dialog.confirm('<t:mutiLang langKey="common.lock.user.tips"/>', function(){
		lockuploadify(url, '&id');
	}, function(){
	});
}
function unlockObj(title,url, id) {

	gridname=id;
	var rowsData = $('#'+id).datagrid('getSelections');
	if (!rowsData || rowsData.length==0) {
		tip('<t:mutiLang langKey="common.please.select.edit.item"/>');
		return;
	}
		url += '&id='+rowsData[0].id;

	$.dialog.confirm('<t:mutiLang langKey="common.unlock.user.tips"/>', function(){
		lockuploadify(url, '&id');
	}, function(){
	});
}


function lockuploadify(url, id) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		
		
		},
		success : function(data) {
			var d = $.parseJSON(data);
			if (d.success) {
			var msg = d.msg;
				tip(msg);
				reloadTable();
			}
			
		}
	});
}
</script>

<%--update-start--Author:zhangguoming  Date:20140827 for：添加 组织机构查询条件：弹出 选择组织机构列表 相关操作--%>
<%--<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" onClick="choose_297e201048183a730148183ad85c0001()">选择</a>--%>
<%--<a href="#" class="easyui-linkbutton" plain="true" icon="icon-redo" onClick="clearAll_297e201048183a730148183ad85c0001();">清空</a>--%>
<script type="text/javascript">
//    var windowapi = frameElement.api, W = windowapi.opener;
    function choose_297e201048183a730148183ad85c0001() {
        if (typeof(windowapi) == 'undefined') {
            $.dialog({content: 'url:departController.do?departSelect', zIndex: 2100, title: '<t:mutiLang langKey="common.department.list"/>', lock: true, width: 400, height: 350, left: '85%', top: '65%', opacity: 0.4, button: [
                {name: '<t:mutiLang langKey="common.confirm"/>', callback: clickcallback_297e201048183a730148183ad85c0001, focus: true},
                {name: '<t:mutiLang langKey="common.cancel"/>', callback: function () {
                }}
            ]});
        } else {
            $.dialog({content: 'url:departController.do?departSelect', zIndex: 2100, title: '<t:mutiLang langKey="common.department.list"/>', lock: true, parent: windowapi, width: 400, height: 350, left: '85%', top: '65%', opacity: 0.4, button: [
                {name: '<t:mutiLang langKey="common.confirm"/>', callback: clickcallback_297e201048183a730148183ad85c0001, focus: true},
                {name: '<t:mutiLang langKey="common.cancel"/>', callback: function () {
                }}
            ]});
        }
    }
    function clearAll_297e201048183a730148183ad85c0001() {
        if ($('#departname').length >= 1) {
            $('#departname').val('');
            $('#departname').blur();
        }
        if ($("input[name='departname']").length >= 1) {
            $("input[name='departname']").val('');
            $("input[name='departname']").blur();
        }
        $('#orgIds').val("");
    }
    function clickcallback_297e201048183a730148183ad85c0001() {
        iframe = this.iframe.contentWindow;
        var departname = iframe.getdepartListSelections('departname');
        if ($('#departname').length >= 1) {
            $('#departname').val(departname);
            $('#departname').blur();
        }
        if ($("input[name='departname']").length >= 1) {
            $("input[name='departname']").val(departname);
            $("input[name='departname']").blur();
        }
        var id = iframe.getdepartListSelections('id');
        if (id !== undefined && id != "") {
            $('#orgIds').val(id);
            $("input[name='orgIds']").val(id);
        }
    }
</script>
<%--update-end--Author:zhangguoming  Date:20140827 for：添加 组织机构查询条件：弹出 选择组织机构列表 相关操作--%>
