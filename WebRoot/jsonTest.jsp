<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function requestJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/requestJson.action',
			contentType:'application/json;charset=utf-8',
			data:'{"id":1, "name":"手机", "price":666}',
			success:function(data){
				alert(data.name);
			}
		});
	}
	function responseJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/responseJson.action',
			// 请求key/value，不需要指定contentType，默认就是key/value
			//contentType:'application/json;charset=utf-8',
			data:'id=2&price=666',
			success:function(data){
				alert(data.name);
			}
		});
	}
</script>
</head>
<body>
	<input type="button" onclick="requestJson()" value="请求json，输出json"/>
	<input type="button" onclick="responseJson()" value="请求KV，输出json"/>
</body>
</html>