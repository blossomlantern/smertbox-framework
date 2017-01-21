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
					<h5>机构修改</h5>
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
								<input type="hidden" id="orgId" name="orgId" value="${vobj.orgId}">
								<div class="table-responsive table-top-border-none">
									<table class="table table-bordered">
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构名称</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="机构名称" class="form-control" id="orgName" name="orgName" value="${vobj.orgName}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">父级机构</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="父级资源" class="form-control" id="orgTree" onclick="showMenu(this);" readonly value="${vobj.orgPname}">
                                     				<input type="hidden" id="orgPid" name="orgPid" value="${vobj.orgPid}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构描述</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="机构描述" class="form-control" id="orgDesc" name="orgDesc" value="${vobj.orgDesc}"> 
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
			                                    		<option value="cn" <c:if test="${vobj.country=='cn'}">selected</c:if> >中国</option>
			                                    		<option value="us" <c:if test="${vobj.country=='us'}">selected</c:if> >美国</option>
			                                    		<option value="ru" <c:if test="${vobj.country=='ru'}">selected</c:if> >俄罗斯</option>
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
			                                    		<option value="shanghai" <c:if test="${vobj.province=='shanghai'}">selected</c:if> >上海</option>
			                                    		<option value="yunnan" <c:if test="${vobj.province=='yunnan'}">selected</c:if> >云南</option>
			                                    		<option value="beijing" <c:if test="${vobj.province=='beijing'}">selected</c:if> >北京</option>
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
			                                    		<option value="shanghai" <c:if test="${vobj.city=='shanghai'}">selected</c:if> >上海</option>
			                                    		<option value="kunming" <c:if test="${vobj.city=='kunming'}">selected</c:if> >昆明</option>
			                                    		<option value="beijing" <c:if test="${vobj.city=='beijing'}">selected</c:if> >北京</option>
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
			                                    		<option value="yangpu" <c:if test="${vobj.district=='yangpu'}">selected</c:if> >杨浦区</option>
			                                    		<option value="pudong" <c:if test="${vobj.district=='pudong'}">selected</c:if> >浦东新区</option>
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
													<input type="text" placeholder="详细地址（区县以下部分）" class="form-control" id="addr" name="addr" value="${vobj.addr}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">传真</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="传真" class="form-control" id="fax" name="fax" value="${vobj.fax}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">邮编</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="邮编" class="form-control" id="postcode" name="postcode" value="${vobj.postcode}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">外线电话</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="外线电话" class="form-control" id="outerTel" name="outerTel" value="${vobj.outerTel}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">内线电话</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="内线电话" class="form-control" id="innerTel" name="innerTel" value="${vobj.innerTel}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">主负责人</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="主负责人" class="form-control" id="charge" name="charge" value="${vobj.charge}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">副负责人</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="副负责人" class="form-control" id="assistant" name="assistant" value="${vobj.assistant}"> 
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
			                                    		<option value="government" <c:if test="${vobj.orgType=='government'}">selected</c:if> >政府机构</option>
			                                    		<option value="institutions" <c:if test="${vobj.orgType=='institutions'}">selected</c:if> >事业单位</option>
			                                    		<option value="enterprise" <c:if test="${vobj.orgType=='enterprise'}">selected</c:if> >企业单位</option>
			                                    		<option value="individual" <c:if test="${vobj.orgType=='individual'}">selected</c:if> >个体单位</option>
			                                    		<option value="other" <c:if test="${vobj.orgType=='other'}">selected</c:if> >其它机构</option>
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
			                                    		<option value="organization" <c:if test="${vobj.orgLevel=='organization'}">selected</c:if> >机构</option>
			                                    		<option value="department" <c:if test="${vobj.orgLevel=='department'}">selected</c:if> >部门</option>
			                                    		<option value="sub-deparment" <c:if test="${vobj.orgLevel=='sub-deparment'}">selected</c:if> >子部门</option>
			                                    		<option value="team" <c:if test="${vobj.orgLevel=='team'}">selected</c:if> >团队</option>
			                                    		<option value="sub-team" <c:if test="${vobj.orgLevel=='sub-team'}">selected</c:if> >子团队</option>
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
													<input type="hidden" id="orgLogo" name="orgLogo" value="${vobj.orgLogo}">
												    <div id="picker"></div>
												    <div id="img-show" style="width:200px;height:200px;">
												    	<c:choose>
												    		<c:when test="${vobj.orgLogo != null && vobj.orgLogo != '' }">
												    			<div class="lightBoxGallery">
																  <a href="${pageContext.request.contextPath}${vobj.orgLogo}" title="" data-gallery="">
																  <img style="width:200px;height:200px;" src="${pageContext.request.contextPath}${vobj.orgLogo}"></a>
																  <div id="blueimp-gallery" class="blueimp-gallery">
													                 <div class="slides"></div>
													                 <h3 class="title"></h3>
													                 <a class="prev">‹</a>
													                 <a class="next">›</a>
													                 <a class="close">×</a>
													                 <a class="play-pause"></a>
													                 <ol class="indicator"></ol>
												            	  </div>
																</div>
												    		</c:when>
												    		<c:otherwise>
													    		<div class="widget lazur-bg text-center">
											                        <div class="m-b-md">
											                            <i class="fa fa-warning fa-4x"></i>
											                            <h2 class="m-xs">抱歉</h2>
											                            <h3 class="font-bold no-margins">
											                            </h3>
											                            <small>没有图片</small>
											                        </div>
											                    </div>
												    		</c:otherwise>
												    	</c:choose>
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
				                                        <input type="radio" value="1"  id="allowEdit" name="allowEdit" <c:if test="${vobj.allowEdit==1}">checked</c:if> > <i></i> 允许编辑 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="allowEdit" name="allowEdit" <c:if test="${vobj.allowEdit==0}">checked</c:if> > <i></i> 不允许编辑  
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
				                                        <input type="radio" value="1"  id="allowDel" name="allowDel" <c:if test="${vobj.allowDel==1}">checked</c:if> > <i></i> 允许删除 &nbsp; &nbsp; &nbsp; &nbsp;
				                                        <input type="radio" value="0"  id="allowDel" name="allowDel" <c:if test="${vobj.allowDel==0}">checked</c:if> > <i></i> 不允许删除  
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
													<input type="text" placeholder="备注" class="form-control" id="note" name="note" value="${vobj.note}">
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
	 										data: {"max":"1","orgName": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
		zTreeSingleCheck("orgPid","orgTree","/security/organization/orgTree","${vobj.orgPid}");
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
				url: server+'/security/organization/edit',
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
