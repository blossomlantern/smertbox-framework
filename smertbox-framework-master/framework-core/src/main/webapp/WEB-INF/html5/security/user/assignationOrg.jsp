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

    <title>${AppCNName} | 分配机构</title>

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
					<h5>分配组织机构</h5>
					<div class="ibox-tools">
						<a href="javascript:void(0);" onclick="closeDialog();" class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
					</div>
				</div>
				<div class="ibox-content">
					<ul id="orgTree" class="ztree"></ul>
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
		zTree();
	});
	
	/**
	 * 添加资源树
	 */
	function zTree(){
		var setting = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true,
                chkboxType: { "Y": "s", "N": "" }
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            }
        };
		
		var zNodes = null;
		// 已有权限集合
		var orgs = ${orgs};
		// 角色id
		$.ajax({
			url:'${pageContext.request.contextPath}/security/user/orgTree',
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#orgTree"), setting, zNodes);
					var zTree = $.fn.zTree.getZTreeObj("orgTree");
					zTree.expandAll(true);
					var nodes = zTree.getCheckedNodes(false);
					for(var i = 0;i < nodes.length;i++){
						for(var j = 0;j < orgs.length;j++){
							if(nodes[i].id == orgs[j].orgId){
								zTree.checkNode(nodes[i], true);
							}
						}
					}
				}else{
					console.log("后台数据为空!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	function submitForm(){
		var zTree = $.fn.zTree.getZTreeObj("orgTree");
		var nodes = zTree.getCheckedNodes(true);
		var checkeds = "";
		for(var i = 0;i < nodes.length;i++){
			checkeds+=","+nodes[i].id;
		}
		
		$.ajax({
			url: server+'/security/userorg/save',
			type:'post',
			data:{userId:"${userId}",nodes:checkeds.substring(1),'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
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
