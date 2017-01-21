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

    <title>${AppCNName} | 资源</title>

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
					<h5>资源修改</h5>
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
								<input type="hidden" id="resId" name="resId" value="${vobj.resId}">
                                <div class="table-responsive table-top-border-none">
									<table class="table table-bordered">
										<tr>
											<td class="dt-align-right">
												<label class="control-label">资源名称</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="资源名称" class="form-control" id="resName" name="resName" value="${vobj.resName}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">父级资源</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													 <input type="text" placeholder="父级资源" class="form-control" id="selectValue" onclick="showMenu(this);" value="${vobj.resPidName}" readonly>
                                     				 <input type="hidden" id="resPid" name="resPid" value="${vobj.resPid}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">资源描述</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													 <input type="text" placeholder="资源描述" class="form-control" id="resDesc" name="resDesc" value="${vobj.resDesc}"> 
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">资源图标</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="hidden" id="resIcon" name="resIcon" value="${vobj.resIcon}">
												    <div id="picker"></div>
												    <div id="img-show" style="width:200px;height:200px;">
												    	<c:choose>
												    		<c:when test="${vobj.resIcon != null && vobj.resIcon != '' }">
												    			<div class="lightBoxGallery">
																  <a href="${pageContext.request.contextPath}${vobj.resIcon}" title="" data-gallery="">
																  <img style="width:200px;height:200px;" src="${pageContext.request.contextPath}${vobj.resIcon}"></a>
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
												<label class="control-label">资源访问地址</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="资源访问地址" class="form-control" id="resUrl" name="resUrl" value="${vobj.resUrl}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-center" colspan="2">
												<span style="color:red;">(注意！：如资源访问节点无URL请填写#加任意数字，以便区分节点。格式为：#X、#X-X，例如：#1、#1-1、#2-1-1)</span>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">资源类型</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="资源类型" class="form-control" id="resType" name="resType" value="${vobj.resType}">
												</div>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">资源目标</label>
											</td>
											<td>
												<div class="form-group form-group-table">
													<input type="text" placeholder="资源目标" class="form-control" id="resTarget" name="resTarget" value="${vobj.resTarget}">
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
												<label class="control-label">排序编号</label>
											</td>
											<td>
												<div class="form-group form-group-table">
				                                   	<input type="text" placeholder="排序编号" class="form-control" id="sort" name="sort" value="${vobj.sort}">
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
		    	  	resName: {
		    	  		validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 100
	   	                     }
		                }
		            },
		            resDesc: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 100
	   	                     }
		                }
		            },
		            resUrl: {
		                validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 200
	   	                    },
		   	                callback: {
		 						message: '该资源地址已存在',
		 						callback: function (value, validator) {
		 							var result = true;
		 							if (value!='') {
	 									$.ajax({
	 										url: server + '/security/resource/isExist',
	 										type: 'post',
	 										async: false,
	 										data: {"max":"1","resUrl": value,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
		            resType: {
		                validators: {
		                    notEmpty: {},
		                    stringLength: {
	  	                        min: 1,
	   	                        max: 50
	   	                     }
		                }
		            },
		            resTarget: {
		                validators: {
		                    stringLength: {
	  	                        min: 0,
	   	                        max: 50
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
		// 添加下拉单选控件
		zTreeSingleCheck("resPid","selectValue","/security/resource/resourceTree","${vobj.resPid}");
		// 添加上传控件
		callWebuploader("picker","resIcon","image","gif,jpg,jpeg,bmp,png");//image,"gif,jpg,jpeg,bmp,png"
	});
	
	/**
	 * 表单提交  ps:此处使用ajax提交
	 */
	function submitForm(){
		$("#form").data('bootstrapValidator').validate();//验证表单
		if($("#form").data('bootstrapValidator').isValid()){
			$.ajax({
				url: server+'/security/resource/edit',
				type:'post',
				data:$("#form").serialize(),
				async:false,
				success:function(data){
					if(data=='1'){
						closeSuccessDialog("修改成功!");
					}else{
						console.log("修改失败!");
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
