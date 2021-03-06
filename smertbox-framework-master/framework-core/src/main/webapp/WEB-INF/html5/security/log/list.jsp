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

    <title>${AppCNName} | 附件管理</title>

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
					<h5>附件管理</h5>
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

<div id="condition-content" class="condition-content" style="display:none;">
	<div class="row" style="margin:0;padding-top:0;">
		<div class="form-group"><span>原文件名</span><input type="text" id="originalName" name="originalName"  placeholder="" class="form-control"></div>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="form-group"><span>后缀名称</span><input type="text" id="suffix" name="suffix"  placeholder="" class="form-control"></div>
	</div>
	<div class="row" style="margin:0;margin-top:5px;">
	    <div class="form-group"><span>创建时间</span><input type="text" id="beginCtTime" name="beginCtTime" onclick="laydate({istime: true,festival: true, format: 'YYYY-MM-DD hh:mm:ss'})" placeholder="" class="form-control"></div>
	    <span>—</span>
	    <div class="form-group"><input type="text" id="endCtTime" name="endCtTime" onclick="laydate({istime: true,festival: true, format: 'YYYY-MM-DD hh:mm:ss'})" placeholder="" class="form-control"></div>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <div class="form-group"><button class="btn btn-sm btn-primary" type="button" onclick="reloadData();">查询</button></div>
	    <security:authorize url="/api/attachment/delete"><div class="form-group"><button class="btn btn-sm btn-danger" type="button" onclick="dels();">逻辑删除</button></div></security:authorize>
	    <security:authorize url="/api/attachment/deleteByPhysical"><div class="form-group"><button class="btn btn-sm btn-danger" type="button" onclick="delPhys();">物理删除</button></div></security:authorize>
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
	        	"url":"${pageContext.request.contextPath}/api/attachment/list",
	            "type":"post",
	            "data":function(data){
	            	data.column=5;
	            	data._csrf="${_csrf.token}";
	            	data._csrf_header="${_csrf.headerName}";
	            	
	            	// 填充实体类 用于后台查询使用
	            	data.originalName = $("#originalName").val();
	            	data.suffix = $("#suffix").val();
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
				  "data":"attachmentId",
				  "width":"5%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  // full为单个对象的完整json数据
                      var content = "<input type='checkbox' name='checkbox' id='checkbox' value=\""+data+"\" >";
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
	            { "title":"文件名","data": "name","sClass":"dt-body-center" },
	            { "title":"原文件名","data": "originalName","sClass":"dt-body-center" },
	            { "title":"后缀","data": "suffix","sClass":"dt-body-center" },
	            { "title":"相对地址","data": "relativeAddr" },
	            { "title":"逻辑状态",
				  "data":"del",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "已删除";
					  if(data==0){
						  content = "正常";
					  }
                      return content;
                  }
				},
	            { "title":"物理状态",
				  "data":"physicalState",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "不存在";
					  if(data==1){
						  content = "正常";
					  }
                      return content;
                  }
				},
	            { "title":"上传时间","data": "createTime","sClass":"dt-body-center" },
	            { "title":"详情",
				  "data":"attachmentId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-info \" type=\"button\" onclick=\"detail('"+data+"');\"><i class=\"fa fa-info-circle\"></i> 详细</button>";
                      return content;
                  }
				},
				{ "title":"逻辑",
				  "data":"attachmentId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-danger \" type=\"button\" onclick=\"del('"+data+"');\"><i class=\"fa fa-trash\"></i> 删除</button>";
                      return content;
                  }
				},
	            { "title":"物理",
				  "data":"attachmentId",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var content = "<button class=\"btn btn-sm-sm btn-danger \" type=\"button\" onclick=\"delPhy('"+data+"');\"><i class=\"fa fa-trash\"></i> 删除</button>";
                      return content;
                  }
				}
	        ],
	        // 指定列不参与排序
	        "aoColumnDefs": [ 
                { "bSortable": false, "aTargets": [ 0 ] },
                { "bSortable": false, "aTargets": [ 1 ] },
                { "bSortable": false, "aTargets": [ 2 ] ,"visible":false},
                { "bSortable": false, "aTargets": [ 7 ] },
                { "bSortable": false, "aTargets": [ 9 ] ,"visible": <security:ifelse url="/api/attachment/detail" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 10 ] ,"visible": <security:ifelse url="/api/attachment/delete" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 11 ] ,"visible": <security:ifelse url="/api/attachment/deleteByPhysical" ifValue="true" elseValue="false"/>}
	        ],
	        // 默认指定列排序
	        "aaSorting": [[ 8, "desc" ]]
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
			    area: ['50%', '65%'],
			    content: '${pageContext.request.contextPath}/api/attachment/detail?id='+id
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
	}
	
	/**
	 * 批量逻辑删除
	 */
	function dels(){
		var ids = getcheckboxValueArray();
		if(ids == ""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要逻辑删除这些数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/api/attachment/delete',
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
	
	/**
	 * 批量物理删除
	 */
	function delPhys(){
		var ids = getcheckboxValueArray();
		if(ids == ""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要物理删除这些数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/api/attachment/deleteByPhysical',
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
	
	/**
	 * 逻辑删除数据
	 */
	function del(id){
		if(id==null&&id==""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要逻辑删除这条数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/api/attachment/delete',
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
	 * 物理删除数据
	 */
	function delPhy(id){
		if(id==null&&id==""){
			return;
		}
		parent.swal({title: "你确定要删除吗?",
            text: "你将要物理删除这条数据!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确认删除",
            cancelButtonText: "取消删除",
            closeOnConfirm: false },
	        function (isConfirm) {
	            if (isConfirm) {
	            	$.ajax({
	        			url:'${pageContext.request.contextPath}/api/attachment/deleteByPhysical',
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
	
	</script>
	
</body>

</html>
