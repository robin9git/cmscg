<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.pic"/>信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" beforeSubmit="upload">
	<input type="hidden" name="conId" id="conId" value="${zkCInfo.id}">

	<fieldset class="step">
	<div class="form">
		<label class="Validform_label"> 文件标题: </label>  &nbsp;&nbsp; ${zkCInfo.title}
		<input name="conName" id="conName" type="hidden" value="${zkCInfo.title}"> 
	</div>
	<div class="form">
		<t:upload name="fiels" buttonText="上传图片" uploader="zkyenpicController.do?saveFiles" extend="pic" id="file_upload" formData="conName,conId"></t:upload>
	</div>
	<div class="form" id="filediv" style="height: 50px"></div>
	</fieldset>
</t:formvalid>
</body>