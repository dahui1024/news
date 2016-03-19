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
    <meta name="keywords" content="互联网,新闻,快报,网易新闻,今日头条,门牙娱乐,暴走漫画">
    <link rel="icon" href="/static/favicon.ico">
    <title>门牙娱乐  | 互联网's 引力波</title>
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
    <c:import url="../header.jsp"></c:import>

    <div class="container">
      <div class="blog-header">
        <h1 class="blog-title">门牙视频</h1>
        <p class="lead blog-description">关注互联网，关注生活！</p>
      </div>
      
      <div class="row">
        <div class="col-sm-12 blog-main">
		  <c:forEach items="${list }" var="n" varStatus="index">
		  	<div class="blog-post">
		  		<h3 class="blog-post-title">${index.index+1 }：
		  			<a href="javascript:void(0)" onclick="view('${n.id}','${n.title }',${n.w },${n.h },'${n.length }')">${n.title }</a><small>${n.length }</small>
		  		</h3>
	            <a href="/miaopai/video/${n.id}?title='${n.title }'&w=${n.w }&h=${n.h }&length=${n.length }"><img src="${n.img}" alt="${n.title }" alt="${n.title }" class="img-responsive"></a>
		  	</div>
		  	<hr>
		  </c:forEach>

        </div><!-- /.blog-main -->

      </div><!-- /.row -->

    </div><!-- /.container -->
	
    <c:import url="../footer.jsp"/>
    <script type="text/javascript">
    	function view(id,title,w,h,length){
    		location.href="/miaopai/video/"+id+"?title="+encodeURIComponent(title)+"&length="+length;
    		
    	}
    
    </script>
  </body>
</html>
