<%@ page import="java.util.List" %>
<%@ page import="com.xufeng.user.User" %>
<%@ page import="java.util.ArrayList" %><%--
JSP实质是HTML+jS+CSS+java的混合文件
当服务器接收到一个后缀是jsp的请求时，将该请求交给jsp引擎处理，每个jsp页面第一次被访问的时候，jsp引擎会将它翻译成一个
servlet文件，再由web容器调用servlet，完成响应。
单纯从开发角度看，jsp就是在html中嵌入java程序，具体嵌入方式有三种；
1、JSP脚本：执行java逻辑代码（可以调用方法，不能定义方法）
  <% java代码 %>
2、JSP声明：定义JAVA方法（只能定义，不能调用）
  <%!
    <方法>
  %>
3、JSP表达式：把java对象直接输出到HTML页面中
  <%=java变量%>

--%>
<%--
JSP内置对象（9个）：
**request:表示一次请求，由HttpServletRequest类产生
*response：表示一次响应，由HttpServletResponse类产生
*pageContext：页面上下文，获取页面信息，PageContext
*session:表示一次会话，保存用户信息，HttpSession
*application:表示当前的Web应用，全局对象，保存所有用户共享信息，ServletContext
config:当前JSP对应的servlet的ServletConfig对象，获取当前Servlet的信息，ServletConfig
out：向浏览器输出数据,JspWriter
page:当前JSP对应的Servlet对象，Servlet
exception:表示JSP页面发生的异常，Exception

request常用的方法:
  String getParameter(String key)获取客户端传来的参数
  void setAttribute(String key,Object value)通过键值对的形式保存数据
  Object getAttribute(String key)通过key取出value
  RequestDispatcher getRequestDispatcher(String path)返回一个RequestDispatcher对象，该对象的forward方法用于请求转发
  String[] getParameterValues()
  void setCharacterEncoding(String charset)指定每个请求的编码
  ##Http请求的状态码：
  400：请求类型不匹配
  500：java程序抛出异常

response常用方法：
  sendRedirect(String path)重定向方法
  转发getRequestDispatcher和重定向sendRedirect的区别：
  转发是将同一个请求传入给下一个页面，重定向是创建一个新的请求传给下一个页面，
  之前的请求结束生命周期
  转发：同一个请求在服务器之间传递，地址栏不变，也叫服务器跳转
  重定向：有客户端发送一次新的请求来访问跳转后的目标资源，地址栏改变，也叫客户端跳转
  如果两个页面之间需要通过request来传值，则必须使用转发，不能使用重定向



--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/15
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--
  <table >
    <tr>
      <th>姓名</th>
      <th>年龄</th>
    </tr>
    <%
      List<User> list=new ArrayList<>();
      list.add(new User("张三",21));
      list.add(new User("李四",22));
      list.add(new User("王五",23));

      for(int i=0;i<list.size();i++){
    %>
    <tr>
      <td><%=list.get(i).getName()%></td>
      <td><%=list.get(i).getAge()%></td>
    </tr>
    <%
      }
    %>
    --%>
    <%
      String sessionID=session.getId();
      int interval=session.getMaxInactiveInterval();

    %>
    <%=sessionID%>
    <%=interval%>
  </table>
  </body>
</html>
