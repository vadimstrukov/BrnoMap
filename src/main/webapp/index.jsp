<%@ page import="cz.brno.map.HttpHelper" %>
<html>

<head>
    <title>BrnoMap</title>
</head>
<body>

<%-- START --%>
<%
    HttpHelper helper = new HttpHelper();
    out.print(helper.getBody());
%>
<%-- END --%>

</body>
</html>