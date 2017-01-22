	/**
	 * util.ztree.js (v1.0)
	 * http://www.smertbox.com
	 * mailto:smertbox@126.com
	 * Copyright (c) 2016 SmertBox LaDeng
	 */

	/************************************
	 * 		 zTree组件
	 * **********************************/

	/**
	 * 多选树 
	 * @param _key 将选择的key存到_key
	 * @param _value 将选择的value存到_value
	 * @param url 数据请求地址 
	 */
	function zTreeMultiCheck(_key,_value,url){
		//key = _key;
		//value = _value;
		
		var mc = "<div id=\"menuContent_"+_value+"\" class=\"menuContent\" style=\"display:none; position: absolute;background:#ffffff;border:1px solid #1ab394;\">" +
				 "<ul id=\"selectTree_"+_value+"\" class=\"ztree\" style=\"width:400px;overflow-x:auto;height:360px;\"></ul>" +
				 "</div>";
		
		$("body").append(mc);
		
		var setting = {
				view: {
	                selectedMulti: false
	            },
	            check: {
	                enable: true,
	                chkboxType: { "Y": "s", "N": "" }
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            },
	            edit: {
	                enable: false
	            },
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value);
					zTree.checkNode(treeNode, !treeNode.checked, null, true);
					return false;
				},
				onCheck: function onCheck(e, treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value),
					nodes = zTree.getCheckedNodes(true),
					v = "";
					k = "";
					for (var i=0, l=nodes.length; i<l; i++) {
						v += nodes[i].name + ",";
						k += nodes[i].id + ",";
					}
					if (v.length > 0 ) v = v.substring(0, v.length-1);
					if (k.length > 0 ) k = k.substring(0, k.length-1);
					var valueObj = $("#"+_value);
					var keyObj = $("#"+_key);
					valueObj.attr("value", v);
					keyObj.attr("value", k);
				}
			}
		};
		
		var zNodes = null;
		$.ajax({
			url:server+url,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#selectTree_"+_value), setting, zNodes);
				}else{
					console.log("后台数据为空!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}

	//var key = null;
	//var value = null;
	
	/**
	 * 单选树 
	 * @param _key 将选择的key存到_key
	 * @param _value 将选择的value存到_value
	 * @param url 数据请求地址 
	 */
	function zTreeSingleCheck(_key,_value,url){
		//key = _key;
		//value = _value;
		
		var mc = "<div id=\"menuContent_"+_value+"\" class=\"menuContent\" style=\"display:none; position: absolute;background:#ffffff;border:1px solid #1ab394;\">" +
				 "<ul id=\"selectTree_"+_value+"\" class=\"ztree\" style=\"width:400px;overflow-x:auto;height:360px;\"></ul>" +
				 "</div>";
		
		$("body").append(mc);
		
		var setting = {
			check: {
				enable: true,
				chkStyle:"radio",
				//chkboxType: {"Y":"", "N":""}
				radioType: "all"
			},
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value);
					zTree.checkNode(treeNode, !treeNode.checked, null, true);
					return false;
				},
				onCheck: function onCheck(e, treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value),
					nodes = zTree.getCheckedNodes(true),
					v = "";
					k = "";
					for (var i=0, l=nodes.length; i<l; i++) {
						v += nodes[i].name + ",";
						k += nodes[i].id + ",";
					}
					if (v.length > 0 ) v = v.substring(0, v.length-1);
					if (k.length > 0 ) k = k.substring(0, k.length-1);
					var valueObj = $("#"+_value);
					var keyObj = $("#"+_key);
					valueObj.attr("value", v);
					keyObj.attr("value", k);
				}
			}
		};
		
		var zNodes = null;
		$.ajax({
			url:server+url,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#selectTree_"+_value), setting, zNodes);
				}else{
					console.log("后台数据为空!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	/**
	 * 单选树 并且初始化默认值
	 * @param _key 将选择的key存到_key
	 * @param _value 将选择的value存到_value
	 * @param url 数据请求地址
	 * @param default_value 默认值
	 */
	function zTreeSingleCheck(_key,_value,url,default_value){
		//key = _key;
		//value = _value;
		
		var mc = "<div id=\"menuContent_"+_value+"\" class=\"menuContent\" style=\"display:none; position: absolute;background:#ffffff;border:1px solid #1ab394;\">" +
				 "<ul id=\"selectTree_"+_value+"\" class=\"ztree\" style=\"width:400px;overflow-x:auto;height:360px;\"></ul>" +
				 "</div>";
		
		$("body").append(mc);
		
		var setting = {
			check: {
				enable: true,
				chkStyle:"radio",
				//chkboxType: {"Y":"", "N":""}
				radioType: "all"
			},
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value);
					zTree.checkNode(treeNode, !treeNode.checked, null, true);
					return false;
				},
				onCheck: function onCheck(e, treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value),
					nodes = zTree.getCheckedNodes(true),
					v = "";
					k = "";
					for (var i=0, l=nodes.length; i<l; i++) {
						v += nodes[i].name + ",";
						k += nodes[i].id + ",";
					}
					if (v.length > 0 ) v = v.substring(0, v.length-1);
					if (k.length > 0 ) k = k.substring(0, k.length-1);
					var valueObj = $("#"+_value);
					var keyObj = $("#"+_key);
					valueObj.attr("value", v);
					keyObj.attr("value", k);
				}
			}
		};
		
		var zNodes = null;
		$.ajax({
			url:server+url,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#selectTree_"+_value), setting, zNodes);

					var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value);
					var nodes = zTree.getCheckedNodes(false);
					for (var i = 0; i < nodes.length;i++) {
						if(nodes[i].id == default_value){
							zTree.checkNode(nodes[i], true);
							break;
						}
					}
				}else{
					console.log("后台数据为空!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	/*function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("selectTree");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}*/
	
	/*function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("selectTree"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		k = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			k += nodes[i].id + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (k.length > 0 ) k = k.substring(0, k.length-1);
		var valueObj = $("#"+value);
		var keyObj = $("#"+key);
		valueObj.attr("value", v);
		keyObj.attr("value", k);
	}*/

	function showMenu(target) {
		var _value = $(target).attr("id");
		var cityObj = $("#"+_value);
		var cityOffset = $("#"+_value).offset();
		$("#menuContent_"+_value).css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", function(event){
			if (!(event.target.id == "menuBtn" || event.target.id == _value || event.target.id == ("menuContent_"+_value) || $(event.target).parents("#menuContent_"+_value).length>0)) {
				hideMenu(_value);
			}
		});
		// 展开全部树节点
		var zTree = $.fn.zTree.getZTreeObj("selectTree_"+_value);
		if(zTree != null || zTree != undefined){
			zTree.expandAll(true);
		}
	}
	
	function hideMenu(_value) {
		$("#menuContent_"+_value).fadeOut("fast");
		$("body").unbind("mousedown", function(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == _value || event.target.id == ("menuContent_"+_value) || $(event.target).parents("#menuContent_"+_value).length>0)) {
				hideMenu(_value);
			}
		});
	}
	
	/*function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == value || event.target.id == "menuContent_" || $(event.target).parents("#menuContent_").length>0)) {
			hideMenu();
		}
	}*/
	
