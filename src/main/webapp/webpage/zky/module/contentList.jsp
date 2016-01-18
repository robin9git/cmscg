<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<t:datagrid name="moduleList" title="common.operation" actionUrl="moduleController.do?datagrid" 
    fit="true" fitColumns="true" idField="id" queryMode="group" sortName="functionOrder" sortOrder="asc" >
	<t:dgCol title="common.id" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="menu.name" sortable="false" field="TSFunction.functionName" query="true"></t:dgCol>
    <%--update-start--Author:zhangguoming  Date:20140827 for：通过用户对象的关联属性值获取组织机构名称（多对多关联）--%>
	<%--<t:dgCol title="common.department" field="TSDepart_id" query="true" replace="${departsReplace}"></t:dgCol>--%>
<%-- 	<t:dgCol title="common.contentTitle" field="title" sortable="false"></t:dgCol> --%>
    <%--update-end--Author:zhangguoming  Date:20140827 for：通过用户对象的关联属性值获取组织机构名称（多对多关联）--%>
	<t:dgCol title="common.contentTitleEN" field="titleEN" sortable="false"></t:dgCol>
	<t:dgCol title="common.isshow" field="isshow" sortable="false" replace="common.disok_1,common.disno_2"></t:dgCol>
	<t:dgCol title="common.contOrder" field="functionOrder" sortable="true"></t:dgCol>
<!-- 	imageSize="280,170"  -->
	<t:dgCol title="图片" field="picSrc" sortable="false" image="true" imageSize="100,100"></t:dgCol>
	<t:dgCol title="common.createtime" field="creatTime" formatter="yyyy-MM-dd hh:mm:ss"></t:dgCol>
<%-- 	<t:dgCol title="common.status" sortable="true" field="status" replace="common.approvalPass_1,common.approvalWait_0,common.approvalFail_2" ></t:dgCol> --%>
	<t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="common.delete" url="moduleController.do?del&id={id}" />
	<!-- 	图片编辑 -->
<%-- 	<t:dgFunOpt funname="picEdit(id)" title="common.picEdit" ></t:dgFunOpt> --%>
	
<%-- 	<c:if test="${USER.userKey=='管理员'}"> --%>
		<!-- 	审核操作	 -->
<%-- 		<t:dgFunOpt funname="review(id)" title="common.reviewOper" ></t:dgFunOpt> --%>
<%-- 	</c:if> --%>
	
	<t:dgToolBar title="common.add.param" langArg="common.content" icon="icon-add" url="moduleController.do?addorupdate" funname="add" width="900" height="650"></t:dgToolBar>
	<t:dgToolBar title="common.edit.param" langArg="common.content" icon="icon-edit" url="moduleController.do?addorupdate" funname="update" width="900" height="650"></t:dgToolBar>
</t:datagrid>

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
    
	function picEdit(id) {
		window.location.href="/ZKYController.do?pic&id=" + id;
	}
	
	function review(id) {
		var url="moduleController.do?changeStatus&id="+id;
		//异步修正内容的审核状态
		changeStatus(url);
	}
    
	function changeStatus(url) {
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
// 					reloadTable();
					//刷新datagrid
					$('#moduleList').datagrid('reload');
				}
				
			}
		});
	}
	
</script>