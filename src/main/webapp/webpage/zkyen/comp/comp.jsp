<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.comp"/>信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zkyencompController.do?save" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="comp.addr"/>: </label>
            </td>
			<td class="value" width="85%">
                <input id="addr" class="inputxt" name="addr" value="${ent.addr }" datatype="*" >
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="comp.tele"/>: </label></td>
			<td class="value" width="85%">
                <input id="tele" class="inputxt" name="tele" value="${ent.tele }" datatype="mz" maxlength="13">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="comp.fax"/>: </label></td>
			<td class="value" width="85%">
                <input id="fax" class="inputxt" name="fax" value="${ent.fax }" datatype="mz" maxlength="13">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> <t:mutiLang langKey="comp.email"/>: </label></td>
			<td class="value" width="85%">
                <input id="email" class="inputxt" name="email" value="${ent.email }" datatype="e" maxlength="20">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>