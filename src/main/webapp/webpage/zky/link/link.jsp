<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.link"/>信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="linkController.do?save" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="link.category"/>: </label>
            </td>
			<td class="value" width="85%">
				<select name="category">
<%-- 					<option value="1" <c:if test="${ent.category==1}">selected="selected"</c:if> ><t:mutiLang langKey="link.frinde"/></option> --%>
					<option value="2" <c:if test="${ent.category==2}">selected="selected"</c:if> ><t:mutiLang langKey="link.gavern"/></option>
					<option value="3" <c:if test="${ent.category==3}">selected="selected"</c:if> ><t:mutiLang langKey="link.coppe"/></option>
<%-- 					<option value="4" <c:if test="${ent.category==4}">selected="selected"</c:if> ><t:mutiLang langKey="link.socia"/></option> --%>
				</select>	
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="link.name"/>: </label></td>
			<td class="value" width="10%">
                <input id="name" class="inputxt" name="name" value="${ent.name }" datatype="*">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="link.url"/>: </label></td>
			<td class="value" width="10%">
                <input id="url" class="inputxt" name="url" value="${ent.url }" datatype="url">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap><label class="Validform_label"> 排序: </label></td>
			<td class="value" width="10%">
                <input id="conOrder" class="inputxt" name="conOrder" value="${ent.conOrder }" datatype="n1-4" maxlength="4">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
</body>