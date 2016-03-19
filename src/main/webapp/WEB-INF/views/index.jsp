<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="互联网's 引力波，关注互联网，关注生活！">
    <meta name="keywords" content="互联网,新闻,快报,网易新闻,今日头条,知乎日报">
    <link rel="icon" href="/static/favicon.ico">
    <title>互联网's 引力波</title>
    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="static/css/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="static/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	
    <c:import url="header.jsp"></c:import>

    <div class="container">
      <div class="blog-header">
        <h1 class="blog-title">互联网's 引力波</h1>
        <p class="lead blog-description">关注互联网，关注生活！</p>
      </div>
      
      <div class="row">
        <div class="col-sm-12 blog-main">
		  <c:forEach items="${news }" var="n" varStatus="index">
		  	<div class="blog-post">
		  		<h2 class="blog-post-title">${index.index+1 }：
		  			<c:if test='${empty n.url}'><a href="/neatease/photo/${n.photosetID}">${n.title }</a></c:if>
		  			<c:if test='${!empty n.url}'><a href="/neatease/post/${n.postid}">${n.title }</a></c:if>
		  		<small>【${n.votecount}】</small></h2>
		  		<p class="blog-post-meta">${n.ptime} <a href="#">${n.source}</a></p>
		  		<blockquote>
	              <p><a href="/neatease/post/${n.postid}">${n.digest }</a></p>
	            </blockquote>
	            <img src="${n.imgsrc}" alt="${n.title }" class="img-responsive">
		  	</div>
		  	<hr>
		  </c:forEach>

        </div><!-- /.blog-main -->

      </div><!-- /.row -->

    </div><!-- /.container -->

	<c:import url="footer.jsp"/>
    
    <script>
		var baiduImagePlus = {
			noLogo : true,
			unionId : 'u2555202',
			formList : [ {
				formId : 10
			}, {
				formId : 3
			} ]
		};
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/i.js"></script>
  </body>
</html>
