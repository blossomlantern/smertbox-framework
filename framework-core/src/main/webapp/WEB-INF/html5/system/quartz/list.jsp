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

    <title>${AppCNName} | 定时任务</title>

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
					<h5>定时任务管理</h5>
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
	<div class="form-group"><span>Job名称</span><input type="text" id="jobName" name="jobName"  placeholder="" class="form-control"></div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <div class="form-group"><button class="btn btn-sm btn-primary" type="button" onclick="reloadData();">查询</button></div>
    <div class="form-group"><button class="btn btn-sm btn-primary" type="button" onclick="add();">添加</button></div>
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
	        	"url":"${pageContext.request.contextPath}/system/quartz/list",
	            "type":"post",
	            "data":function(data){
	            	data.column=5;
	            	data._csrf="${_csrf.token}";
	            	data._csrf_header="${_csrf.headerName}";
	            	
	            	// 填充实体类 用于后台查询使用
	            	data.jobName = $("#jobName").val();
	            }
	        },
	        // 当行建立时执行
	        "createdRow": function ( row, data, index ) {
	        	//	$('td', row).attr("class","text-center");
            },
	        "columns": [
				{ "title":"序号",
				  "width":"5%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
                      return "";
                  }
				},
	            { "title":"Job名称","data": "jobName","sClass":"dt-body-center" },
	            { "title":"Job状态","data": "state","sClass":"dt-body-center" },
	            { "title":"Job类名","data": "jobClassName","sClass":"dt-body-center" },
	            { "title":"触发器名称","data": "triggerName","sClass":"dt-body-center" },
	            { "title":"时间表达式","data": "cronExpression","sClass":"dt-body-center" },
	            { "title":"上一次执行","data": "lastTime","sClass":"dt-body-center" },
	            { "title":"下一次执行","data": "nextTime","sClass":"dt-body-center" },
	            { "title":"编辑",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"edit('"+param+"');\"><i class=\"fa fa-paste\"></i> 编辑</button>";
                      return content;
                  }
				},
	            { "title":"详情",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-info \" type=\"button\" onclick=\"detail('"+param+"');\"><i class=\"fa fa-info-circle\"></i> 详细</button>";
                      return content;
                  }
				},
				{ "title":"执行",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"execute('"+param+"');\"><i class=\"fa fa-paste\"></i> 执行</button>";
                      return content;
                  }
				},
				{ "title":"暂停",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"pause('"+param+"');\"><i class=\"fa fa-paste\"></i> 暂停</button>";
                      return content;
                  }
				},
				{ "title":"恢复",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-primary \" type=\"button\" onclick=\"resume('"+param+"');\"><i class=\"fa fa-paste\"></i> 恢复</button>";
                      return content;
                  }
				},
	            { "title":"删除",
				  "data":"jobName",
				  "width":"4%",
				  "sClass":"dt-body-center",
				  "mRender":function(data,type,full) {
					  var param = "jobName="+full.jobName+"&schedName="+full.schedName+"&jobGroup="+full.jobGroup;
					  var content = "<button class=\"btn btn-sm-sm btn-danger \" type=\"button\" onclick=\"del('"+param+"');\"><i class=\"fa fa-trash\"></i> 删除</button>";
                      return content;
                  }
				}
	        ],
	        // 指定列不参与排序
	        "aoColumnDefs": [ 
                { "bSortable": false, "aTargets": [ 0 ] },
                { "bSortable": false, "aTargets": [ 6 ] },
                { "bSortable": false, "aTargets": [ 7 ] },
                { "bSortable": false, "aTargets": [ 8 ] ,"visible": <security:ifelse url="/system/quartz/detail" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 9 ] ,"visible": <security:ifelse url="/system/quartz/edit" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 10 ] ,"visible": <security:ifelse url="/system/quartz/execute" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 11 ] ,"visible": <security:ifelse url="/system/quartz/pause" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 12 ] ,"visible": <security:ifelse url="/system/quartz/resume" ifValue="true" elseValue="false"/>},
                { "bSortable": false, "aTargets": [ 13 ] ,"visible": <security:ifelse url="/system/quartz/delete" ifValue="true" elseValue="false"/>}
	        ],
	        // 默认指定列排序
	        "aaSorting": [[ 1, "asc" ]]
	    } );
		
		//table.buttons().container().appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
		
	   // 当表格重绘时触发以下动作 包括初次绘制表格
	   $('.data-table').on( 'draw.dt', function () {
	   
	   		// 添加行号
	    	table.column(0, {search: 'applied',order: 'applied'}).nodes().each(function(cell, i) {
	            cell.innerHTML = i + 1;
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
			    area: ['50%', '50%'],
			    content: '${pageContext.request.contextPath}/system/quartz/add'
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
	 * 详情数据
	 */
	function detail(param){
		try{
			self.parent.layer.open({
			    type: 2,
			    shift:0,
			    closeBtn:0,
			    title: false,
			    shadeClose: true,
			    shade: 0.5,
			    area: ['50%', '80%'],
			    content: '${pageContext.request.contextPath}/system/quartz/detail?'+param
			});
			return;
		}catch(e){
			console.log("子页面单独运行."+e);
		}
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
			    area: ['50%', '30%'],
			    content: '${pageContext.request.contextPath}/system/quartz/edit?'+param
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
	        			url:'${pageContext.request.contextPath}/system/quartz/delete?'+param,
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
	
	/**
	 * 执行
	 */
	function execute(param){
		$.ajax({
			url: '${pageContext.request.contextPath}/system/quartz/execute?'+param,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data=='1'){
					parent.swal("执行成功!", "", "success");
					reloadData();
				}else{
					parent.swal("执行失败!", "", "error");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	/**
	 * 暂停
	 */
	function pause(param){
		$.ajax({
			url: '${pageContext.request.contextPath}/system/quartz/pause?'+param,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data=='1'){
					parent.swal("暂停成功!", "", "success");
					reloadData();
				}else{
					parent.swal("暂停失败!", "", "error");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	/**
	 * 恢复
	 */
	function resume(param){
		$.ajax({
			url: '${pageContext.request.contextPath}/system/quartz/resume?'+param,
			type:'post',
			data:{'_csrf':$("meta[name='_csrf']").attr("content"),'_csrf_header':$("meta[name='_csrf_header']").attr("content")},
			async:false,
			success:function(data){
				if(data=='1'){
					parent.swal("恢复成功!", "", "success");
					reloadData();
				}else{
					parent.swal("恢复失败!", "", "error");
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
