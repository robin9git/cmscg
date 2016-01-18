<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.recruit"/>信息</title>
<%-- <t:base type="jquery,easyui,tools"></t:base> --%>

<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">

</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" layout="table" action="recruitController.do?saveRecruit" >
	<input id="id" name="id" type="hidden" value="${rInfo.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="common.recruitCategory"/>: </label>
            </td>
			<td class="value" width="85%">
<!--                 招聘类别 -->
                    <input id="category" class="inputxt" name="category" value="${rInfo.category }" datatype="*" />
<%--                     <span class="Validform_checktip"> <t:mutiLang langKey="username.rang2to10"/></span> --%>
            </td>
		</tr>
		<tr>
<!-- 		岗位名称 -->
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.jboTitle"/>: </label></td>
			<td class="value" width="10%">
                <input id="jobTitle" class="inputxt" name="jobTitle" validType="recruit_info,job_title,id" value="${rInfo.jobTitle }" datatype="*">
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
		<tr>
<!-- 		招聘人数 -->
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.recNum"/>: </label></td>
			<td class="value" width="10%">
                <input id="recNum" class="inputxt" name="recNum" value="${rInfo.recNum }" datatype="n1-2">
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
		<tr>
<!-- 		专业方向 -->
			<td align="right" nowrap><label class="Validform_label">  <t:mutiLang langKey="common.specOrentation"/>: </label></td>
<!-- 			<td class="value"> -->
<%--                 <textarea name="specOrentation" rows="9" cols="50" datatype="*">${rInfo.specOrentation }</textarea> --%>
<!--                  <span class="Validform_checktip"></span>  -->
<!--             </td>  -->
            
             <td class="value"><t:ckeditor name="specOrentation" isfinder="true" value="${rInfo.specOrentation }" type="width:750"></t:ckeditor></td>
		</tr>
		<tr>
<!-- 		任职要求 -->
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.required"/>: </label></td>
<!-- 			<td class="value"> -->
<%--                 <textarea name="required" rows="9" cols="50" datatype="*">${rInfo.required }</textarea> --%>
<!--                <span class="Validform_checktip"></span> -->
<!--             </td> -->
            
            <td class="value"><t:ckeditor name="required" isfinder="true" value="${rInfo.required }" type="width:750"></t:ckeditor></td>
		</tr>
		
	</table>
</t:formvalid>
</body>