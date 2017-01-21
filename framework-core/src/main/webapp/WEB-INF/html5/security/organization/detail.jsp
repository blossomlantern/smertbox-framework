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
					<h5>机构详情</h5>
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
												<p class="form-control-static form-control-table-p">
													${vobj.orgName}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">父级机构</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.orgPname}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构描述</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.orgDesc}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在国家</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.country=='cn'}">中国</c:if>
			                                    		<c:if test="${vobj.country=='us'}">美国</c:if>
			                                    		<c:if test="${vobj.country=='ru'}">俄罗斯</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在省/州</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.province=='shanghai'}">上海</c:if>
			                                    		<c:if test="${vobj.province=='yunnan'}">云南</c:if>
			                                    		<c:if test="${vobj.province=='beijing'}">北京</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在城市</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.city=='shanghai'}">上海</c:if>
			                                    		<c:if test="${vobj.city=='kunming'}">昆明</c:if>
			                                    		<c:if test="${vobj.city=='beijing'}">北京</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">所在区/县</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.district=='yangpu'}">杨浦区</c:if>
			                                    		<c:if test="${vobj.district=='pudong'}">浦东新区</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">详细地址（区县以下部分）</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.addr}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">传真</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.fax}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">邮编</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.postcode}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">外线电话</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.outerTel}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">内线电话</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.innerTel}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">主负责人</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.charge}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">副负责人</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
													${vobj.assistant}
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构类型</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.orgType=='government'}">政府机构</c:if>
			                                    		<c:if test="${vobj.orgType=='institutions'}">事业单位</c:if>
			                                    		<c:if test="${vobj.orgType=='enterprise'}">企业单位</c:if>
			                                    		<c:if test="${vobj.orgType=='individual'}">个体单位</c:if>
			                                    		<c:if test="${vobj.orgType=='other'}">其它机构</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构级别</label>
											</td>
											<td>
												<p class="form-control-static form-control-table-p">
			                                    		<c:if test="${vobj.orgLevel=='organization'}">机构</c:if>
			                                    		<c:if test="${vobj.orgLevel=='department'}">部门</c:if>
			                                    		<c:if test="${vobj.orgLevel=='sub-deparment'}">子部门</c:if>
			                                    		<c:if test="${vobj.orgLevel=='team'}">团队</c:if>
			                                    		<c:if test="${vobj.orgLevel=='sub-team'}">子团队</c:if>
												</p>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">机构图标</label>
											</td>
											<td>
												<div id="img-show" style="width:200px;height:200px;margin-bottom:5px;">
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
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否允许编辑</label>
											</td>
											<td>
												<c:choose>
			                                    	<c:when test="${vobj.allowEdit==1}">
			                                    		<p class="form-control-static form-control-table-p">允许编辑</p>
			                                    	</c:when>
			                                    	<c:when test="${vobj.allowEdit==0}">
			                                    		<p class="form-control-static form-control-table-p">不允许编辑 </p>
			                                    	</c:when>
			                                    </c:choose>
											</td>
										</tr>
										<tr>
											<td class="dt-align-right">
												<label class="control-label">是否允许删除</label>
											</td>
											<td>
												<c:choose>
			                                    	<c:when test="${vobj.allowDel==1}">
			                                    		<p class="form-control-static form-control-table-p">允许删除</p>
			                                    	</c:when>
			                                    	<c:when test="${vobj.allowDel==0}">
			                                    		<p class="form-control-static form-control-table-p">不允许删除 </p>
			                                    	</c:when>
			                                    </c:choose>
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
