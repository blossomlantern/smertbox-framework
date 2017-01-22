<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>${AppCNName} | ${AppENName}</title>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/plugins/sweetalert/sweetalert.css'/>" rel="stylesheet">
    <link href="<c:url value='/font-awesome/css/font-awesome.css'/>" rel="stylesheet">

    <!-- Toastr style -->
    <link href="<c:url value='/css/plugins/toastr/toastr.min.css'/>" rel="stylesheet">

    <!-- Gritter -->
    <link href="<c:url value='/js/plugins/gritter/jquery.gritter.css'/>" rel="stylesheet">
    
    <link href="<c:url value='/css/animate.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/style.css'/>" rel="stylesheet">
    <link rel="icon" href="<c:url value='/favicon.ico'/>"> 

</head>

<body>
<!-- 整体 -->
<div id="wrapper">
    	<!-- 左侧菜单 -->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="${pageContext.request.contextPath}${user.photo}" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">你好，<sec:authentication property="principal.sysUser.username"/></strong>
                             </span> <span class="text-muted text-xs block">${position} <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="profile.html">个人中心</a></li>
                                <li><a href="contacts.html">代办事项</a></li>
                                <li><a href="mailbox.html">邮箱</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0);" onclick="logout();">注销</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            FH
                        </div>
                    </li>
                </ul>

            </div>
        </nav>
		
	<!-- 右侧实体 -->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!-- 头部信息 -->
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <form role="search" class="navbar-form-custom" action="search_results.html">
                <div class="form-group">
                    <input type="text" placeholder="输入搜索..." class="form-control" name="top-search" id="top-search">
                </div>
            </form>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">欢迎登陆风暴智盒！</span>
                    <span class="m-r-sm text-muted welcome-message" id="now-time"></span>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="../img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <small class="pull-right">46h ago</small>
                                    <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="../img/a4.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right text-navy">5h ago</small>
                                    <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="../img/profile.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right">23h ago</small>
                                    <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                    <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="mailbox.html">
                                    <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="mailbox.html">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="profile.html">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="grid_options.html">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="notifications.html">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="javascript:void(0);" onclick="logout();">
                        <i class="fa fa-sign-out"></i> 注销
                    </a>
                </li>
                <li>
                    <a class="right-sidebar-toggle">
                        <i class="fa fa-tasks"></i>
                    </a>
                </li>
            </ul>

        </nav>
        </div>
        
        <!-- 导航栏 -->
        <div class="row wrapper border-bottom white-bg page-heading">
             <div class="col-lg-10">
                 <!-- <h2>Static Tables</h2> -->
                 <ol class="breadcrumb">
                     <!-- <li>
                         <a href="index.html">主页</a>
                     </li>
                     <li>
                         <a>表格</a>
                     </li>
                     <li class="active">
                         <strong>权限表格</strong>
                     </li> -->
                 </ol>
             </div>
         </div>
         
        <!-- content -->
       	<div class="wrapper wrapper-content">
       	<!-- 16:9 aspect ratio -->
			<div id="iframe-div" class="embed-responsive embed-responsive-16by9">
			  <iframe id="rightpage" name="rightpage" class="embed-responsive-item" src=""></iframe>
			</div>
        </div>
        
        <!-- footer -->
        <div class="footer">
              <div class="" align="center">
                  <strong>Copyright 风暴智盒小组 &copy; 2016</strong>
              </div>
        </div>
        
        <!-- 弹窗聊天 -->
        <div class="small-chat-box fadeInRight animated">

            <div class="heading" draggable="true">
                <small class="chat-date pull-right">
                    02.19.2015
                </small>
                Small chat
            </div>

            <div class="content">

                <div class="left">
                    <div class="author-name">
                        Monica Jackson <small class="chat-date">
                        10:02 am
                    </small>
                    </div>
                    <div class="chat-message active">
                        Lorem Ipsum is simply dummy text input.
                    </div>

                </div>
                <div class="right">
                    <div class="author-name">
                        Mick Smith
                        <small class="chat-date">
                            11:24 am
                        </small>
                    </div>
                    <div class="chat-message">
                        Lorem Ipsum is simpl.
                    </div>
                </div>
                <div class="left">
                    <div class="author-name">
                        Alice Novak
                        <small class="chat-date">
                            08:45 pm
                        </small>
                    </div>
                    <div class="chat-message active">
                        Check this stock char.
                    </div>
                </div>
                <div class="right">
                    <div class="author-name">
                        Anna Lamson
                        <small class="chat-date">
                            11:24 am
                        </small>
                    </div>
                    <div class="chat-message">
                        The standard chunk of Lorem Ipsum
                    </div>
                </div>
                <div class="left">
                    <div class="author-name">
                        Mick Lane
                        <small class="chat-date">
                            08:45 pm
                        </small>
                    </div>
                    <div class="chat-message active">
                        I belive that. Lorem Ipsum is simply dummy text.
                    </div>
                </div>


            </div>
            <div class="form-chat">
                <div class="input-group input-group-sm"><input type="text" class="form-control"> <span class="input-group-btn"> <button
                        class="btn btn-primary" type="button">Send
                </button> </span></div>
            </div>

        </div>
        <div id="small-chat">

            <span class="badge badge-warning pull-right">5</span>
            <a class="open-small-chat">
                <i class="fa fa-comments"></i>

            </a>
        </div>
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active"><a data-toggle="tab" href="#tab-1">
                        Notes
                    </a></li>
                    <li><a data-toggle="tab" href="#tab-2">
                        Projects
                    </a></li>
                    <li class=""><a data-toggle="tab" href="#tab-3">
                        <i class="fa fa-gear"></i>
                    </a></li>
                </ul>

                <div class="tab-content">


                    <div id="tab-1" class="tab-pane active">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> Latest Notes</h3>
                            <small><i class="fa fa-tim"></i> You have 10 new message.</small>
                        </div>

                        <div>

                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a1.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">

                                        There are many variations of passages of Lorem Ipsum available.
                                        <br>
                                        <small class="text-muted">Today 4:21 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a2.jpg">
                                    </div>
                                    <div class="media-body">
                                        The point of using Lorem Ipsum is that it has a more-or-less normal.
                                        <br>
                                        <small class="text-muted">Yesterday 2:45 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        Mevolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                                        <br>
                                        <small class="text-muted">Yesterday 1:10 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a4.jpg">
                                    </div>

                                    <div class="media-body">
                                        Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the
                                        <br>
                                        <small class="text-muted">Monday 8:37 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a8.jpg">
                                    </div>
                                    <div class="media-body">

                                        All the Lorem Ipsum generators on the Internet tend to repeat.
                                        <br>
                                        <small class="text-muted">Today 4:21 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a7.jpg">
                                    </div>
                                    <div class="media-body">
                                        Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
                                        <br>
                                        <small class="text-muted">Yesterday 2:45 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        The standard chunk of Lorem Ipsum used since the 1500s is reproduced below.
                                        <br>
                                        <small class="text-muted">Yesterday 1:10 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="../img/a4.jpg">
                                    </div>
                                    <div class="media-body">
                                        Uncover many web sites still in their infancy. Various versions have.
                                        <br>
                                        <small class="text-muted">Monday 8:37 pm</small>
                                    </div>
                                </a>
                            </div>
                        </div>

                    </div>

                    <div id="tab-2" class="tab-pane">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-cube"></i> Latest projects</h3>
                            <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small>
                        </div>

                        <ul class="sidebar-list">
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Business valuation</h4>
                                    It is a long established fact that a reader will be distracted.

                                    <div class="small">Completion with: 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Contract with Company </h4>
                                    Many desktop publishing packages and web page editors.

                                    <div class="small">Completion with: 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Meeting</h4>
                                    By the readable content of a page when looking at its layout.

                                    <div class="small">Completion with: 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label label-primary pull-right">NEW</span>
                                    <h4>The generated</h4>
                                    <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
                                    There are many variations of passages of Lorem Ipsum available.
                                    <div class="small">Completion with: 22%</div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Business valuation</h4>
                                    It is a long established fact that a reader will be distracted.

                                    <div class="small">Completion with: 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Contract with Company </h4>
                                    Many desktop publishing packages and web page editors.

                                    <div class="small">Completion with: 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Meeting</h4>
                                    By the readable content of a page when looking at its layout.

                                    <div class="small">Completion with: 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label label-primary pull-right">NEW</span>
                                    <h4>The generated</h4>
                                    <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
                                    There are many variations of passages of Lorem Ipsum available.
                                    <div class="small">Completion with: 22%</div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>

                        </ul>

                    </div>

                    <div id="tab-3" class="tab-pane">

                        <div class="sidebar-title">
                            <h3><i class="fa fa-gears"></i> Settings</h3>
                            <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small>
                        </div>

                        <div class="setings-item">
                    <span>
                        Show notifications
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
                                    <label class="onoffswitch-label" for="example">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Disable Chat
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox" id="example2">
                                    <label class="onoffswitch-label" for="example2">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Enable history
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
                                    <label class="onoffswitch-label" for="example3">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Show charts
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
                                    <label class="onoffswitch-label" for="example4">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Offline users
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example5">
                                    <label class="onoffswitch-label" for="example5">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Global search
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example6">
                                    <label class="onoffswitch-label" for="example6">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                    <span>
                        Update everyday
                    </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
                                    <label class="onoffswitch-label" for="example7">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="sidebar-content">
                            <h4>Settings</h4>
                            <div class="small">
                                I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                                And typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                Over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
    <!-- Mainly scripts -->
    <script src="<c:url value='/js/jquery-2.1.1.js'/>"></script>
    <script src="<c:url value='/js/jquery.form.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.js'/>"></script>
    <script src="<c:url value='/js/plugins/metisMenu/metisMenu.min.js'/>"></script>
    <script src="<c:url value='/js/plugins/slimscroll/jquery.slimscroll.min.js'/>"></script>

    <!-- Flot -->
    <script src="<c:url value='/js/plugins/flot/jquery.flot.js'/>"></script>
    <script src="<c:url value='/js/plugins/flot/jquery.flot.tooltip.min.js'/>"></script>
    <script src="<c:url value='/js/plugins/flot/jquery.flot.spline.js'/>"></script>
    <script src="<c:url value='/js/plugins/flot/jquery.flot.resize.js'/>"></script>
    <script src="<c:url value='/js/plugins/flot/jquery.flot.pie.js'/>"></script>

    <!-- Peity -->
    <script src="<c:url value='/js/plugins/peity/jquery.peity.min.js'/>"></script>

    <!-- Custom and plugin javascript -->
    <script src="<c:url value='/js/inspinia.js'/>"></script>
    
    <!-- jQuery UI -->
    <script src="<c:url value='/js/plugins/jquery-ui/jquery-ui.min.js'/>"></script>

    <!-- GITTER -->
    <script src="<c:url value='/js/plugins/gritter/jquery.gritter.min.js'/>"></script>

    <!-- Sparkline -->
    <script src="<c:url value='/js/plugins/sparkline/jquery.sparkline.min.js'/>"></script>

    <!-- ChartJS-->
    <script src="<c:url value='/js/plugins/chartJs/Chart.min.js'/>"></script>

    <!-- Toastr -->
    <script src="<c:url value='/js/plugins/toastr/toastr.min.js'/>"></script>
    <!-- echarts -->
    <script src="<c:url value='/js/plugins/echarts/echarts.js'/>"></script>
	<!-- echarts主题 -->
	<script src="<c:url value='/js/plugins/echarts/theme/macarons.js'/>"></script>
	
	<script src="<c:url value='/js/manage/manage.js'/>"></script>
	
	<script src="<c:url value='/js/plugins/layer/layer.js'/>"></script>
	<script src="<c:url value='/js/common/util.iframe.js'/>"></script>
	<script src="<c:url value='/js/plugins/sweetalert/sweetalert.min.js'/>"></script>
	
    <script>
        $(document).ready(function(){
        	
        	// 菜单参数
        	var menu = ${menu};
        	
        	// 生成菜单到html
        	if(menu != null && menu != "null" && menu != undefined){
        		$("#side-menu").children("li").after(menuBuilder(menu).html());
        	}
        	// 给菜单添加jquery插件
			$('#side-menu').metisMenu();
        	
        	//当前被激活的菜单
			var active = $("ul>li .active");
        	
        	//初始化菜单加载右侧框架页面
        	if(menu != null && menu != "null" && menu != undefined){
        		var liveMenu = null;
    			if(active.size()>1){
    				liveMenu = $("ul>li .active").last();
            	}else{
            		liveMenu = $("ul>li .active");
            	}
    			$("#rightpage").attr("src",liveMenu.children("a").attr("accessKey"));
    			//console.log(liveMenu.children("a").attr("accessKey"));
        	}else{
        		$("#rightpage").attr("src","${pageContext.request.contextPath}/error/204");
        	}
        	
			//给菜单添加自定义点击事件
        	$(".nav>li>a").click(function(){
        		
        		if($(this).attr("node")!="parent"){
    				if(active){
    					active.removeClass("active");
    				}
    				$(this).parent("li").addClass("active");
    				active = $(this).parent("li");
    				
    				var ac = $("ul>li .active");
    				if(ac.length>1){
    					$(ac[0]).removeClass("active");
					}
    			}
        		
        		if($(this).attr("accessKey")!="null"){
        			$("#rightpage").attr("src",$(this).attr("accessKey"));
        			$(".breadcrumb").html(showCurrentMenu($(this)).html());
        		}
        	});
        	//console.log(active);
        	// 初始化右侧页面位置信息
        	$(".breadcrumb").html(showCurrentMenu(active.children("a")).html());
        	
        	// 显示当前时间
        	showtime();
        	
            setTimeout(function() {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 4000
                };
                toastr.success('风暴智盒', '欢迎您的到来！');

            }, 1300);
            
            // auto iframe height
            //auto_iframe("rightpage","iframe-div");
            
            /* $("#rightpage").change(function(){
            	auto_iframe("rightpage","iframe-div");
            	console.log("ok");
            }); */
            
        });

        // 在右侧显示当前菜单位置 使用递归
        function showCurrentMenu(current){
        	var li = $("<li/>");
        	var active = $("ul>li .active");
        	if(active.size()>1){
        		active = $("ul>li .active").last();
        	}
        	if(active.children("a").attr("accessKey")==current.attr("accessKey")){
        		var l = $("<li/>");
        		var strong = $("<strong></strong>").html(current.attr("title"));
        		strong.appendTo(l);
        		l.appendTo(li);
        		var top = current.parent("li").parent("ul").parent("li").children("a");
        		if(top.size()>0){
        			showCurrentMenu(top).children().prependTo(li);
        		}
        	}else{
        		var l = $("<li/>");
       			var a = $("<a/>").attr("href","javascript:void(0);").html(current.attr("title"));
       			a.appendTo(l);
       			l.appendTo(li);
       			var top = current.parent("li").parent("ul").parent("li").children("a");
       			if(top.size()>0){
       				showCurrentMenu(top).children().prependTo(li);
       			}
        	}
        	return li;
        }
        
        // 菜单创建器 使用递归
        function menuBuilder(content){
        	var contentPath = "${pageContext.request.contextPath}";
    		var ul = $("<ul/>");
    		var mapping = ["","","nav nav-second-level","nav nav-third-level collapse","nav nav-four-level","nav nav-five-level"];
    		for(var m = 0;m < content.length;m++){
    			if(content[m].childrens){
    				var a = $("<a/>").attr("accessKey", content[m].accessKey).attr("href","javascript:void(0);").attr("node","parent").attr("title",content[m].title);
    				if(content[m].level<2){
    					var i = $("<i/>").addClass(content[m].leftIconClass);
        				var spanM = $("<span/>").addClass(content[m].titleClass).html(content[m].title);
        				var spanR = $("<span/>").addClass(content[m].rightIconClass);
        				i.appendTo(a);
        				spanM.appendTo(a);
        				spanR.appendTo(a);
    				}else{
    					a.html(content[m].title);
    					var spanR = $("<span/>").addClass(content[m].rightIconClass);
    					spanR.appendTo(a);
    				}
    				var li = $("<li/>").addClass(content[m].className);
    				if(content[m].active){
    					li.addClass("active");
    				}
    				a.appendTo(li);
    				menuBuilder(content[m].childrens).addClass(mapping[content[m].level+1]).appendTo(li);
    				li.appendTo(ul);
    			}else{
    				var a = $("<a/>").attr("accessKey",contentPath + content[m].accessKey).attr("href","javascript:void(0);").attr("title",content[m].title).html(content[m].title);
    				var li = $("<li/>").addClass(content[m].className);
    				if(content[m].active){
    					li.addClass("active");
    				}
    				a.appendTo(li);
    				li.appendTo(ul);
    			}
    		}
    		return ul;
    	}
        	
        // 显示当前时间`
        function showtime() {
        	var now = new Date();
        	var year = now.getFullYear();
        	var month = now.getMonth()+1;
        	var day = now.getDate();
        	var hours = now.getHours();
        	var minutes = now.getMinutes();
        	var seconds = now.getSeconds();
        	var timeValue = "" ;
	        	timeValue += year+"年";
	        	timeValue += month+"月";
	        	timeValue += day+"日";
	        	timeValue += ((hours >= 12) ? " 下午" : " 上午" );
	        	timeValue += ((hours >12) ? hours -12 :hours);
	        	timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
	        	timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
	        	$('#now-time').empty();
	        	$('#now-time').html("现在是北京时间："+timeValue);
	        	timerID = setTimeout("showtime()",1000);
        }
        
        /*
         * 退出登录
         */
        function logout(){
        	var token = $("meta[name='_csrf']").attr("content");
        	var header = $("meta[name='_csrf_header']").attr("content");
        	var form = $("<form></form>");
	            form.attr('action','${pageContext.request.contextPath}/j_spring_security_logout');
	            form.attr('method','post');
	            _csrf = $("<input type='text' name='_csrf' />");
	            _csrf.attr('value',token);
	            _csrf_header = $("<input type='text' name='_csrf_header' />");
	            _csrf_header.attr('value',header);
	            //_loginAccount = $("<input type='text' name='loginAccount' />");
	            //_loginAccount.attr('value',"${user.loginAccount}");
	            form.append(_csrf);
	            form.append(_csrf_header);
	            //form.append(_loginAccount);
	            form.css('display','none');
	            form.appendTo("body");
	            form.submit();
        }
        
    </script>
</body>
</html>
