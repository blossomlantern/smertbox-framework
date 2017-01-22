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

    <title>${AppCNName} | 用户</title>

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
					<h5>用户添加</h5>
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
												<label class="control-label">用户姓名</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="用户姓名" class="form-control" id="username" name="username">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">登录帐号</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="登录帐号" class="form-control" id="loginAccount" name="loginAccount">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">用户部门</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="用户部门" class="form-control" id="orgTree" onclick="showMenu(this);" readonly>
                                     				<input type="hidden" id="orgSid" name="orgSid">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">性别</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" checked value="1"  id="sex" name="sex"> <i></i> 男 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="sex" name="sex"> <i></i> 女  
			                                        </div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">登录密码</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="password" placeholder="登录密码" class="form-control" id="passwd" name="passwd" value="123456">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">电话</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="电话" class="form-control" id="tel" name="tel">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">邮箱</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="邮箱" class="form-control" id="email" name="email">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">出生日期</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="出生日期" class="form-control" id="birthday" name="birthday" onclick="laydate({istime: true,festival: true, format: 'YYYY-MM-DD'})">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">密码找回问题</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="密码找回问题" class="form-control" id="question" name="question">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">密码找回问题答案</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="密码找回问题答案" class="form-control" id="queAnswer" name="queAnswer">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">用户头像</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="hidden" id="photo" name="photo">
												    <div id="picker"></div>
												    <div id="img-show" style="width:200px;height:200px;">
												    	<div class="widget lazur-bg text-center">
										                    <div class="m-b-md">
										                        <i class="fa fa-cloud-upload fa-4x"></i>
										                        <h3 class="m-xs">等待上传</h3>
										                        <h3 class="font-bold no-margins">
										                        </h3>
										                        <small>&nbsp;</small>
										                    </div>
										                </div>
												    </div>
												    <div id="upload-info" style="padding-top:4px;"></div>
												    <div id="progress" style="padding-top:2px;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否管理</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" checked value="1"  id="ismanage" name="ismanage"> <i></i> 管理 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="ismanage" name="ismanage"> <i></i> 不管理
			                                        </div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否启用职位</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" checked value="1"  id="enablePosition" name="enablePosition"> <i></i> 启用职位 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="enablePosition" name="enablePosition"> <i></i> 不启用职位  
			                                        </div>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">角色启用类型</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<div class="i-checks" style="padding-top:3px;">
				                                        <input type="radio" checked value="0"  id="roleEnableType" name="roleEnableType"> <i></i> 启用用户角色 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="1"  id="roleEnableType" name="roleEnableType"> <i></i> 启用职位角色 
				                                        <input type="radio" value="2"  id="roleEnableType" name="roleEnableType"> <i></i> 全部启用（职位和角色一起启用） 
			                                        </div>
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
				                                        <input type="radio" checked value="1"  id="allowEdit" name="allowEdit"> <i></i> 允许编辑 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="allowEdit" name="allowEdit"> <i></i> 不允许编辑  
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
		
		// 添加表单验证
		$('#form').bootstrapValidator({
		      message: '输入的值不正确',
		      feedbackIcons: {
		          valid: 'glyphicon glyphicon-ok',
		          invalid: 'glyphicon glyphicon-remove',
		          validating: 'glyphicon glyphicon-refresh'
		      },
		      fields: {
		    	   username: {
		    	  		validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 100
	   	                     },
		                    callback: {
		 						message: '该用户姓名已存在',
		 						callback: function (value, validator) {
		 							var result = true;
		 							if (value!='') {
	 									$.ajax({
	 										url: server + '/security/user/isExist',
	 										type: 'post',
	 										async: false,
	 										data: {"max":"0","username": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
		            loginAccount: {
		                validators: {
		                	notEmpty: {},
		                    stringLength: {
	  	                        min: 4,
	   	                        max: 100
	   	                     },
	   	                  	callback: {
		 						message: '该用户账号已存在',
		 						callback: function (value, validator) {
		 							var result = true;
		 							if (value!='') {
	 									$.ajax({
	 										url: server + '/security/user/isExist',
	 										type: 'post',
	 										async: false,
	 										data: {"max":"0","loginAccount": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
		            passwd: {
		                validators: {
		                	notEmpty: {}
		                }
		            },
		            tel: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 20
	   	                     }
		                }
		            },
		            email: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            birthday: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 10
	   	                     }
		                }
		            },
		            question: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 200
	   	                     }
		                }
		            },
		            queAnswer: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            note: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 60
	   	                     }
		                }
		            }
		      }
		  });
		
		// 添加radio样式控件
		$('.i-checks').iCheck({
            radioClass: 'iradio_square-green',
        });
		
		// 添加下拉单选控件
		zTreeMultiCheck("orgSid","orgTree","/security/user/orgTree");
		// 添加上传控件
		callWebuploader("picker","photo","image","gif,jpg,jpeg,bmp,png");//image,"gif,jpg,jpeg,bmp,png"
		
	});
	
	/**
	 * 表单提交  ps:此处使用ajax提交
	 */
	function submitForm(){
		$("#form").data('bootstrapValidator').validate();//验证表单
		if($("#orgTree").val() == ""){
			swal("抱歉", "用户部门必须选择!", "error");
			return;
		}
		if($("#form").data('bootstrapValidator').isValid()){
			$.ajax({
				url: server+'/security/user/add',
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
