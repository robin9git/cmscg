<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
		<tr>
<!-- 		图片 -->
			<td align="right" width="15%" nowrap><label class="Validform_label"> 图片: </label></td>
			<td class="value" width="85%">
				<t:ckfinder name="image" uploadType="Images" value="${ent.image}" width="100" height="60" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
            </td>
		</tr>
