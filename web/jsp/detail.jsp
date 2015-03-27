<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.jintaimei.common.util.SpringContextsUtil"%>
<%@page import="com.jintaimei.support.bean.*"%>
<%@page import="java.util.List"%>    
<%@page import="com.jintaimei.support.view.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广东金钛镁铝业</title>
<meta name="keywords" content="广东金钛镁铝业,推拉门铝材 平开门铝材" /> 
<meta name="description" content="广东金钛镁铝业专业经营拼格门铝材，中空推拉门铝材，平开门铝材。总部位于广东佛山大沥兴贤第二工业园，是铝门行业不可或缺的中坚力量。公司为开拓北方市场，在石家庄正定设立分部，以超实惠的价格，广东一流的产品质量为广大北方客户服务。公司全体员工竭诚欢迎您咨询及洽谈合作。" />
<link rel="stylesheet" type="text/css" media="all" href="../css/style.css">
<link rel="stylesheet" type="text/css" media="all" href="../css/grid.css">
<link rel="stylesheet" type="text/css" media="all" href="../css/prettyPhoto.css">
<link rel="stylesheet" id="contact-form-7-css" href="../css/styles.css" type="text/css" media="all">
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script><style type="text/css">.cf-hidden { display: none; } .cf-invisible { visibility: hidden; }</style>
<script type="text/javascript" src="../js/superfish.js"></script>
<script type="text/javascript" src="../js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="../js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="../js/jquery.loader.js"></script>
<script type="text/javascript" src="../js/comment-reply.js"></script>
<link rel="stylesheet" type="text/css" href="../css/social_widget.css">
<script type="text/javascript">
  	// initialise plugins
		jQuery(function(){
			// main navigation init
			jQuery('ul.sf-menu').superfish({
				animation:   {opacity:'show', height:'show'},
				autoArrows:  false,                           // disable generation of arrow mark-up 
        		dropShadows: false                            // disable drop shadows 
			});
			
		});
</script>

</head>
<body class="page page-id-2 page-template page-template-page-about-php">
	<div id="main">
		<header>
				<div class="container_24">
			<div class="logo">
				<h2>
					<a href=""
						title="Interior and Furniture">金钛镁</a>
				</h2>
			</div>
			<nav class="primary">
			<ul id="topnav" class="sf-menu sf-js-enabled">
				<li id="menu-item-32"
					class="menu-item menu-item-type-post_type menu-item-32"><a
					href="index.jsp">展示中心</a></li>
				<li id="menu-item-77"
					class="menu-item menu-item-type-post_type current-menu-item page_item page-item-72 current_page_item menu-item-77"><a
					href="project.jsp">产品中心</a>
					<ul class="sub-menu" style="display: none; visibility: hidden;">
						<li id="menu-item-95"
							class="menu-item menu-item-type-post_type menu-item-95"><a
							href="#">铝合金</a></li>
						<li id="menu-item-94"
							class="menu-item menu-item-type-post_type menu-item-94"><a
							href="#">铝合金配件</a></li>
					</ul></li>
				<li id="menu-item-7"
					class="menu-item menu-item-type-post_type menu-item-7"><a
					href="aboutus.jsp">关于我们</a></li>
				<li id="menu-item-59"
					class="menu-item menu-item-type-post_type menu-item-59"><a
					href="contactus.jsp">联系我们</a></li>
			</ul>
			</nav>
		</div>
		</header>
		<%
			String path = request.getContextPath();
			String projectId = request.getParameter("pid");
			ProjectInfoPr pr = (ProjectInfoPr) SpringContextsUtil.getBean("projectInfoPr"); 
			List<ProjectImg> list = pr.getProImg(projectId);
			List<ProjectDesc> descList = pr.getProDesc(projectId);
		%>
		<div class="primary_content_wrap">
			<div class="container_24 clearfix">
				<div id="content" class="grid_16 suffix_1">
					<div class="indent">
						<div id="post-136" class="post-136 portfolio type-portfolio hentry post">
							<article class="single-post">
								<h1>图片详情</h1>
								<div class="">
									
									<%
										for(ProjectImg pi : list){ %>
											<img  src="<%=path+pi.getImgFile() %>" class="attachment-post-thumbnail wp-post-image" style="margin-bottom: 20px">
									<%
										}	
									%>
								</div> 
							</article>
						</div> 
					</div>
				</div> 
				<aside id="sidebar" class="grid_7">
					<div id="my_cyclewidget-5" class="widget"> <h3>简介</h3>
						<ul class="post_cycle">
							<% 
								for(ProjectDesc pd : descList){ %>
									<li class="cycle_item">
										<h4><a href="#"><%=pd.getTitle() %></a></h4>
											<label><%=pd.getContent() %></label> 
									</li>
							<%	
								}
							%>
