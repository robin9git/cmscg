<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Logo信息</title>
<t:base type="jquery,easyui,tools,ckfinder,ckeditor"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zKLogoController.do?save" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<input id="creatDate" name="creatDate" type="hidden" value="${ent.creatDate }">
	
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> Logo: </label></td>
			<td class="value" width="85%">
                <t:ckfinder name="picSrc" uploadType="Images" value="${ent.picSrc}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>