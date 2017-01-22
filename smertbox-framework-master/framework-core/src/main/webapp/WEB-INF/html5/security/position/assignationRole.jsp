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

    <title>${AppCNName} | 角色组</title>

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
					<h5>分配角色</h5>
					<div class="ibox-tools">
						<a href="javascript:void(0);" onclick="closeDialog();" class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
					</div>
				</div>
				<div class="ibox-content">
					<div class="form-group">
						<table class="table checkbox-table">
						<tr>
						<c:forEach items="${alls}" var="element" varStatus="status">
							<c:if test="${status.index != 0 && status.index%3 == 0}"></tr><tr></c:if>
							<td><div class="checkbox-inline i-checks dialog-checkbox"><input id="${element.roleId}" name="role" type="checkbox" value="${element.roleId}"> <i></i> ${element.roleName} </div></td>
						</c:forEach>
						</tr>
						</table>
					</div>
					<div class="hr-line-dashed"></div>
	                <div class="form-group">
	                	<div align="center">
	                       	<button class="btn btn-primary" type="button" onclick="submitForm();">保存</button>
	                        <button class="btn btn-white" type="button" onclick="closeDialog();">取消</button>
	                    </div>
	                </div>
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
		 $('.i-checks').iCheck({
             checkboxClass: 'icheckbox_square-green',
             radioClass: 'iradio_square-green',
         });
		 
		 var roles = ${roles};
		 
		 var role = $("input[name='role']");
		 for(var i = 0;i < role.length;i++){
			 for(var j = 0;j < roles.length;j++){
				 if($(role[i]).val() == roles[j].roleId){
				 	$(role[i]).iCheck("check");
				 }
			 }
		 }
	});
	
	function getcheckboxValueArray(_name){
		var val = "";
		$("input[name='"+_name+"']:checked").each(function(index,object){
			if($(this).val()!=""){
				val += "," + $(this).val();
			}
		});
		
		return val.substring(1);
	}
	
	function submitForm(){
		var checkeds = getcheckboxValueArray("role");
		$.ajax({
			url: server+'/security/positionrole/save',
			type:'post',
			data:{positionId:"${positionId}",nodes:checkeds,'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data=='1'){
					closeSuccessDialog("分配成功!");
				}else{
					console.log("分配失败!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
		
	</script>
</body>

</html>
