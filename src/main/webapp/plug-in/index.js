$(function(){
	
	//异步取出菜单及内容项
	$.ajax({
        url: "loginController.do?primaryMenu",
        async:false,
        success: function (data) {

//            $(".shortcut").html(data);
            $(".shortcut").html(data.replaceAll("\"", ""));

        }
    });
	
	
})