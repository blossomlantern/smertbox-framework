<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
	function setIframeHeight(id) {
		try {
			var iframe = document.getElementById(id);
			if (iframe.attachEvent) {
				iframe
						.attachEvent(
								"onload",
								function() {
									iframe.height = iframe.contentWindow.document.documentElement.scrollHeight;
								});
				return;
			} else {
				iframe.onload = function() {
					iframe.height = iframe.contentDocument.body.scrollHeight;
				};
				return;
			}
		} catch (e) {
			throw new Error('setIframeHeight Error');
		}
	}
</script>
</html>