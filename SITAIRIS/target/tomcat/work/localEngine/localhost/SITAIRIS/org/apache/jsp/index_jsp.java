package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("    \n");
      out.write("    <TITLE>Использование JavaServer Pages</TITLE>\n");
      out.write("    <META NAME=\"author\" CONTENT=\"...\">\n");
      out.write("    <META NAME=\"keywords\"\n");
      out.write("          CONTENT=\"JSP,JavaServer Pages,servlets\">\n");
      out.write("    <LINK REL=STYLESHEET\n");
      out.write("          HREF=\"My-Style-Sheet.css\"\n");
      out.write("          TYPE=\"text/css\">\n");
      out.write("</HEAD>\n");
      out.write("<BODY BGCOLOR=\"#CB979D\" TEXT=\"#000000\" LINK=\"#0000EE\"\n");
      out.write("      VLINK=\"#551A8B\" ALINK=\"#FF0000\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        Дата открытия страницы: ");
      out.print( new Date() );
      out.write("\n");
      out.write("        ");

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("Students.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();
            out.println("<h3>Список студентов школы:</h3>");
            out.println();
            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                // Если нода не текст, то это книга - заходим внутрь
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            out.println("<p>" + bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent() + "</p>");
                        }
                    }
                    out.println("--------------------------------");
                }}
      out.write("\n");
      out.write("        <HR>\n");
      out.write("        ");

            out.println("Example 1 - Печать всех элементов NAME");
            XPathFactory pathFactory = XPathFactory.newInstance();
            XPath xpath = pathFactory.newXPath();

            // Пример записи XPath
            // Подный путь до элемента
            //XPathExpression expr = xpath.compile("BookCatalogue/Book/Cost");
            // Все элементы с таким именем
            //XPathExpression expr = xpath.compile("//Cost");
            // Элементы, вложенные в другой элемент
            XPathExpression expr = xpath.compile("//PERSON/NAME");

            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                out.println("<p>Value:" + n.getTextContent() + "</p>");
            }
            out.println();
        
      out.write("\n");
      out.write("\n");
      out.write("</UL>\n");
      out.write("</BODY>\n");
      out.write("</HTML>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
