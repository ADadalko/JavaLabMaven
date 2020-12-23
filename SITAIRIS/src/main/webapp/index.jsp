<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <%@ page contentType="text/html;charset=utf-8" %>
    <TITLE>Использование JavaServer Pages</TITLE>
    <META NAME="author" CONTENT="...">
    <META NAME="keywords"
          CONTENT="JSP,JavaServer Pages,servlets">
    <LINK REL=STYLESHEET
          HREF="My-Style-Sheet.css"
          TYPE="text/css">
</HEAD>
<BODY BGCOLOR="#663399" TEXT="#000000" LINK="#0000EE"
      VLINK="#551A8B" ALINK="#FF0000">
        <%@ page import = "java.util.*" %>
        <%@ page import="javax.xml.parsers.DocumentBuilder" %>
        <%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
        <%@ page import="org.w3c.dom.Document" %>
        <%@ page import="org.w3c.dom.Node" %>
        <%@ page import="org.w3c.dom.NodeList" %>
        <%@ page import="javax.xml.xpath.XPathFactory" %>
        <%@ page import="javax.xml.xpath.XPath" %>
        <%@ page import="javax.xml.xpath.XPathExpression" %>
        <%@ page import="javax.xml.xpath.XPathConstants" %>
        Дата открытия страницы: <%= new Date() %>
        <%
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("Students.xml");

            Node root = document.getDocumentElement();
            out.println("<h3>Список студентов школы:</h3>");
            out.println();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            out.println("<p>" + bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent() + "</p>");
                        }
                    }
                    out.println("--------------------------------");
                }}%>
        <HR>
        <%
            out.println("Example 1 - Печать всех элементов NAME");
            XPathFactory pathFactory = XPathFactory.newInstance();
            XPath xpath = pathFactory.newXPath();

            XPathExpression expr = xpath.compile("//PERSON/NAME");

            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                out.println("<p>Value:" + n.getTextContent() + "</p>");
            }
            out.println();
        %>

</UL>
</BODY>
</HTML>