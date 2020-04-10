<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/3
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/requestDemo2" method="post">
  <table>

    <tr>
      <td>用户编号：</td>
      <td><input type="text" name="uesrid"></td>
    </tr>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>用户密码：</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td>用户性别：</td>
      <td>
        <input type="radio" name="gender" value="男" checked="checked">男
        <input type="radio" name="gender" value="女" >女
      </td>
    </tr>
    <tr>
      <td>用户的兴趣爱好：</td>
      <td>
        <input type="checkbox" name="hobby" value="游戏" checked="checked">游戏
        <input type="checkbox" name="hobby" value="篮球" >篮球
        <input type="checkbox" name="hobby" value="唱歌" >唱歌
        <input type="checkbox" name="hobby" value="跳舞" >跳舞
        <input type="checkbox" name="hobby" value="编程" checked="checked">编程
      </td>
    </tr>
    <tr>
      <td>用户专业：</td>
      <td>
        <select name="speciality">
          <option value="软件工程">软件工程</option>
          <option value="机电工程">机电工程</option>
          <option value="网络工程">网络工程</option>
          <option value="计算机科学与技术">计算机科学与技术</option>
          <option value="信息安全">信息安全</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>用户个人介绍：</td>
      <td>
        <textarea name="resum" rows="10" cols="50"></textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="注册">&nbsp;&nbsp;<input type="reset" value="重置"></td>
    </tr>

  </table>
  </form>
  </body>
</html>
