<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://spring-security/tag/1.0" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>${AppCNName} | 参数管理</title>

    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/font-awesome/css/font-awesome.css'/>" rel="stylesheet">

    <link href="<c:url value='/js/plugins/dataTables/media/css/dataTables.bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/js/plugins/dataTables/extensions/Buttons/css/buttons.bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/plugins/sweetalert/sweetalert.css'/>" rel="stylesheet">
    <link href="<c:url value='/js/plugins/zTree/css/metroStyle/metroStyle.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/animate.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="animated">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>菜单树</h5>
					<div class="ibox-tools">
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="row ibox-content" style="margin:0;padding-top:0;">
					<div class="col-lg-3" style="padding:0;">
						<div class="ibox-content" style="max-height:700px;overflow-x:auto;border:0;">
							<ul id="paramTree" class="ztree"></ul>
						</div>
					</div>
					<div class="col-lg-8" style="padding:0;">
						<div class="ibox-content" style="border:0;margin:5px;padding:auto;height:300px;vertical-align: middle;" align="center">
							<div class="table-responsive table-top-border-none">
                               	<table class="table table-bordered">
                               		<tr>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数Id</label>
										</td>
										<td id="parId" style="width:30%;">
										</td>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数父Id</label>
										</td>
										<td id="parPid" style="width:30%;">
										</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数Key</label>
										</td>
										<td id="parKey" style="width:30%;">
										</td>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数Value</label>
										</td>
										<td id="parValue" style="width:30%;">
										</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数组</label>
										</td>
										<td id="groupId" style="width:30%;">
										</td>
										<td style="width:20%;text-align:center;">
											<label class="control-label">排序编号</label>
										</td>
										<td id="sortCode" style="width:30%;">
										</td>
									</tr>
									<tr>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数类型</label>
										</td>
										<td id="parType" style="width:30%;">
										</td>
										<td style="width:20%;text-align:center;">
											<label class="control-label">参数层级</label>
										</td>
										<td id="parLevel" style="width:30%;">
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
   </div>
</div>
    <!-- Mainly scripts -->
    <script src="<c:url value='/js/jquery-2.1.1.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/bootstrap.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/metisMenu/jquery.metisMenu.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/slimscroll/jquery.slimscroll.min.js'/>" charset="utf-8"></script>
<%--     <script src="<c:url value='/js/plugins/jeditable/jquery.jeditable.js'/>"></script> --%>
    
	<script src="<c:url value='/js/plugins/dataTables/media/js/jquery.dataTables.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/media/js/dataTables.bootstrap.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/extensions/Buttons/js/dataTables.buttons.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/extensions/Buttons/js/buttons.bootstrap.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/extensions/Buttons/js/buttons.flash.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/extensions/Buttons/js/buttons.html5.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/dataTables/extensions/Buttons/js/buttons.print.js'/>" charset="utf-8"></script>
	<script src="<c:url value='/js/plugins/jszip/dist/jszip.min.js'/>" charset="utf-8"></script>
    <%-- <script src="<c:url value='/js/plugins/pdfmake/pdfmake.min.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/pdfmake/vfs_fonts.js'/>" charset="utf-8"></script> --%>
	<script src="<c:url value='/js/inspinia.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/pace/pace.min.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/common/util.date.js'/>" charset="utf-8"></script>
    <script src="<c:url value='/js/plugins/layer/layer.js'/>"></script>
    <script src="<c:url value='/js/plugins/laydate/laydate.js'/>"></script>
    <script src="<c:url value='/js/plugins/sweetalert/sweetalert.min.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.core.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.excheck.js'/>"></script>
    <script src="<c:url value='/js/plugins/zTree/js/jquery.ztree.exedit.js'/>"></script>
	<script type="text/javascript">
	var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn
			},
			data: {
				key: {
					name:"parValue"
				},
				simpleData: {
					enable:true,
					idKey:"parId",
					pIdKey:"parPid",
					rootPId:'0'
				}
			},
			check: {
				enable:false,
				chkDisabledInherit:false,
				nocheckInherit:false
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick,
				beforeRemove: beforeRemove,
				beforeEditName: beforeEditName
			}
		};

	var zNodes = null;
	
	function loadzTreeData(){
		$.ajax({
			url:'${pageContext.request.contextPath}/system/param/paramTree',
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#paramTree"), setting, zNodes);
					var zTree = $.fn.zTree.getZTreeObj("paramTree");
					zTree.expandAll(true);
				}else{
					console.log("后台数据为空!");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	function beforeClick(treeId, treeNode, clickFlag) {
		
		return (treeNode.click != false);
	}
	function onClick(event, treeId, treeNode, clickFlag) {
		//console.log(treeNode);
		$("#parId").html(treeNode.parId);
		$("#parPid").html(treeNode.parPid);
		$("#parType").html(treeNode.parType);
		$("#parLevel").html(treeNode.parLevel);
		$("#parKey").html(treeNode.parKey);
		$("#parValue").html(treeNode.parValue);
		$("#groupId").html(treeNode.groupId);
		$("#sortCode").html(treeNode.sortCode);
	}	
	
	function beforeRemove(treeId, treeNode) {
		del(treeNode.parId);
		return false;
	}
	
	function beforeEditName(treeId, treeNode) {
		if(treeNode.level != 0 && (treeNode != undefined || treeNode != null) ){
			edit(treeNode.parId);
		}
		return false;
	}
	
	function showRemoveBtn(treeId, treeNode) {
		return treeNode.level!=0;
	}
	
	function showRenameBtn(treeId, treeNode) {
		return treeNode.level!=0;
	}

	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			add(treeNode);
			return false;
		});
	};
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	</script>
	<script type="text/javascript">
	
	$(document).ready(function() {
		loadzTreeData();
	});

	/**
	 * 添加数据
	 */
	function add(treeNode){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '50%'],
			    content: '${pageContext.request.contextPath}/system/param/add?parId=' + treeNode.parId + "&parLevel=" + (parseInt(treeNode.parLevel) + 1)
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
		
		/* layer.open({
		    type: 2,
		    title: false,
		    shadeClose: true,
		    shade: 0.5,
		    area: ['50%', '90%'],
		    content: '${pageContext.request.contextPath}/security/menu/add'
		}); */
	}
	
	/**
	 * 修改数据
	 */
	function edit(param){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '50%'],
			    content: '${pageContext.request.contextPath}/system/param/edit?parId='+param
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
		reloadData();
	}
	
	/**
	 * 删除数据
	 */
	function del(param){
		if(param==null&&param==""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要级联删除数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/system/param/deleteCascade?id='+param,
	        			type:'post',
	        			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
	        			async:false,
	        			success:function(data){
	        				if(data=='1'){
	        					reloadData();
	        					parent.swal("已删除!", "你已经删除这条数据.", "success");
	        				}
	        			},
	        			error:function(e){
	        				console.log(e);
	        			}
	        		});
	            }
        	});
	}
	
	function reloadData(){
		location.reload();
	}
	</script>
</body>
</html>
