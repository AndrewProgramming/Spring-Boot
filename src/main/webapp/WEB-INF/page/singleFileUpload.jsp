<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>文件上传</title>
</head>
<body>
	<h2>单文件上传示例</h2>
	<hr />

	<form action="/upload/singleFileUpload.action" method="POST"
		enctype="multipart/form-data">

		<p>
			文件：<input type="file" name="file"/>
		</p>
		<p>
			<input type="submit" value="上传" />
		</p>

	</form>

</body>
</html>