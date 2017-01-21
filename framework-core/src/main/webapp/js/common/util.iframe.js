	/**
	 * util.iframe.js (v1.0)
	 * http://www.smertbox.com
	 * mailto:smertbox@126.com
	 * Copyright (c) 2016 SmertBox LaDeng
	 */

	/************************************
	 * 		 iframe组件
	 * **********************************/	

	/**
	 *自动iframe高度工具 
	 *author:ladeng
	 */
	$(function(){
		//auto_iframe("rightpage","iframe-div");
	});
	
	/**
	 * 
	 * @param _iframe iframe id
	 * @param _div iframe容器id
	 */
	function auto_iframe(_iframe,_div){
		try{
			var iframe = document.getElementById(_iframe);
			var ht = iframe.contentWindow.document.documentElement.scrollHeight;
			document.getElementById(_div).style.height=ht+"px";
		}catch(e){
			throw new Error("自动iframe错误!"+e);
		}
		
	}
	
