	/**
	 * util.subpage.js (v1.0)
	 * http://www.smertbox.com
	 * mailto:smertbox@126.com
	 * Copyright (c) 2016 SmertBox LaDeng
	 */

	/************************************
	 * 		 弹出层子页面组件
	 * **********************************/	

	/**
	 * 关闭弹出框
	 */
	function closeDialog(){
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭  
	}
	
	function waitLoading(){
		var width = $(document.body).width()/2-42;
		var height = $(document).scrollTop();
		console.log($(window).scrollTop());
		var loading = "<div class=\"loading mask opacity\"  style=\"height:"+height+"px;\"></div><div class=\"loading content\" style=\"left:"+width+"px;top:"+(height)+"px;\"></div>";
		$(document.body).append(loading);
	}
	
	function loadComplete(){
		//parent.layer.closeAll('loading');
	}
	
	/**
	 * 操作成功 关闭弹出框 并刷新父页面数据
	 */
	function closeSuccessDialog(info){
		parent.swal(info, "", "success");
		reloadparentpage();
		closeDialog();
	}
	
	/**
	 * 操作成功 关闭弹出框 并刷新父页面数据
	 */
	function closeSuccessDialogNoReload(info){ 
		parent.swal(info, "", "success");
		closeDialog();
	}
	
	/**
	 * 刷新父页面列表
	 */
	function reloadparentpage(){
		var miframe = parent.document.getElementsByTagName("iframe")[0]; //得到iframe页的窗口对象
			miframe.contentWindow.reloadData(); //执行iframe页的方法
	}