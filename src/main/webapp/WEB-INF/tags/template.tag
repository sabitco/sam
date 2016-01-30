<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><jsp:invoke fragment="title"/></title>
</head>
<body>
  <jsp:doBody/>
</body>
</html>