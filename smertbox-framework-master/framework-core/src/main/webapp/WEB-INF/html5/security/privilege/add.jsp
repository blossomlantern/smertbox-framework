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

    <title>${AppCNName} | 权限</title>

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
					<h5>权限添加</h5>
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
											<td class="dt-align-right">
												<label class="control-label">权限名称</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="权限名称" class="form-control" id="pvgName" name="pvgName">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">父级权限</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="父级权限" class="form-control" id="privilegeTree" onclick="showMenu(this);" readonly>
                                    				<input type="hidden" id="pvgPid" name="pvgPid">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">对应资源</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="对应资源" class="form-control" id="resourceTree" onclick="showMenu(this);" readonly>
                                    				<input type="hidden" id="resId" name="resId">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">权限描述</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="权限描述" class="form-control" id="pvgDesc" name="pvgDesc"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">权限类型</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control"id="pvgType" name="pvgType">
			                                    		<option value="url">请求地址</option>
			                                    		<option value="button">URL权限</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否允许编辑</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" value="1"  id="allowEdit" name="allowEdit"> <i></i> 允许编辑 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" checked value="0"  id="allowEdit" name="allowEdit"> <i></i> 不允许编辑  
			                                        </div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否允许删除</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" value="1"  id="allowDel" name="allowDel"> <i></i> 允许删除 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" checked value="0"  id="allowDel" name="allowDel"> <i></i> 不允许删除  
			                                        </div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">排序编号</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="排序编号" class="form-control" id="sort" name="sort">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">备注</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="备注" class="form-control" id="note" name="note">
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2">
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
<!-- <div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#ffffff;border:1px solid #1ab394;">
	<ul id="selectTree" class="ztree" style="width:400px;"></ul>
</div> -->
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
		    	  	pvgName: {
		    	  		validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 100
	   	                     }
		                }
		            },
		            pvgDesc: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            sort: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 50
	   	                     }
		                }
		            },
		            note: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            }
		      }
		  });
		
		// 添加radio样式控件
		$('.i-checks').iCheck({
            radioClass: 'iradio_square-green',
        });
		// 添加权限树下拉单选控件
		zTreeSingleCheck("pvgPid","privilegeTree","/security/privilege/privilegeTree");
		// 添加资源树下拉单选控件
		zTreeSingleCheck("resId","resourceTree","/security/resource/resourceTree");
		
	});
	
	/**
	 * 表单提交  ps:此处使用ajax提交
	 */
	function submitForm(){
		$("#form").data('bootstrapValidator').validate();//验证表单
		
		$.ajax({
			url: server + '/security/privilege/isExist',
			type: 'post',
			async: false,
			data: {"max":"0","resId": $("#resId").val(),'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			success: function (data) {
				if (data == '1') {
					swal("已存在", "该资源已经绑定过权限!", "warning");
				}else{
					if($("#form").data('bootstrapValidator').isValid()){
						$.ajax({
							url: server+'/security/privilege/add',
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
			}
		});
	}
	
	</script>
</body>

</html>
