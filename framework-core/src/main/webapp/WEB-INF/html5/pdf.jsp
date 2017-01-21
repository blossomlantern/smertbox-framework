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

<title>风暴智盒 | PDF预览</title>

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
						<div class="ibox-content" id="ibox-content" style="width:80%;height:80%;">
							<iframe src="${pageContext.request.contextPath}/pdf/pdf.pdf" style="width:80%;height:80%;"></iframe>
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
	
	<script src="<c:url value='/js/plugins/PDFObject/pdfobject2.js'/>" charset="utf-8"></script>

	<script>
		$(function() {
			 //var pdf = new PDFObject({ url: "${pageContext.request.contextPath}/pdf/pdf.pdf" }).embed("ibox-content");
		});
	</script>

</body>

</html>
