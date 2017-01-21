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

    <title>${AppCNName} | 机构</title>

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
					<h5>机构添加</h5>
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
												<label class="control-label">机构名称</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="机构名称" class="form-control" id="orgName" name="orgName">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">父级机构</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="父级资源" class="form-control" id="orgTree" onclick="showMenu(this);" readonly>
                                     				<input type="hidden" id="orgPid" name="orgPid">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构描述</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="机构描述" class="form-control" id="orgDesc" name="orgDesc"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在国家</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control" id="country" name="country">
			                                    		<option value="cn">中国</option>
			                                    		<option value="us">美国</option>
			                                    		<option value="ru">俄罗斯</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在省/州</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control" id="province" name="province">
			                                    		<option value="shanghai">上海</option>
			                                    		<option value="yunnan">云南</option>
			                                    		<option value="beijing">北京</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在城市</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control" id="city" name="city">
			                                    		<option value="shanghai">上海</option>
			                                    		<option value="kunming">昆明</option>
			                                    		<option value="beijing">北京</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在区/县</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control" id="district" name="district">
			                                    		<option value="yangpu">杨浦区</option>
			                                    		<option value="pudong">浦东新区</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">详细地址（区县以下部分）</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="详细地址（区县以下部分）" class="form-control" id="addr" name="addr"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">传真</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="传真" class="form-control" id="fax" name="fax"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">邮编</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="邮编" class="form-control" id="postcode" name="postcode"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">外线电话</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="外线电话" class="form-control" id="outerTel" name="outerTel"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">内线电话</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="内线电话" class="form-control" id="innerTel" name="innerTel"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">主负责人</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="主负责人" class="form-control" id="charge" name="charge"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">副负责人</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="副负责人" class="form-control" id="assistant" name="assistant"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构类型</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control"id="orgType" name="orgType">
			                                    		<option value="government">政府机构</option>
			                                    		<option value="institutions">事业单位</option>
			                                    		<option value="enterprise">企业单位</option>
			                                    		<option value="individual">个体单位</option>
			                                    		<option value="other">其它机构</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构级别</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<select class="form-control"id="orgLevel" name="orgLevel">
			                                    		<option value="organization">机构</option>
			                                    		<option value="department">部门</option>
			                                    		<option value="sub-deparment">子部门</option>
			                                    		<option value="team">团队</option>
			                                    		<option value="sub-team">子团队</option>
			                                    	</select>
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构图标</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="hidden" id="orgLogo" name="orgLogo">
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
		    	   orgName: {
		    	  		validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 100
	   	                     },
		                    callback: {
		 						message: '该机构已存在',
		 						callback: function (value, validator) {
		 							var result = true;
		 							if (value!='') {
	 									$.ajax({
	 										url: server + '/security/organization/isExist',
	 										type: 'post',
	 										async: false,
	 										data: {"max":"0","orgName": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
		            orgDesc: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            addr: {
		                validators: {
		                    stringLength: {
	  	                        min: 5,
	   	                        max: 200
	   	                     }
		                }
		            },
		            fax: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 50
	   	                     }
		                }
		            },
		            postcode: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 20
	   	                     }
		                }
		            },
		            innerTel: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 20
	   	                     }
		                }
		            },
		            outerTel: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 20
	   	                     }
		                }
		            },
		            charge: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            assistant: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 60
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
		zTreeSingleCheck("orgPid","orgTree","/security/organization/orgTree");
		// 添加上传控件
		callWebuploader("picker","orgLogo","image","gif,jpg,jpeg,bmp,png");//image,"gif,jpg,jpeg,bmp,png"
		
	});
	
	/**
	 * 表单提交  ps:此处使用ajax提交
	 */
	function submitForm(){
		$("#form").data('bootstrapValidator').validate();//验证表单
		
		if($("#form").data('bootstrapValidator').isValid()){
			$.ajax({
				url: server+'/security/organization/add',
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
