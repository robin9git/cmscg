<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.recruit"/>信息</title>

<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">

    <%--update-start--Author:zhangguoming  Date:20140825 for：添加组织机构combobox多选的处理方法--%>
    <script>
    $(function() {
    	$('#cc').combotree({
    		url : 'menuController.do?setPFunction&selfId=${function.id}&zky=zkhcy',
    		panelHeight: 200,
    		width: 157,
    		onClick: function(node){
    			$("#functionId").val(node.id);
    			$("#cc").val(node.text);
    		}
    	});
    	
    });
    
    </script>
    <%--update-end--Author:zhangguoming  Date:20140825 for：添加组织机构combobox多选的处理方法--%>
</head>
<body style="overflow-y: hidden" scroll="no">
<%--update-start--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
<!-- beforeSubmit="setOrgIds" -->
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="moduleController.do?saveContent" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<table style="width: 600px;height: 400px;" cellpadding="0" cellspacing="1" class="formtable" >
		<tr>
			<td align="right" width="15%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="menu.name"/>: </label>
            </td>
			<td class="value" width="85%">
<!--                 菜单名称 -->
<%--                     <input id="menuName" class="inputxt" name="menuName" validType="t_s_base_user,userName,id" value="${ent.menuName }" datatype="*" /> --%>
<%--                     <span class="Validform_checktip"> <t:mutiLang langKey="username.rang2to10"/></span> --%>

					<input id="cc" value="${ent.TSFunction.functionName}" datatype="*" >
			        <input id="functionId" name="TSFunction.id" style="display: none;" value="${ent.TSFunction.id}">

            </td>
		</tr>
		<tr>
<!-- 		内容标题--英文 -->
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.contentTitleEN"/>: </label></td>
			<td class="value" width="85%">
                <input id="contentTitleEN" class="inputxt" name="titleEN" value="${ent.titleEN }"> <span style="color: red;margin-left: 15px;"> (如需显示换行，请以'|'分隔)</span>
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
		<tr>
<!-- 		是否首页展示-->
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.isshow"/>: </label></td>
			<td class="value" width="85%">
<%--                 <input id="contOrder" class="inputxt" name="contOrder" value="${ent.contOrder }" datatype="n1-3"> --%>
                <select name="isshow" >
                	<option value="1" <c:if test="${ent.isshow==1 or ent.isshow==null or ent.isshow==''}">selected="selected"</c:if>>是</option>
                	<option value="2" <c:if test="${ent.isshow==2}">selected="selected"</c:if>>否</option>
                </select>
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
		<tr>
<!-- 		排序 -->
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="menu.order"/>: </label></td>
			<td class="value" width="85%">
                <input id="functionOrder" class="inputxt" name="functionOrder" value="${ent.functionOrder }" datatype="n1-3">
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
		
<%-- 		<jsp:include page="../comm/comm_pic.jsp"></jsp:include> --%>
		
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 图片: </label></td>
			<td class="value" width="85%">
				<t:ckfinder name="picSrc" uploadType="Images" value="${ent.picSrc}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
            </td>
		</tr>
		
	</table>
</t:formvalid>
<%--update-end--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
</body>