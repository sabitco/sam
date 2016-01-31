<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><jsp:invoke fragment="title"/></title>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
  <script src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
  <script src="<c:url value='/static/js/physicalactivity/app.js' />"></script>
  <script>
    $(function(){           
      if (!Modernizr.inputtypes.date) {
        $('input[type=date]').datepicker({
          dateFormat : 'yy-mm-dd'
        },
        $.datepicker.regional['es']
      );
     }
    });
  </script>
</head>
<body ng-app="physicalactivity">
  <jsp:doBody/>
</body>
</html>