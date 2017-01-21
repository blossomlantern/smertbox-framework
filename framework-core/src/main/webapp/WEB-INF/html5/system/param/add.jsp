<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>${AppCNName} | 添加参数</title>

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
					<h5>添加参数</h5>
					<div class="ibox-tools">
						<a href="javascript:void(0);" onclick="closeDialog();" class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
					</div>
				</div>
				<div class="ibox-content">
					<form id="form" method="post" class="form-horizontal">
								<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
								<input type="hidden" id="_csrf_header" name="_csrf_header" value="${_csrf.headerName}">
                                <div class="table-responsive table-top-border-none">
									<table class="table table-bordered">
	                               		<tr>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数Id</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数Id" class="form-control" id="parId" name="parId" readonly value="">
												</div>
											</td>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数父Id</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数父Id" class="form-control" id="parPid" name="parPid" readonly value="${vobj.parPid}">
												</div>
											</td>
										</tr>
										<tr>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数Key</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数Key" class="form-control" id="parKey" name="parKey" value="${vobj.parKey}">
												</div>
											</td>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数Value</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数Value" class="form-control" id="parValue" name="parValue" value="${vobj.parValue}">
												</div>
											</td>
										</tr>
										<tr>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数组</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数组" class="form-control" id="groupId" name="groupId" value="${vobj.groupId}">
												</div>
											</td>
											<td style="width:20%;text-align:center;">
												<label class="control-label">排序编号</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="排序编号" class="form-control" id="sortCode" name="sortCode" value="${vobj.sortCode}">
												</div>
											</td>
										</tr>
										<tr>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数类型</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数类型" class="form-control" id="parType" name="parType" value="${vobj.parType}">
												</div>
											</td>
											<td style="width:20%;text-align:center;">
												<label class="control-label">参数层级</label>
											</td>
											<td style="width:30%;">
												<div class="form-group form-group-table">
													<input type="text" placeholder="参数层级" class="form-control" id="parLevel" name="parLevel" readonly value="${vobj.parLevel}">
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="4">
												<div align="center">
													<button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>
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
		
		// 添加表单验证
		$('#form').bootstrapValidator({
		      message: '输入的值不正确',
		      feedbackIcons: {
		          valid: 'glyphicon glyphicon-ok',
		          invalid: 'glyphicon glyphicon-remove',
		          validating: 'glyphicon glyphicon-refresh'
		      },
		      fields: {
		    	   parValue: {
		                validators: {
		                	notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 200
	   	                     }
		                }
		            },
		            parKey: {
		    	  		validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 100
	   	                     },
	   	                  	callback: {
		 						message: '该Key值已存在',
		 						callback: function (value, validator) {
		 							var result = true;
		 							$("#parKey").val(value);
		 							if (value!='') {
	 									$.ajax({
	 										url: server + '/system/param/parKeyIsExist',
	 										type: 'post',
	 										async: false,
	 										data: {"max":"0","parKey": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
	 										success: function (data) {
	 											if (data == '1') {
	 												result = false;
	 											}else{
	 												result = true;
	 											}
	 										}
	 									});
	 								}
		 							return result;
		 						}
		 					}
		                }
		            },
		            sortCode: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 50
	   	                     },
		            		regexp: {
       	                         regexp: /^[0-9]+$/,
       	                         message: '请输入数字'
       	                     }
		                }
		            }
		      }
		  });
	});
	
	/**
	 * 表单提交  ps:此处使用ajax提交
	 */
	function submitForm(){
		$("#form").data('bootstrapValidator').validate();//验证表单
		if($("#form").data('bootstrapValidator').isValid()){
			$.ajax({
				url: server+'/system/param/add',
				type:'post',
				data:$("#form").serialize(),
				async:false,
				success:function(data){
					if(data=='1'){
						closeSuccessDialog("添加成功!");
					}else{
						console.log("添加失败!");
					}
				},
				error:function(e){
					console.log(e);
				}
			});
		}
	}
	
	</script>
</body>

</html>
