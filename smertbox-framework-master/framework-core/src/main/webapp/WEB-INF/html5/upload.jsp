<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<title>风暴智盒 | 文件上传</title>

<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/font-awesome/css/font-awesome.css'/>"
	rel="stylesheet">
<link href="<c:url value='/css/animate.css" rel="stylesheet'/>">
<link href="<c:url value='/css/plugins/dropzone/basic.css'/>"
	rel="stylesheet">
<link href="<c:url value='/css/plugins/dropzone/dropzone.css'/>"
	rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<link href="<c:url value='/js/plugins/webuploader/webuploader.css'/>"
	rel="stylesheet">

</head>

<body>

	<div class="gray-bg">
		<div class="row wrapper white-bg page-heading">
			<div class="col-lg-10">
				<h2>File upload</h2>
				<ol class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li><a>Forms</a></li>
					<li class="active"><strong>File upload</strong></li>
				</ol>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="wrapper wrapper-content animated fadeIn">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Dropzone Area</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> <a class="dropdown-toggle" data-toggle="dropdown" href="#">
									<i class="fa fa-wrench"></i>
								</a>
								<ul class="dropdown-menu dropdown-user">
									<li><a href="#">Config option 1</a></li>
									<li><a href="#">Config option 2</a></li>
								</ul>
								<a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<!-- <div id="uploader" class="wu-example">
						    <div id="thelist" class="uploader-list"></div>
						    <div class="btns">
						        <div id="picker">选择文件</div>
						        
						        <button id="ctlBtn" class="btn btn-default">开始上传</button>
						    </div>
						</div> -->
							<div id="uploader" class="wu-example">
								<!--用来存放文件信息-->
								<div id="thelist" class="uploader-list"></div>
								<div class="btns">
									<div id="attach"></div>
									<input type="button" value="上传" id="upload" />
								</div>
							</div>
							<div id="uploader1" class="wu-example">
								<!--用来存放文件信息-->
								<div id="thelist1" class="uploader-list"></div>
								<div class="btns">
									<div id="multi"></div>
									<input type="button" value="上传" id="multiUpload" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Mainly scripts -->
	<script src="<c:url value='/js/jquery-2.1.1.js'/>" charset="utf-8"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>" charset="utf-8"></script>
	<script
		src="<c:url value='/js/plugins/metisMenu/jquery.metisMenu.js'/>"
		charset="utf-8"></script>
	<script
		src="<c:url value='/js/plugins/slimscroll/jquery.slimscroll.min.js'/>"
		charset="utf-8"></script>

	<!-- Custom and plugin javascript -->
	<script src="<c:url value='/js/inspinia.js'/>" charset="utf-8"></script>
	<script src="<c:url value='/js/plugins/pace/pace.min.js'/>"
		charset="utf-8"></script>

	<!-- DROPZONE -->
	<script src="<c:url value='/js/plugins/dropzone/dropzone.js'/>"
		charset="utf-8"></script>
	<script src="<c:url value='/js/plugins/webuploader/webuploader.js'/>" charset="utf-8"></script>

	<script>
		$(function() {
			var $list = $("#thelist");
			var uploader;// 实例化 
			uploader = WebUploader.create({
				auto : false, //是否自动上传
				pick : {
					id : '#attach',
					label : '点击选择图片',
					multiple : false
				},
				swf : "<c:url value='/js/plugins/webuploader/Uploader.swf'/>",
				server : "${pageContext.request.contextPath}/uploader/upload?_csrf=${_csrf.token}&_csrf_header=${_csrf.headerName}&uuid=${uuid}",
				duplicate : true,//是否可重复选择同一文件
				resize : false,
				compress : null,//图片不压缩
				chunked : true, //分片处理
				chunkSize : 5 * 1024 * 1024, //每片5M 
				chunkRetry : false,//如果失败，则不重试
				threads : 1,//上传并发数。允许同时最大上传进程数。
				disableGlobalDnd : true
			});
			// 当有文件添加进来的时候
			uploader.on("fileQueued", function(file) {
				console.log("fileQueued:");
				$list.append("<div id='"+ file.id + "' class='item'>"
						+ "<h4 class='info'>" + file.name + "</h4>"
						+ "<p class='state'>等待上传...</p>" + "</div>");
			});
			//当所有文件上传结束时触发
			uploader.on("uploadFinished", function() {
				console.log("uploadFinished:");
			})
			//当某个文件上传到服务端响应后，会派送此事件来询问服务端响应是否有效。
			uploader.on("uploadAccept", function(object, data) {
				//var data = JSON.parse(data);
				if (data != "1" && data != "3") {
					if (data == "9") {
						uploader.reset();
						alert("error");
						return false;
					}
				} else {
					//E05017
					uploader.reset();
					alert("error");
					return false;
				}
			})
			//当文件上传成功时触发。
			uploader.on("uploadSuccess", function(file) {
				$("#" + file.id).find("p.state").text("已上传");
			});
			uploader.on("uploadError", function(file) {
				$("#" + file.id).find("p.state").text("上传出错");
				uploader.cancelFile(file);
				uploader.removeFile(file, true);
				uploader.reset();
			});
			$("#upload").on("click", function() {
				uploader.upload();
			})
		});
		
	</script>

</body>

</html>
