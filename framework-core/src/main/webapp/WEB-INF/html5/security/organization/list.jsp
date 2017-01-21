﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title>${AppCNName} | 机构</title>

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
					<h5>机构管理</h5>
					<div class="ibox-tools">
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover data-table" ></table>
					</div>
				</div>
			</div>
		</div>
   </div>
</div>

<div class="animated">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>机构树</h5>
					<div class="ibox-tools">
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">
					<ul id="orgTree" class="ztree"></ul>
				</div>
			</div>
		</div>
   </div>
</div>

<div id="condition-content" class="condition-content" style="display:none;">
	<div class="form-group"><span>机构名称</span><input type="text" id="orgName" name="orgName"  placeholder="" class="form-control"></div>
	&nbsp;&nbsp;&nbsp;&nbsp;
    <div class="form-group"><span>创建时间</span><input type="text" id="beginCtTime" name="beginCtTime" onclick="laydate({istime: true,festival: true, format: 'YYYY-MM-DD hh:mm:ss'})" placeholder="" class="form-control"></div>
    <span>—</span>
    <div class="form-group"><input type="text" id="endCtTime" name="endCtTime" onclick="laydate({istime: true,festival: true, format: 'YYYY-MM-DD hh:mm:ss'})" placeholder="" class="form-control"></div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <div class="form-group"><button class="btn btn-sm btn-primary" type="button" onclick="reloadData();">查询</button></div>
    <security:authorize url="/security/organization/add"><div class="form-group"><button class="btn btn-sm btn-primary" type="button" onclick="add();">添加</button></div></security:authorize>
    <security:authorize url="/security/organization/delete"><div class="form-group"><button class="btn btn-sm btn-danger" type="button" onclick="dels();">删除</button></div></security:authorize>
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
	// 引入flash工具
	$.fn.dataTable.Buttons.swfPath = "<c:url value='/js/plugins/dataTables/extensions/Buttons/swf/flashExport.swf'/>";
	
	$(document).ready(function() {
		
		var table = $('.data-table').DataTable( {
			//buttons: ['copyHtml5','excelHtml5','csvHtml5','pdfHtml5','print'],
		    //"buttons": ['copy','csv','excel','pdf','print'],
		    buttons: [
		        {"extend": 'copy',"text": '复制',"charset": "utf-8"},
		        {"extend": 'csvHtml5',"text": 'CSV',"charset": "utf-8"},
		        {"extend": 'excel',"text": 'Excel',"charset": "utf-8"},
		        {"extend": 'pdf',
		         "text": 'PDF',
			     "customize": function (win){
	                    
		          			  }
	        	},
		        {"extend": 'print',
		         "text": '打印'
		        }
		    ],
		    "bSort": true,// 是否排序
	        "processing": true,
	        "searching":false,//是否打开搜索
	        "serverSide": true,
	        "aLengthMenu":[ 20, 50, 100 ],
	        "ajax":{
	        	"url":"${pageContext.request.contextPath}/security/organization/list",
	            "type":"post",
	            "data":function(data){
	            	data.column=5;
	            	data._csrf="${_csrf.token}";
	            	data._csrf_header="${_csrf.headerName}";
	            	
	            	// 填充实体类 用于后台查询使用
	            	data.orgName = $("#orgName").val();
	            	data.beginCtTime = $("#beginCtTime").val();
	            	data.endCtTime = $("#endCtTime").val();
	            }
	        },
	        // 当行建立时执行
	        "createdRow": function ( row, data, index ) {
	        	//	$('td', row).attr("class","text-center");
            },
	        "columns": [
				{ "title":"<input id=\"checkboxAll\" name=\"checkboxAll\" type=\"checkbox\" value=\"\">",
				  "data":"orgId",
				  "width":"5%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  // full为单个对象的完整json数据
                      var content = "<input type='checkbox' name='checkbox' id='checkbox' value=\""+data+"\" >";
                      if(full.allowDel==0){
                    	  content = "<input type='checkbox' name='checkbox' id='checkbox' value=\"\" >";
                      }
                      return content;
                  }
				},
				{ "title":"序号",
				  "width":"5%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
                      return "";
                  }
				},
	            { "title":"机构名称","data": "orgName","sClass":"dt-body-center" },
	            { "title":"机构描述","data": "orgDesc","sClass":"dt-body-center" },
	            { "title":"机构类型","data": "orgType","sClass":"dt-body-center",
            	  "mRender":function(data,type,full) {
					  var content = "";
					  if(data == "government"){
						  content = "政府机构";
					  }else if(data == "institutions"){
						  content = "事业单位";
					  }else if(data == "enterprise"){
						  content = "企业单位";
					  }else if(data == "individual"){
						  content = "个体单位";
					  }else if(data == "other"){
						  content = "其它机构";
					  }
                      return content;
                  }
	            },
	            { "title":"创建时间","data": "ctTime","width":"10%","sClass":"dt-body-center" },
	            { "title":"职位",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"assignationPosition('"+data+"');\"><i class=\"fa fa-user\"></i> 分配</button>";
                      return content;
                  }
				},
	            { "title":"角色",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"assignationRole('"+data+"');\"><i class=\"fa fa-gear\"></i> 分配</button>";
                      return content;
                  }
				},
				{ "title":"角色组",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"assignationRolegroup('"+data+"');\"><i class=\"fa fa-gears\"></i> 分配</button>";
                      return content;
                  }
				},
	            { "title":"详情",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-info \" type=\"button\" onclick=\"detail('"+data+"');\"><i class=\"fa fa-info-circle\"></i> 详细</button>";
                      return content;
                  }
				},
	            { "title":"编辑",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"edit('"+data+"');\"><i class=\"fa fa-paste\"></i> 编辑</button>";
					  if(full.allowEdit==0){
						  content = "<button class=\"btn btn-sm-sm btn-default \" type=\"button\" ><i class=\"fa fa-lock\"></i> 锁定</button>";
					  }
                      return content;
                  }
				},
	            { "title":"删除",
				  "data":"orgId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-danger \" type=\"button\" onclick=\"del('"+data+"');\"><i class=\"fa fa-trash\"></i> 删除</button>";
					  if(full.allowDel==0){
						  content = "<button class=\"btn btn-sm-sm btn-default \" type=\"button\" ><i class=\"fa fa-lock\"></i> 锁定</button>";
					  }
                      return content;
                  }
				}
	        ],
	        // 指定列不参与排序
	        "aoColumnDefs": [ 
                { "bSortable": false, "aTargets": [ 0 ] },
                { "bSortable": false, "aTargets": [ 1 ] },
                { "bSortable": false, "aTargets": [ 6 ] ,"visible": <security:ifelse url="/security/organization/assignationPosition" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 7 ] ,"visible": <security:ifelse url="/security/organization/assignationRole" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 8 ] ,"visible": <security:ifelse url="/security/organization/assignationRolegroup" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 9 ] ,"visible": <security:ifelse url="/security/organization/detail" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 10 ] ,"visible": <security:ifelse url="/security/organization/edit" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 11 ] ,"visible": <security:ifelse url="/security/organization/delete" ifValue="true" elseValue="false"/>}
	        ],
	        // 默认指定列排序
	        "aaSorting": [[ 2, "asc" ]]
	    } );
		
		//table.buttons().container().appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
		
	   // 当表格重绘时触发以下动作 包括初次绘制表格
	   $('.data-table').on( 'draw.dt', function () {
	   
	   		// 添加行号
	    	table.column(1, {search: 'applied',order: 'applied'}).nodes().each(function(cell, i) {
	            cell.innerHTML = i + 1;
	        });
	   		
	   		// checkbox全部选中时触发
	    	$("input[name='checkbox']").bind("click",function(){
	    		$("#checkboxAll").prop("checked",$("input[name='checkbox']:checked").size()==$("input[name='checkbox']").size() ? true : false);
	    	});
	    	
	   		// checkbox全选或者全不选
	    	$("#checkboxAll").bind("click",function(){
	    		$("input[name='checkbox']").prop("checked",$(this).prop("checked"));
	    	});
	    } ); 
	    
	   conditonInit(table);
	   zTree();
	});

	/**
	 * 重刷数据表 子页面需要调用此方法 此方法必须有且方法名固定为此名
	 */
	function reloadData(){
		var table = $('.data-table').DataTable();
		table.ajax.reload();
	}
	
	/**
	 * 添加条件查询组件
	 */
	function conditonInit(table){
		$(".condition-div").html($("#condition-content").html());
	}
	
	/**
	 * 获取已选中的checkbox值 使用逗号分隔
	 */
	function getcheckboxValueArray(){
		var val = "";
		$("input[name='checkbox']:checked").each(function(index,object){
			if($(this).val()!=""){
				val += "," + $(this).val();
			}
		});
		
		return val.substring(1);
	}
	
	/**
	 * 批量删除
	 */
	function dels(){
		var ids = getcheckboxValueArray();
		if(ids == ""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要删除这些数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/security/organization/delete',
	        			type:'post',
	        			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content"),"id":ids},
	        			async:false,
	        			success:function(data){
	        				if(data=='1'){
	        					reloadData();
	        					parent.swal("已删除!", "你已经删除这些数据.", "success");
	        				}
	        			},
	        			error:function(e){
	        				console.log(e);
	        			}
	        		});
	            }
        	});
	}
	
	function assignationPosition(id){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['40%', '60%'],
			    content: '${pageContext.request.contextPath}/security/organization/assignationPosition?id='+id
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
	}
	
	function assignationRole(id){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['40%', '60%'],
			    content: '${pageContext.request.contextPath}/security/organization/assignationRole?id='+id
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
	}
	
	function assignationRolegroup(id){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['40%', '60%'],
			    content: '${pageContext.request.contextPath}/security/organization/assignationRolegroup?id='+id
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
	}
	
	/**
	 * 添加数据
	 */
	function add(){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '80%'],
			    content: '${pageContext.request.contextPath}/security/organization/add'
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
		    content: '${pageContext.request.contextPath}/security/resource/add'
		}); */
	}
	
	/**
	 * 详情数据
	 */
	function detail(id){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '80%'],
			    content: '${pageContext.request.contextPath}/security/organization/detail?id='+id
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
	}
	
	/**
	 * 修改数据
	 */
	function edit(id){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '80%'],
			    content: '${pageContext.request.contextPath}/security/organization/edit?id='+id
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
	function del(id){
		if(id==null&&id==""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要删除这条数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/security/organization/delete',
	        			type:'post',
	        			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content"),"id":id},
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
	
	/**
	 * 添加树
	 */
	function zTree(){
		var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: true
            }
        };
		
		var zNodes = null;
		$.ajax({
			url:'${pageContext.request.contextPath}/security/organization/orgTree',
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data!='-1'){
					zNodes = $.parseJSON(data);
					$.fn.zTree.init($("#orgTree"), setting, zNodes);
					var zTree = $.fn.zTree.getZTreeObj("orgTree");
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
	
	
	var newCount = 1;
	/**
	 * 添加树节点
	 */
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("resourceTree");
            zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
            return false;
        });
    };
    
    /**
     * 移除树节点
     */
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
    };
	
	</script>
	
</body>

</html>
