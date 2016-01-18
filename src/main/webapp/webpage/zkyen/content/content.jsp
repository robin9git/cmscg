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
    		url : 'zkyenmenuController.do?setPFunction&selfId=${function.id}&zky=zkhcy',
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
<body>
<%--update-start--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
<!-- beforeSubmit="setOrgIds" -->
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zkyencontentController.do?saveContent" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<input id="creatTime" name="creatTime" type="hidden" value="${ent.creatTime }">
	
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
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
		
		<!--  内容标题 -->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.contentTitle"/>: </label></td>
			<td class="value" width="85%">
                <input id="title" class="inputxt" name="title" value="${ent.title }">
            </td>
		</tr>
		<!--  内容长标题-->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.conLongTitle"/>: </label></td>
			<td class="value" width="85%">
                <input id="longTitle" class="inputxt" name="longTitle" value="${ent.longTitle }">
            </td>
		</tr>
		<!--  排序-->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.contOrder"/>: </label></td>
			<td class="value" width="85%">
                <input id="contOrder" class="inputxt" name="contOrder" value="${ent.contOrder }" datatype="n1-3">
            </td>
		</tr>
		<!--  是否是重要新闻，默认是否，是的情况下对公司新闻和行业动态有效-->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.newsLevel"/>: </label></td>
			<td class="value" width="85%">
                <select name="newsLevel" >
                	<option value="1" <c:if test="${ent.newsLevel==1 or ent.newsLevel==null or ent.newsLevel==''}">selected="selected"</c:if>>1级</option>
                	<option value="2" <c:if test="${ent.newsLevel==2}">selected="selected"</c:if>>2级</option>
                	<option value="3" <c:if test="${ent.newsLevel==3}">selected="selected"</c:if>>3级</option>
                </select>
            </td>
		</tr>
		<!--  文章来源-->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.newsfrom"/>: </label></td>
			<td class="value" width="85%">
                <input id="newsfrom" class="inputxt" name="newsfrom" value="${ent.newsfrom }">
            </td>
		</tr>
		<!--  文章发布时间  -->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 发布时间: </label></td>
			<td class="value" width="85%">
                <input id="publicTime" class="easyui-datebox" name="publicTime" value="${ent.publicTime }">
            </td>
		</tr>
		<!--  图片  -->
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">图片: </label></td>
			<td class="value" width="85%">
<!-- 				<ol id="preview"></ol> -->
<%-- 				<input type="hidden" name="picSrc" id="picSrc" value="${ent.picSrc}"> --%>
                <t:ckfinder name="picSrc" mutipUpload="true" uploadType="Images" value="${ent.picSrc}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
            </td>
		</tr>
		<tr>
<!-- 		内容 -->
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.content"/>: </label></td>
            <td class="value">
<%--             	<textarea rows="20" cols="80" name="content">${ent.content }</textarea> --%>
					<!--ckeditor编辑器 -->
            	<t:ckeditor name="content" isfinder="true" value="${ent.content }" type="width:750"></t:ckeditor>
            	<span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>

<script type="text/javascript">
Preview('picSrc_input');
</script>
<%--update-end--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
</body>