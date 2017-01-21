/**
 * description:后台主页初始化
 * author:ladeng
 */
$(function(){
	
	// 页面样式配置
	$.get("../skin-config", function (data) {
        if (!$('body').hasClass('no-skin-config'))
            $('body').append(data);
    });
});