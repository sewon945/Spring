/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.89
 * Generated at: 2024-06-24 06:12:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1717555033247L));
    _jspx_dependants.put("jar:file:/C:/Users/ggg/Desktop/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/recycle/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>RE+ECO</title>\n");
      out.write("<meta charset=\"UTF-8\" />\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("   content=\"width=device-width, initial-scale=1, user-scalable=no\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/main.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css\"/>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"is-preload\">\n");
      out.write("   <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("      <!-- Header -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("      \n");
      out.write("      <!-- Banner -->\n");
      out.write("      <img src=\"resources/images/noah.jpg\" style=\"width: 100%; height: 775px;\">\n");
      out.write("              \n");
      out.write("      <!-- Highlights -->\n");
      out.write("            <section class=\"wrapper style1\">\n");
      out.write("               <div class=\"container\">\n");
      out.write("                  <div class=\"row gtr-200\">\n");
      out.write("                     <section class=\"col-4 col-12-narrower\">\n");
      out.write("                        <div class=\"box highlight\">\n");
      out.write("                           <i class=\"icon solid major fa-recycle\"></i>\n");
      out.write("                           <h3>정확한 분리 배출법</h3>\n");
      out.write("                           <p>누구나 쉽게 알아볼 수 있는<br>재질별•품목별 분리 배출법 제공</p>\n");
      out.write("                        </div>\n");
      out.write("                     </section>\n");
      out.write("                     <section class=\"col-4 col-12-narrower\">\n");
      out.write("                        <div class=\"box highlight\">\n");
      out.write("                           <i class=\"icon solid major fa-trash\"></i>\n");
      out.write("                           <h3>올바른 처리 방법</h3>\n");
      out.write("                           <p>재밌는 퀴즈를 통해<br>올바른 처리 방법 제공</p>\n");
      out.write("                        </div>\n");
      out.write("                     </section>\n");
      out.write("                     <section class=\"col-4 col-12-narrower\">\n");
      out.write("                        <div class=\"box highlight\">\n");
      out.write("                           <i class=\"icon solid major fa-map\"></i>\n");
      out.write("                           <h3>수거함 위치 제공</h3>\n");
      out.write("                           <p>API를 이용하여 전국적으로<br>다양한 수거함 위치 제공</p>\n");
      out.write("                        </div>\n");
      out.write("                     </section>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </section>      \n");
      out.write("         \n");
      out.write("      <!-- 문구 -->\n");
      out.write("      <section class=\"wrapper style1\">\n");
      out.write("               <div class=\"container\">\n");
      out.write("                  <div class=\"row gtr-200\">\n");
      out.write("                     <section class=\"col-4 col-12-narrower\">\n");
      out.write("                        <div class=\"box highlight\">\n");
      out.write("                           \n");
      out.write("                        </div>\n");
      out.write("                     </section>\n");
      out.write("                     <section class=\"col-4 col-12-narrower\">\n");
      out.write("                        <div class=\"box highlight\">\n");
      out.write("                           <h3>\"플라스틱 없이 사는 건 불가능해요\"</h3>\n");
      out.write("                           <h3>\"일회용품을 하나도 안 쓸 순 없어요\"</h3>\n");
      out.write("                           <p>&nbsp;</p>\n");
      out.write("                           <h3>당신의 친환경 생활,</h3>\n");
      out.write("                           <h3>생각처럼 쉽지 않나요?</h3>\n");
      out.write("                           <p>&nbsp;</p>\n");
      out.write("                           <h3>잘 버리는 일부터</h3>\n");
      out.write("                           <h3>시작 해보는 건 어떨까요?</h3>\n");
      out.write("                           <h3>잘 버리기만 해도 쓰레기는</h3>\n");
      out.write("                           <h3>훌륭한 자원이 된답니다</h3>\n");
      out.write("                        </div>\n");
      out.write("                     </section>\n");
      out.write("                  </div>\n");
      out.write("               </div>\n");
      out.write("            </section>\n");
      out.write("            \n");
      out.write("            <!-- UpDownBtn-->\n");
      out.write("         <div class=\"upBtns\">\n");
      out.write("            <div class=\"moveTopBtn\">↑</div>\n");
      out.write("         </div>\n");
      out.write("\n");
      out.write("         <div class=\"downBtns\">\n");
      out.write("            <div class=\"moveBottomBtn\">↓</div>\n");
      out.write("         </div>   \n");
      out.write("         \n");
      out.write("         <script type=\"text/javascript\">\n");
      out.write("            const topBtn = document.querySelector(\".moveTopBtn\");\n");
      out.write("            \n");
      out.write("            // 버튼 클릭 시 맨 위로 이동\n");
      out.write("             topBtn.onclick = () => {\n");
      out.write("            \n");
      out.write("              window.scrollTo({ top: 0, behavior: \"smooth\" });  \n");
      out.write("            }\n");
      out.write("   \n");
      out.write("            const bottomBtn = document.querySelector(\".moveBottomBtn\");\n");
      out.write("   \n");
      out.write("            // 버튼 클릭 시 페이지 하단으로 이동\n");
      out.write("             bottomBtn.onclick = () => {\n");
      out.write("                \n");
      out.write("              window.scrollTo({ top: document.body.scrollHeight, behavior: \"smooth\" });\n");
      out.write("            };\n");
      out.write("         </script>\n");
      out.write("               \n");
      out.write("         <!-- Footer -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("   <!-- Scripts -->\n");
      out.write("   <script src=\"resources/js/jquery.min.js\"></script>\n");
      out.write("   <script src=\"resources/js/jquery.dropotron.min.js\"></script>\n");
      out.write("   <script src=\"resources/js/browser.min.js\"></script>\n");
      out.write("   <script src=\"resources/js/breakpoints.min.js\"></script>\n");
      out.write("   <script src=\"resources/js/util.js\"></script>\n");
      out.write("   <script src=\"resources/js/main.js\"></script>\n");
      out.write("   \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
