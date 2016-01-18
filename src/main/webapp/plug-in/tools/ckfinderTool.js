function decode(value, id) {// value传入值,id接受值
	var last = value.lastIndexOf("/");
	var filename = value.substring(last + 1, value.length);
	$("#" + id).text(decodeURIComponent(filename));
}
function browse(inputId, file, type) {// 文件管理器，可多个上传共用
	var finder = new CKFinder();
	finder.selectActionFunction = function(fileUrl, data) {// 设置文件被选中时的函数
		$("#" + inputId).attr("value",fileUrl);
		if ("Images" != type) { // equals函数无效? 改为符号判断 --- Alexander
			$("#" + file).attr("href", fileUrl);
			decode(fileUrl, file);
		} else {
			$("#" + file).attr("src", fileUrl);
			$("#" + file).attr("hidden", false);
		}
	};
	finder.resourceType = type;// 指定ckfinder只为type进行管理
	finder.selectActionData = inputId; // 接收地址的input ID
	finder.removePlugins = 'help';// 移除帮助(只有英文)
	finder.defaultLanguage = 'zh-cn';
	finder.popup();
}

function browseImg(inputId, file, type) {// 文件管理器，可多个上传共用
	var finder = new CKFinder();
	finder.selectActionFunction = function(fileUrl, data) {// 设置文件被选中时的函数
		$("#" + inputId).attr("value",( $('#'+inputId).val()==''?'':$('#'+inputId).val() +"|" )+fileUrl);
		if ("Images" != type) { // equals函数无效? 改为符号判断 --- Alexander
			$("#" + file).attr("href", fileUrl);
			decode(fileUrl, file);
		} else {
//			$("#" + file).attr("src", fileUrl);
//			$("#" + file).attr("hidden", false);
			Preview(inputId);
		}
	};
	finder.resourceType = type;// 指定ckfinder只为type进行管理
	finder.selectActionData = inputId; // 接收地址的input ID
	finder.removePlugins = 'help';// 移除帮助(只有英文)
	finder.defaultLanguage = 'zh-cn';
	finder.popup();
}

//获取文件大小KB并返回
function browseWSize(inputId, file, type,size) {// 文件管理器，可多个上传共用
	var finder = new CKFinder();
	finder.selectActionFunction = function(fileUrl, data) {// 设置文件被选中时的函数
		$("#" + inputId).attr("value",fileUrl);
		if ("Images" != type) { // equals函数无效? 改为符号判断 --- Alexander
			$("#" + file).attr("href", fileUrl);
			//设置文件大小KB add by zhh 2016年1月15日11:13:51
			$("#" + size).val(data.fileSize);
			
			decode(fileUrl, file);
		} else {
			$("#" + file).attr("src", fileUrl);
			$("#" + file).attr("hidden", false);
		}
	};
	finder.resourceType = type;// 指定ckfinder只为type进行管理
	finder.selectActionData = inputId; // 接收地址的input ID
	finder.removePlugins = 'help';// 移除帮助(只有英文)
	finder.defaultLanguage = 'zh-cn';
	finder.popup();
}


function Preview(inputId){
	var li, urls = $("#"+inputId).val().split("|");
	$("#preview").children().remove();
	for (var i=0; i<urls.length; i++){
		if (urls[i]!=""){//<c:if test="${type eq 'thumb' || type eq 'images'}">
			li = "<li><img src=\""+urls[i]+"\" url=\""+urls[i]+"\" style=\"max-width:150px;max-height:110px;_height:110px;border:0;padding:2px;\">";//</c:if><c:if test="${type ne 'thumb' && type ne 'images'}">
//			li = "<li><a href=\""+urls[i]+"\" url=\""+urls[i]+"\" target=\"_blank\">"+decodeURIComponent(urls[i].substring(urls[i].lastIndexOf("/")+1))+"</a>";//</c:if>
			li += "&nbsp;&nbsp;<a href=\"javascript:\" onclick=\"Del('"+inputId+"',this);\">×</a></li>";
			$("#preview").append(li);
		}
	}
	if ($("#preview").text() == ""){
		$("#preview").html("<li style='list-style:none;padding-top:5px;'>无</li>");
	}
}

function DelAll(inputId){
	$("#"+inputId).val("");
	Preview(inputId);
}

function Del(inputId,obj){
	var url = $(obj).prev().attr("url");
	$("#"+inputId).val($("#"+inputId).val().replace("|"+url,"","").replace(url+"|","","").replace(url,"",""));
	Preview(inputId);
}
//Preview('picSrc_input');