<!-- 							<li class="cycle_item"> -->
<!-- 								<h4><a href="#">保 质 期</a></h4> -->
<!-- 									<label>铝合金永不生锈，非自然灾害、非人为，主材保用20年（只要玻璃不破，都可以长期使用）！</label>  -->
<!-- 							</li> -->
<!-- 							<li class="cycle_item"> -->
<!-- 								<h4><a href="#">适用场所</a></h4> -->
<!-- 									<label>广泛适合于厨房 书房，房间隔断等 </label> -->
<!-- 							</li> -->
<!-- 							<li class="cycle_item"> -->
<!-- 								<h4><a href="#">铝 合 金</a></h4> -->
<!-- 									<label>铝合金门是将表面处理过的铝合金型材，经过开料、打孔、铣槽、攻丝、制作等加工流程制作成门框、门扇构件，再用连接件、密封材料和开闭五金配件一起组合拼装而成的整套门。</label>  -->
<!-- 							</li> -->
<!-- 							<li class="cycle_item"> -->
<!-- 								<h4><a href="#">玻   璃</a></h4> -->
<!-- 									<label>普通玻璃4+4mm。有磨沙，蒙沙，格条，镜花，白玻等优美的工艺玻璃，让您的空间充满艺术感及幽雅的格调！玻璃款式可以随便搭配喜欢什么款式就订做什么款式。     钢化玻璃每平方成本高30元。 钢化玻璃强度是普通玻璃的3~5倍，可承受一定能量的外来撞击或温差变化而不破碎，即使破碎，也是整块玻璃碎成类似蜂窝状钝角小颗粒，不易伤人 。</label>   -->
<!-- 							</li> -->
						</ul>
					</div>   
				</aside> 
			</div> 
		</div>
			
		
		
		<<footer id="footer">
		<div class="container_24">
			<div id="widget-footer" class="clearfix">
				<div id="categories-4" class="grid_5 suffix_2">
					<h3>联系方式</h3>
					<ul>
						<li class="cat-item cat-item-6"><a
							href="#"
							title="电话:0311-86335588">电话:&nbsp;&nbsp;&nbsp;0311-86335588</a></li>
						<li class="cat-item cat-item-17"><a
							href="#"
							title="传真:0311-88756660">传真:&nbsp;&nbsp;&nbsp;0311-88756660</a></li>
						<li class="cat-item cat-item-14"><a
							href="#"
							title="QQ:18832132988">&nbsp;&nbsp;QQ:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;18832132988</a></li>
					</ul>
				</div>
				<div id="nav_menu-5" class="grid_5 suffix_2">
					<h3>地址</h3>
					<div class="menu-our-tips-container">
						<ul id="menu-our-tips" class="menu">
							<li id="menu-item-169"
								class="menu-item menu-item-type-custom menu-item-169"><a
								href="#">石家庄市正定新区森通建材市场12-24号</a></li>
							<li id="menu-item-170"
								class="menu-item menu-item-type-custom menu-item-170"></li>
						</ul>
					</div>
				</div>
				<div id="text-2" class="grid_10">
					<h3>联系我们</h3>
					<div class="textwidget">
						<div class="wpcf7" id="wpcf7-f3-w1-o1">
							<form action="" id="guestbook_f"
								method="post" class="wpcf7-form">
								<div style="display: none;">
									<input type="hidden" name="_wpcf7" value="3"> <input
										type="hidden" name="_wpcf7_version" value="2.4.3"> <input
										type="hidden" name="_wpcf7_unit_tag" value="wpcf7-f3-w1-o1">
								</div>
								<p class="field">
									<span class="wpcf7-form-control-wrap email-807"><input id="phone_m"
										type="text" name="phone_m" value=""
										class="wpcf7-text wpcf7-validates-as-email wpcf7-validates-as-required wpcf7-use-title-as-watermark watermark"
										size="40" title="您的联系方式:"></span>
								</p>
								<p class="field">
									<span class="wpcf7-form-control-wrap textarea"><textarea id="content_m"
											name="content_m"
											class="wpcf7-use-title-as-watermark watermark" cols="40"
											rows="10" title="您的留言:"></textarea></span>
								</p>
								<p class="submit-wrap">
									<input type="button" value="提交" class="wpcf7-submit" onclick="submit_form()" ><img
										class="ajax-loader" style="visibility: hidden;"
										alt="Sending ..." src="../images/ajax-loader.gif">
								</p>
								<div class="wpcf7-response-output wpcf7-display-none"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="copy wrapper">
				<div class="fleft">
					金钛镁 © 2015&nbsp; |&nbsp; <a
						href="#">保留所有权利</a><br>
				</div>
				<div class="fright f_email">
					E-mail: <a href="mailto:18832132988@qq.com">18832132988@qq.com</a>
				</div>
			</div>
		</div>
		</footer>
	</div>
	<script type="text/javascript"
		src="../js/jquery.form.js"></script>
	<script type="text/javascript"
		src="../js/scripts.js"></script>
	
	<script type="text/javascript">
		function submit_form(){
			var phone = $("#phone_m").val();
			var content = $("#content_m").val();
			if(!phone && !content){
				alert("留言信息请填写完整!");
			} else {
				$("#guestbook_f").attr("action", "<%=path%>/MessageServlet");
		        document.getElementById("guestbook_f").submit(); 
			}
		}
	</script>


</body>
</html>