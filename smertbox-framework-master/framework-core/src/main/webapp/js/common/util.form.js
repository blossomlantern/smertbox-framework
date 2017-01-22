	/**
	 * util.form.js (v1.0)
	 * http://www.smertbox.com
	 * mailto:smertbox@126.com
	 * Copyright (c) 2016 SmertBox LaDeng
	 */

	/************************************
	 * 			表单插件集合
	 * **********************************/

	/**
	 * 获取页面指定checkbox name的数据 并使用逗号分隔返回数据
	 * @param _name
	 * @returns
	 */
	function getcheckboxValueArray(_name){
		var val = "";
		$("input[name='"+_name+"']:checked").each(function(index,object){
			if($(this).val()!=""){
				val += "," + $(this).val();
			}
		});
		
		return val.substring(1);
	}
