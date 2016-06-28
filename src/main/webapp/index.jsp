<%@ page import="cz.brno.map.HttpHelper" %>
<%@ page import="org.xml.sax.SAXException" %>
<%@ page import="javax.xml.parsers.ParserConfigurationException" %>
<%@ page import="javax.xml.xpath.XPathExpressionException" %>
<%@ page import="cz.brno.map.model.ItemEntity" %>
<%@ page import="javax.xml.bind.JAXBException" %>
<html>

<head>
    <title>BrnoMap</title>
</head>
<body>

<%-- START --%>
<%
    HttpHelper helper = new HttpHelper();
    try {
        for (ItemEntity item : helper.getBody().getEntityList()) {
          %><p><%out.println(item);%></p><%
        }
    } catch (JAXBException e) {
        e.printStackTrace();
    }
%>
<%-- END --%>

</body>
</html>