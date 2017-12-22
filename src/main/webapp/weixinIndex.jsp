<%@ page language="java" pageEncoding="UTF-8"%>  
  

<html>
<head>
    <meta charset="UTF-8">
    <title>微信测试</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no"/>
    <meta content="telephone=no" name="format-detection"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <style type="text/css">
    	.showImg1{width: 80%;height: 200px;margin:0 auto;}
    	.showImg1 img{width: 100%;}
    </style>
</head>
<body>
	<form action="/upload.htm" method="post" enctype="multipart/form-data">
		<input type="file" class="img1" name="imageUpload" accept="image/*" ><!-- capture="camera" -->
		
		<input type="file" class="img2" name="imageUpload" accept="image/*" ><!-- capture="camera" -->
	<button type="submit">上传</button>
	
	</form>
	<div class="showImg1" style=""></div> 
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(".img1").on('change', function () {
		 
		    if (typeof (FileReader) != "undefined") {
		 
		        var image_holder = $(".showImg1");
		        image_holder.empty();
		 
		        var reader = new FileReader();
		        reader.onload = function (e) {
		            $("<img />", {
		                "src": e.target.result,
		                "class": "thumb-image"
		            }).appendTo(image_holder);
		 
		        }
		        image_holder.show();
		        reader.readAsDataURL($(this)[0].files[0]);
		    } else {
		        alert("你的浏览器不支持FileReader.");
		    }
		});
	</script>
</body>
</html>