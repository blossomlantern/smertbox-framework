<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>${AppCNName} | 附件详情</title>

    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/font-awesome/css/font-awesome.css'/>" rel="stylesheet">

    <link href="<c:url value='/css/plugins/iCheck/custom.css'/>" rel="stylesheet">
    <link href="<c:url value='/js/plugins/zTree/css/metroStyle/metroStyle.css'/>" rel="stylesheet">
    <link href="<c:url value='/js/plugins/webuploader/webuploader.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/plugins/blueimp/css/blueimp-gallery.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/js/plugins/bootstrapValidator/css/bootstrapValidator.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/plugins/sweetalert/sweetalert.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/animate.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	<style>
		
	</style>
</head>

<body class="gray-bg">
<div class="animated">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>附件详情</h5>
					<div class="ibox-tools">
						<a href="javascript:void(0);" onclick="closeDialog();" class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
					</div>
				</div>
				<div class="ibox-content">
					<form id="form" method="post" class="form-horizontal">
								<div class="table-responsive table-top-border-none">
									<table class="table table-bordered">
										<tr>
											<td class="dt-align-right">
												<label class="control-label">原文件名称</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.originalName}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件名称</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.name}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件描述</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.description}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件类型</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.type}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件前缀</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.prefix}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件后缀</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.suffix}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件物理地址</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.physicalAddr}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件相对位置</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.relativeAddr}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件访问地址</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													<a href="${pageContext.request.contextPath}/api/attachment/download?attachmentId=${vobj.attachmentId}" target="_blank">下载</a>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件上传人</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.ctUserName}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">附件上传时间</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													<fmt:formatDate value="${vobj.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">备注</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.note}
												</p>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div align="center">
                                        			<button class="btn btn-white" type="button" onclick="closeDialog();">取消</button>
			                                    </div>
		                                    </td>
										</tr>
									</table>
								</div>
                    </form>
				</div>
			</div>
		</div>
   </div>
</div>
    <!-- Mainly scripts -->
    <script src="<c:url value='/js/jquery-2.1.1.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/bootstrap.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/bootstrapValidator/js/bootstrapValidator.min.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/bootstrapValidator/js/language/zh_CN.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/metisMenu/jquery.metisMenu.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/slimscroll/jquery.slimscroll.min.js'/>" charset="utf-8"></script>
    
    <script src="<c:url value='/js/plugins/pace/pace.min.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/iCheck/icheck.min.js'/>"></script>
    <script src="<c:url value='/js/plugins/layer/layer.js'/>"></script>
    <script src="<c:url value='/js/plugins/laydate/laydate.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.core.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.excheck.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.exedit.js'/>"></script>
    <script src="<c:url value='/js/plugins/webuploader/webuploader.min.js'/>"></script>
    <script src="<c:url value='/js/plugins/blueimp/jquery.blueimp-gallery.min.js'/>"></script>
    <script src="<c:url value='/js/common/util.date.js'/>" charset="utf-8"></script>
	<script src="<c:url value='/js/common/util.guid.js'/>"></script>
	<script src="<c:url value='/js/common/util.webuploader.js'/>"></script>
	<script src="<c:url value='/js/common/util.subpage.js'/>"></script>
	<script src="<c:url value='/js/common/util.ztree.js'/>"></script>
	<script src="<c:url value='/js/plugins/sweetalert/sweetalert.min.js'/>"></script>
	
	<script type="text/javascript">
	
	// 获取项目路径 此变量必须有 子页面使用的是相对路径 需要将项目路径拼入才能保证100%能访问到
	var server = "${pageContext.request.contextPath}";
	
	$(document).ready(function() {
		
	});
	
	</script>
</body>

</html>
