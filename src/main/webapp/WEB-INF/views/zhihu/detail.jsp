<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="${detail.title }">
    <meta name="keywords" content="${detail.title }">
    <link rel="icon" href="/static/favicon.ico">
    <title>${detail.title } | 互联网's 引力波</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/css/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/static/assets/js/ie-emulation-modes-warning.js"></script>

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
        <h1 class="blog-title">互联网's 引力波</h1>
        <p class="lead blog-description">关注互联网，关注生活！</p>
      </div>
      <div class="row">
      	<div class="bdsharebuttonbox col-md-12"><a href="#" class="bds_more" data-cmd="more"></a><a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a><a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a><a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a><a title="分享到人人网" href="#" class="bds_renren" data-cmd="renren"></a></div>
		<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"${detail.title }","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
      </div>
      <div class="row">
        <div class="col-sm-12 blog-main">
		  	<div class="blog-post">
		  		<h2 class="blog-post-title">${detail.title }</h2>
		  		${detail.body }
		  	</div>
        </div><!-- /.blog-main -->
      </div><!-- /.row -->
    </div><!-- /.container -->

    <c:import url="../footer.jsp"/>
    
    <script type="text/javascript"> 
     /*插屏*/ 
     var cpro_id = "u2565571";
	</script>
	<script src="http://cpro.baidustatic.com/cpro/ui/cm.js" type="text/javascript"></script>
	
  </body>
</html>
