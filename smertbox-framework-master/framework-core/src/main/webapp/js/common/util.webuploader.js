	/**
	 * util.webuploader.js (v1.0)
	 * http://www.smertbox.com
	 * mailto:smertbox@126.com
	 * Copyright (c) 2016 SmertBox LaDeng
	 */

	/************************************
	 * 		 webuploader上传组件
	 * **********************************/	

	/**
	 *target : 将webuploader初始化在该对象
	 *callbackid : 将服务器返回的附件地址返回到该对象
	 *type : 文件类型 有两类 一类为图片 type=image; 第二类为其它任意类型文件 type!=image即可
	 *suffix : 文件后缀类型过滤 ，指定相应类型的文件后缀即可过滤文件类型 example:jpg,gif,png
	 */
	function callWebuploader(target,callbackid,type,suffix){
		//$("#"+target).after("<div id=\"upload-info\" style=\"padding-top:4px;\"></div>");
		/*var widget = "<div class=\"widget lazur-bg text-center\">"+
	                    "<div class=\"m-b-md\">"+
	                        "<i class=\"fa fa-cloud-upload fa-4x\"></i>"+
	                        "<h3 class=\"m-xs\">等待上传</h3>"+
	                        "<h3 class=\"font-bold no-margins\">"+
	                        "</h3>"+
	                        "<small>&nbsp;</small>"+
	                    "</div>"+
	              "</div>";*/
		//$("#upload-info").before("<div id=\"img-show\" style=\"width:200px;height:200px;\">"+widget+"</div>");
		//$("#upload-info").after("<div id=\"progress\" style=\"padding-top:2px;\"></div>");
		var upload_info = $("#upload-info");
		var uploader;
		var uuid = Math.uuid();
		var _csrf = $("meta[name='_csrf']").attr("content");
		var _csrf_header = $("meta[name='_csrf_header']").attr("content");
		var label = type=="image"?"点击选择图片":"点击选择文件";
		uploader = WebUploader.create({
			auto:false,
			pick:{
				id:'#'+target,
				label:label,
				multiple:false
			},
			swf: server + '/js/plugins/webuploader/Uploader.swf',
			server: server + "/api/attachment/upload?_csrf="+_csrf+"&_csrf_header="+_csrf_header,
			duplicate:true,
			resize:false,
			formData:{
				"uuid":uuid
			},
			accept:{
		        title: "Other",
		        extensions: suffix,
		        mimeTypes: '*'
		      },
			compress:null,
			chunked:true,
			chunkSize:5*1024*1024,
			chunkRetry:false,
			threads:1,
			disabledGlobalDnd:true
		});  
		
		uploader.on("fileQueued",function(file){
			//$("#picker").css("display","none");
		});
		
		uploader.on("uploadFinished",function(){
			//alert("上传完成!");
			//upload_info.html("<span style=\"font-color:#23c6c8;font-weight:bold;\">上传成功!</span>");
		});
		
		uploader.on("uploadAccept",function(object,ret){
			var data = null;
			if(ret._raw){
				data = JSON.parse(ret._raw);
			}else{
				data = JSON.parse(ret);
			}
			if(data.resultCode=='1'){
				$("#progress").css("display","none");
				var dialog = "<div id=\"blueimp-gallery\" class=\"blueimp-gallery\">"+
			                 "<div class=\"slides\"></div>"+
			                 "<h3 class=\"title\"></h3>"+
			                 "<a class=\"prev\">‹</a>"+
			                 "<a class=\"next\">›</a>"+
			                 "<a class=\"close\">×</a>"+
			                 "<a class=\"play-pause\"></a>"+
			                 "<ol class=\"indicator\"></ol>"+
			            	 "</div>";
				var append = null;
				if(type=="image"){
					append = "<div class=\"lightBoxGallery\">"+
					  "<a href=\""+server+data.uri+"&v=" + Math.floor(Math.random()*10) + "\" title=\""+object.file.name+"\" data-gallery=\"\">"+
					  "<img style=\"width:200px;height:200px;\" src=\""+server+data.uri+"&v=" + Math.floor(Math.random()*10) + "\"></a>"+dialog+
					  "</div>";
				}else{
					append = "<div class=\"widget lazur-bg text-center\">"+
				                    "<div class=\"m-b-md\">"+
				                        "<i class=\"fa fa-check fa-4x\"></i>"+
				                        "<h3 class=\"m-xs\">上传完成</h3>"+
				                        "<h3 class=\"font-bold no-margins\">"+
				                        "</h3>"+
				                        "<div style=\"word-wrap:break-word;word-break:break-all;\"><small>"+object.file.name+"</small></div>"+
				                    "</div>"+
				              "</div>";
				}
				$("#img-show").html(append);
				$("#"+callbackid).val(data.uri);
				// 重置上传队列
				uploader.reset();
			}else if(data.resultCode=='2'){
				console.log("上传中...");
			}else{
				console.log("上传失败!");
				uploader.reset();
				$("#picker").css("display","");
				upload_info.html("<span style=\"font-color:red;font-weight:bold;\">上传失败!</span>");
				return false;
			}
		});
		
		uploader.on("uploadSuccess",function(file){
			//$("#"+file.id).find("p.state").text("已上传");
		});
		
		uploader.on("uploadError",function(file){
			upload_info.html("<span style=\"font-color:red;font-weight:bold;\">上传失败!</span>");
			uploader.cancelFile(file);
			uploader.removeFile(file,true);
			uploader.reset();
			$("#picker").css("display","");
		});
		
		/*$("#upload").on("click",function(){
			uploader.upload();
		});*/
		
		$("#picker").on("change",function(){
			// 先试图删除已上传的文件 如没有文件则忽略
			deleteFile(callbackid,uuid);
			uploader.upload();
		});
		
		uploader.on("uploadProgress",function(file,percentage){
			//console.log(percentage);
			var $li = $( '#progress'),
	        $percent = $li.find('.progress .progress-bar');

		    // 避免重复创建
		    if ( !$percent.length ) {
		        $percent = $('<div class="progress progress-striped active">' +
		          '<div class="progress-bar" role="progressbar" style="width: 0%" id="progressbar-percent">'+percentage * 100+'%</div></div>').appendTo( $li ).find('.progress-bar');
		    }
		    
		    $percent.css( 'width', percentage * 100 + '%' );
		    $("#progressbar-percent").html(parseInt(percentage * 100) + '%');
			
		});
		
	}
	
	/**
	 * 删除已上传的文件
	 */
	function deleteFile(callbackid,uuid){
		if($("#"+callbackid).val()!=""){
			$.ajax({
				url: server + '/api/attachment/delete',
				type:'post',
				data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content"),"attachmentId" : uuid},
				async:false,
				success:function(data){
					if(data=='1'){
						console.log("文件删除成功!");
					}
				},
				error:function(e){
					console.log(e);
				}
			});
		}
	}
	
	function acceptType(type,other){
		var img = {
			        title: 'Images',
			        extensions: 'gif,jpg,jpeg,bmp,png',
			        mimeTypes: 'image/*'
			      };
		var word = {
		        title: 'Word',
		        extensions: 'doc,docx',
		        mimeTypes: '*'
		      };
		
		var excel = {
		        title: 'Excel',
		        extensions: 'xls,xlsx',
		        mimeTypes: '*'
		      };
		
		var pdf = {
		        title: 'Pdf',
		        extensions: 'pdf',
		        mimeTypes: 'application/pdf'
		      };
		
		var all = {
		        title: 'All',
		        extensions: '*',
		        mimeTypes: '*'
		      };
		
		var others = {
		        title: "Other",
		        extensions: other,
		        mimeTypes: '*'
		      };
		
		if(type=="img"){
			return img;
		}else if(type=="word"){
			return word;
		}else if(type=="excel"){
			return excel;
		}else if(type=="pdf"){
			return pdf;
		}else if(type=="all"){
			return all;
		}else if(type=="other"){
			return others;
		}
	}