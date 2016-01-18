<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>中科合成油信息</title>
<t:base type="jquery,easyui,tools"></t:base>
<body style="overflow-y: hidden" scroll="no">

<c:forEach items="${functionList}" varStatus="st" var="flm">
${flm.functionName} &nbsp;&nbsp;
</c:forEach>
<br>
----------------------------------------------</br>
<c:forEach items="${functionList2}" varStatus="st" var="flm">
${flm.functionName} &nbsp;&nbsp;
</c:forEach>
<br>
------------------------------------------------------<br>
<c:forEach items="${functionList3}" varStatus="st" var="flm">
${flm.functionName} &nbsp;&nbsp;
</c:forEach>
<br>
-----------------------------------------------------------<br>
<c:forEach items="${functionList4}" varStatus="st" var="flm">
${flm.functionName} &nbsp;&nbsp;
</c:forEach>

</body>