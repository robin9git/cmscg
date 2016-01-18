<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>文件列表</title>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" type="text/css" href="plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
</head>
<body style="scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" action="elcController.do?saveContent" >
	<input id="id" name="id" type="hidden" value="${ent.id }">
	<input id="creatDate" name="creatDate" type="hidden" value="${ent.creatDate }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">栏目: </label></td>
			<td class="value" width="85%">
	        	<t:dictSelect field="menu" typeGroupCode="zkyMenu" hasLabel="false" defaultVal="${ent.menu!=null?ent.menu:1}" ></t:dictSelect>
	        	<span class="Validform_checktip"></span>
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">年份: </label></td>
			<td class="value" width="85%">
	        	<t:dictSelect field="year" typeGroupCode="zkyYear" hasLabel="false" defaultVal="${ent.year!=null?ent.year:2016}" ></t:dictSelect>
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">标题1: </label></td>
			<td class="value" width="85%">
	        	<input type="text" name="title1" value="${ent.title1 }">
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">标题2: </label></td>
			<td class="value" width="85%">
	        	<input type="text" name="title2" value="${ent.title2 }">
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">图片: </label></td>
			<td class="value" width="85%">
	        	<t:ckfinder name="picSrc" uploadType="Images" value="${ent.picSrc}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label">附件: </label></td>
			<td class="value" width="85%">
	        	<t:ckfinder name="fileSrc" size="fileSize" uploadType="Files" value="${ent.fileSrc}" width="100" height="60" buttonClass="ui-button" buttonValue="上传附件"></t:ckfinder>
	        </td>
		</tr>
		<tr>
			<td align="right" width="15%" nowrap><label class="Validform_label"> 简述: </label></td>
			<td class="value" width="85%">
	              <textarea rows="6" cols="30" name="des"> ${ent.des }</textarea>
	        </td>
		</tr>
	</table>
</t:formvalid>

<script type="text/javascript">
Preview('picSrc_input');
</script>

</body>
</html>
