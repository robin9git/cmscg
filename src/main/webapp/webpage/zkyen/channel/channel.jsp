<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><t:mutiLang langKey="common.channel"/>信息</title>
<t:base type="jquery,easyui,tools"></t:base>
    <%--update-start--Author:zhangguoming  Date:20140825 for：添加组织机构combobox多选的处理方法--%>
    <script>
//         function setOrgIds() {
// //            var orgIds = $("#orgSelect").combobox("getValues");
//             var orgIds = $("#orgSelect").combotree("getValues");
//             $("#orgIds").val(orgIds);
//         }
//         $(function() {
//             $("#orgSelect").combotree({
//                 onChange: function(n, o) {
//                     if($("#orgSelect").combotree("getValues") != "") {
//                         $("#orgSelect option").eq(1).attr("selected", true);
//                     } else {
//                         $("#orgSelect option").eq(1).attr("selected", false);
//                     }
//                 }
//             });
<%--             $("#orgSelect").combobox("setValues", ${orgIdList}); --%>
//             $("#orgSelect").combotree("setValues", ${orgIdList});
//         });
    </script>
    <%--update-end--Author:zhangguoming  Date:20140825 for：添加组织机构combobox多选的处理方法--%>
</head>
<body style="overflow-y: hidden" scroll="no">
<%--update-start--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
<!-- beforeSubmit="setOrgIds" -->
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zkyenrecruitController.do?saveRecruit" >
	<input id="id" name="id" type="hidden" value="${user.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" width="15%" nowrap>
                <label class="Validform_label">  <t:mutiLang langKey="common.recruitCategory"/>: </label>
            </td>
			<td class="value" width="85%">
                <c:if test="${user.id!=null }"> ${user.userName } </c:if>
                <c:if test="${user.id==null }">
                
<!--                 招聘类别 -->
                    <input id="userName" class="inputxt" name="userName" validType="t_s_base_user,userName,id" value="${user.userName }" datatype="s2-10" />
<%--                     <span class="Validform_checktip"> <t:mutiLang langKey="username.rang2to10"/></span> --%>
                </c:if>
            </td>
		</tr>
		<tr>
<!-- 		岗位名称 -->
			<td align="right" width="10%" nowrap><label class="Validform_label"> <t:mutiLang langKey="common.jboTitle"/>: </label></td>
			<td class="value" width="10%">
                <input id="realName" class="inputxt" name="realName" value="${user.realName }" datatype="s2-10">
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="fill.realname"/></span> --%>
            </td>
		</tr>
<%-- 		<c:if test="${user.id==null }"> --%>
<!-- 			<tr> -->
<%-- 				<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.password"/>: </label></td> --%>
<!-- 				<td class="value"> -->
<!--                     <input type="password" class="inputxt" value="" name="password" plugin="passwordStrength" datatype="*6-18" errormsg="" /> -->
<!--                     <span class="passwordStrength" style="display: none;"> -->
<%--                         <span><t:mutiLang langKey="common.weak"/></span> --%>
<%--                         <span><t:mutiLang langKey="common.middle"/></span> --%>
<%--                         <span class="last"><t:mutiLang langKey="common.strong"/></span> --%>
<!--                     </span> -->
<%--                     <span class="Validform_checktip"> <t:mutiLang langKey="password.rang6to18"/></span> --%>
<!--                 </td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.repeat.password"/>: </label></td> --%>
<!-- 				<td class="value"> -->
<%--                     <input id="repassword" class="inputxt" type="password" value="${user.password}" recheck="password" datatype="*6-18" errormsg="两次输入的密码不一致！"> --%>
<%--                     <span class="Validform_checktip"><t:mutiLang langKey="common.repeat.password"/></span> --%>
<!--                 </td> -->
<!-- 			</tr> -->
<%-- 		</c:if> --%>
<!-- 		<tr> -->
<%-- 			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.department"/>: </label></td> --%>
<!-- 			<td class="value"> -->
<%--                 update-start--Author:zhangguoming  Date:20140826 for：将combobox修改为combotree --%>
<%--                 <select class="easyui-combobox" data-options="multiple:true, editable: false" id="orgSelect" datatype="*"> --%>
<!--                 <select class="easyui-combotree" data-options="url:'departController.do?getOrgTree', multiple:true, cascadeCheck:false" -->
<!--                         id="orgSelect" name="orgSelect" datatype="select1"> -->
<%--                 update-end--Author:zhangguoming  Date:20140826 for：将combobox修改为combotree --%>
<%--                     <c:forEach items="${departList}" var="depart"> --%>
<%--                         <option value="${depart.id }">${depart.departname}</option> --%>
<%--                     </c:forEach> --%>
<!--                 </select> -->
<!--                 <input id="orgIds" name="orgIds" type="hidden"> -->
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="please.select.department"/></span> --%>
<!--             </td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<%-- 			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.role"/>: </label></td> --%>
<!-- 			<td class="value" nowrap> -->
<%--                 <input name="roleid" name="roleid" type="hidden" value="${id}" id="roleid"> --%>
<%--                 <input name="roleName" class="inputxt" value="${roleName }" id="roleName" readonly="readonly" datatype="*" /> --%>
<%--                 <t:choose hiddenName="roleid" hiddenid="id" url="userController.do?roles" name="roleList" --%>
<%--                           icon="icon-search" title="common.role.list" textname="roleName" isclear="true" isInit="true"></t:choose> --%>
<%--                 <span class="Validform_checktip"><t:mutiLang langKey="role.muti.select"/></span> --%>
<!--             </td> -->
<!-- 		</tr> -->
		<tr>
<!-- 		专业方向 -->
			<td align="right" nowrap><label class="Validform_label">  <t:mutiLang langKey="common.specOrentation"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="mobilePhone" value="${user.mobilePhone}" datatype="m" errormsg="手机号码不正确" ignore="ignore">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
<!-- 		任职要求 -->
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.required"/>: </label></td>
			<td class="value">
<!--                 <input class="inputxt" name="required" value="" datatype="n" errormsg="办公室电话不正确" ignore="ignore"> -->
                
                <textarea name="required" rows="3" cols=""></textarea>
                
                <span class="Validform_checktip"></span>
            </td>
		</tr>
	</table>
</t:formvalid>
<%--update-end--Author:zhangguoming  Date:20140825 for：格式化页面代码 并 添加组织机构combobox多选框--%>
</body>